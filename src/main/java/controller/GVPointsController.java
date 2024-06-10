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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import DAO.LOPTINCHIDAO;
import bean.DANGKY;

@Controller
@RequestMapping("teacher")
@Transactional
public class GVPointsController {
    @Autowired
    private LOPTINCHIDAO ltcDAO;

    @Autowired
    private SessionFactory sessionFactory;
    
    @RequestMapping("points")
    public String points(ModelMap model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String MAGV = (String) session.getAttribute("username");

        model.addAttribute("listDiem", ltcDAO.getAllDangkyTheoMAGV(MAGV));
        return "teacher/points";
    }

    @RequestMapping("setpointval")
    public String editPoint(@RequestParam("masv") String masv, @RequestParam("maltc") String maltc,RedirectAttributes redirectAttributes, HttpServletRequest request) {
        HttpSession session = request.getSession();
        int maltcInt = Integer.parseInt(maltc);
        DANGKY dangky = ltcDAO.getDiemTheoKey(maltcInt, masv);

        session.setAttribute("choosenpoint", dangky);
        return "redirect:pointupdater.htm";
    }

    @RequestMapping("pointupdater")
    public String pointUpdater(ModelMap model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        DANGKY dangky = (DANGKY) session.getAttribute("choosenpoint");
        model.addAttribute("choosenpoint", dangky);
        return "teacher/pointupdater";
    }

    @RequestMapping("editPoint")
    public String editPoint(@ModelAttribute("choosenpoint") DANGKY dangky, RedirectAttributes redirectAttributes) {
        Session session1 = sessionFactory.openSession();
        Transaction t = session1.beginTransaction();

        try {
            session1.update(dangky);
            t.commit();
            redirectAttributes.addFlashAttribute("message", "Cập nhật điểm thành công!");
        } catch (Exception e) {
            t.rollback();
            redirectAttributes.addFlashAttribute("message", "Cập nhật điểm thất bại!");
        }
        finally{
            session1.close();
        }

        return "redirect:points.htm";
    }
}