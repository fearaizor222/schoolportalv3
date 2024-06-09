package controller;

import java.util.List;

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

import DAO.THONGBAODAO;
import bean.THONGBAO;

@RequestMapping("teacher")
@Controller
@Transactional
public class GVAnnouncementController {
    @Autowired
    private THONGBAODAO thongbaoDAO;

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("announcement")
    public String announcement(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<THONGBAO> items = thongbaoDAO.getAllThongBao();
        for (int i = 0; i < items.size(); i++) {
            session.setAttribute("tb" + i, items.get(i));
        }
        session.setAttribute("items", items);
        return "teacher/announcement";
    }

    @RequestMapping("deletetb")
    public String deletetb(@RequestParam("modelAttribute") String thistb, HttpServletRequest request,
            RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        THONGBAO tb = (THONGBAO) session.getAttribute(thistb);

        Session session1 = sessionFactory.openSession();
        Transaction t = session1.beginTransaction();

        try {
            session1.delete(tb);
            t.commit();
            redirectAttributes.addFlashAttribute("message", "Xóa thông báo thành công!");
        } catch (Exception e) {
            t.rollback();
            redirectAttributes.addFlashAttribute("message", "Xóa thông báo thất bại!");
        }
        finally{
            session1.close();
        }

        return "redirect:announcement.htm";
    }

    @RequestMapping("updatetb")
    public String updatetb(@ModelAttribute("tbneedtobeupdated") THONGBAO thistb, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Session session1 = sessionFactory.openSession();
        Transaction t = session1.beginTransaction();

        try {
            session1.update(thistb);
            t.commit();
            redirectAttributes.addFlashAttribute("message", "Cập nhật thông báo thành công!");
        } catch (Exception e) {
            t.rollback();
            redirectAttributes.addFlashAttribute("message", "Cập nhật thông báo thất bại!");
        }
        finally{
            session1.close();
        }

        return "redirect:announcement.htm";
    }

    @RequestMapping("setnewval")
    public String setnewval(HttpServletRequest request) {
        HttpSession session = request.getSession();
        THONGBAO tb = new THONGBAO();
        session.setAttribute("tbneedtobeupdated", tb);
        return "redirect:announcementinserter.htm";
    }

    @RequestMapping("inserttb")
    public String inserttb(@ModelAttribute("tbneedtobeupdated") THONGBAO thistb, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Session session1 = sessionFactory.openSession();
        Transaction t = session1.beginTransaction();

        try {
            session1.save(thistb);
            t.commit();
            redirectAttributes.addFlashAttribute("message", "Thêm thông báo thành công!");
        } catch (Exception e) {
            t.rollback();
            redirectAttributes.addFlashAttribute("message", "Thêm thông báo thất bại!");
        }
        finally{
            session1.close();
        }

        return "redirect:announcement.htm";
    }

    @RequestMapping("announcementinserter")
    public String announcementinserter(HttpServletRequest request, ModelMap model) {
        HttpSession session = request.getSession();
        THONGBAO tb = (THONGBAO) session.getAttribute("tbneedtobeupdated");
        model.addAttribute("tbneedtobeupdated", tb);
        return "teacher/announcementinserter";
    }

    @RequestMapping("setupdateval")
    public String setupdateval(@RequestParam("modelAttribute") String thistb, HttpServletRequest request) {
        HttpSession session = request.getSession();
        THONGBAO tb = (THONGBAO) session.getAttribute(thistb);
        session.setAttribute("tbneedtobeupdated", tb);
        return "redirect:announcementupdater.htm";
    }

    @RequestMapping("announcementupdater")
    public String announcementupdater(HttpServletRequest request, ModelMap model) {
        HttpSession session = request.getSession();
        THONGBAO tb = (THONGBAO) session.getAttribute("tbneedtobeupdated");
        model.addAttribute("tbneedtobeupdated", tb);
        return "teacher/announcementupdater";
    }
}
