package controller;

import java.util.List;

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

import DAO.HOCPHIDAO;
import bean.CT_DONGHOCPHI;
import bean.CT_DONGHOCPHI.CT_DONGHOCPHIID;
import bean.HOCPHI;

@Controller
@RequestMapping("teacher")
public class GVFeeController {
    @Autowired
    private HOCPHIDAO hocPhiDAO;

    @Autowired
    private SessionFactory sessionFactory;
    
    @RequestMapping("fee")
    public String fee(ModelMap model) {
        List<HOCPHI> fees = hocPhiDAO.getHocPhi();
        model.addAttribute("fees", fees);
        
        for(int i = 0; i<fees.size(); i++) {
            if(hocPhiDAO.isPaid(fees.get(i).getHocPhiId().getMASV(), fees.get(i).getHocPhiId().getNIENKHOA(), fees.get(i).getHocPhiId().getHOCKY())) {
                model.addAttribute("isPaid" + i, true);
            } else {
                model.addAttribute("isPaid" + i, false);
            }
        }
        return "teacher/fee";
    }

    @Transactional
    @RequestMapping("paid")
    public String paid(@RequestParam("masv") String maSV, @RequestParam("nienkhoa") String nienKhoa, @RequestParam("hocky") int hocKy, RedirectAttributes ra) {
        HOCPHI hp = hocPhiDAO.getHocPhi(maSV, nienKhoa, hocKy);
        CT_DONGHOCPHI ctdhp = new CT_DONGHOCPHI();
        ctdhp.setID(new CT_DONGHOCPHIID(maSV, nienKhoa, hocKy, new java.util.Date()));
        ctdhp.setSOTIENDONG(hp.getHOCPHI());

        Session ses = sessionFactory.openSession();
        Transaction t = ses.beginTransaction();
        try {
            ses.save(ctdhp);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            ra.addFlashAttribute("message", "Đã có lỗi xảy ra");
            return "redirect:/teacher/fee.htm";
        } finally {
            ses.close();
        }
        return "redirect:/teacher/fee.htm";

    }

    @Transactional
    @RequestMapping("depaid")
    public String depaid(@RequestParam("masv") String maSV, @RequestParam("nienkhoa") String nienKhoa, @RequestParam("hocky") int hocKy, RedirectAttributes ra) {
        CT_DONGHOCPHI ctdhp = hocPhiDAO.getCTDongHocPhi(maSV, nienKhoa, hocKy);

        Session ses = sessionFactory.openSession();
        Transaction t = ses.beginTransaction();
        try {
            ses.delete(ctdhp);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            ra.addFlashAttribute("message", "Đã có lỗi xảy ra");
            return "redirect:/teacher/fee.htm";
        } finally {
            ses.close();
        }
        return "redirect:/teacher/fee.htm";

    }
}
