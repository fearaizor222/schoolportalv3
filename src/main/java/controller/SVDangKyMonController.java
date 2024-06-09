package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import DAO.LOPTINCHIDAO;
import DAO.SETTINGSDAO;
import DAO.SINHVIENDAO;
import bean.DANGKY;
import bean.LOPTINCHI;
import bean.SINHVIEN;

@Controller
@RequestMapping("student")
public class SVDangKyMonController {
    @Autowired
    private LOPTINCHIDAO LTCDAO;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SETTINGSDAO SETTINGS;

    @Autowired
    private SINHVIENDAO SINHVIENDAO;

    @RequestMapping("dangkymon")
    public String dangkymon(ModelMap model, HttpServletRequest request) {
        String nienkhoa = SETTINGS.getNIENKHOA();
        int hocky = SETTINGS.getHOCKY();

        HttpSession session = request.getSession();
        session.setAttribute("nienkhoa", nienkhoa);
        session.setAttribute("hocky", hocky);

        model.addAttribute("ltc", LTCDAO.getAllLopTinChiCurrent(nienkhoa, hocky));
        return "student/dangkymon";
    }

    @Transactional
    @RequestMapping("dangky")
    public String dangky(@RequestParam("maltc") String maltc, HttpServletRequest request,
            RedirectAttributes redirectAttributes) {
        boolean dangkymon = SETTINGS.getDANGKYMON();
        if (!dangkymon) {
            redirectAttributes.addFlashAttribute("message", "Đăng ký môn không mở");
            return "redirect:dangkymon.htm";
        }
        int MALTC = Integer.parseInt(maltc);
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        String masv = (String) request.getSession().getAttribute("username");

        DANGKY newDangky = new DANGKY();
        newDangky.setID(new DANGKY.DANGKYID(MALTC, masv));
        newDangky.setDIEM_CC(0);
        newDangky.setDIEM_GK(0);
        newDangky.setDIEM_CK(0);
        newDangky.setHUYDANGKY(false);

        LOPTINCHI loptinchi = (LOPTINCHI) session.get(LOPTINCHI.class, MALTC);
        SINHVIEN me = (SINHVIEN) session.get(SINHVIEN.class, masv);

        newDangky.setLoptinchi(loptinchi);
        newDangky.setSinhVien(me);

        if(!SINHVIENDAO.isDangKyDuoc(masv, loptinchi)){
            redirectAttributes.addFlashAttribute("message", "Đã đăng ký môn này");
            return "redirect:dangkymon.htm";
        }

        try {
            session.save(newDangky);
            t.commit();
            redirectAttributes.addFlashAttribute("message", "Đăng ký thành công");
        } catch (Exception e) {
            t.rollback();
            redirectAttributes.addFlashAttribute("message", "Đăng ký không thành công");
        } finally {
            session.close();
        }
        return "redirect:dangkymon.htm";
    }

    @Transactional
    @RequestMapping("huydangky")
    public String huydangky(@RequestParam("maltc") String maltc, HttpServletRequest request,
            RedirectAttributes redirectAttributes) {
        boolean dangkymon = SETTINGS.getDANGKYMON();
        if (!dangkymon) {
            redirectAttributes.addFlashAttribute("message", "Đăng ký môn không mở");
            return "redirect:dangkymon.htm";
        }
        int MALTC = Integer.parseInt(maltc);
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        String masv = (String) request.getSession().getAttribute("username");

        DANGKY dangkyToRemove = (DANGKY) session.get(DANGKY.class, new DANGKY.DANGKYID(MALTC, masv));

        try {
            session.delete(dangkyToRemove);
            t.commit();
            redirectAttributes.addFlashAttribute("message", "Hủy đăng ký thành công");
        } catch (Exception e) {
            t.rollback();
            redirectAttributes.addFlashAttribute("message", "Hủy đăng ký không thành công");
        }

        return "redirect:dangkymon.htm";
    }
}
