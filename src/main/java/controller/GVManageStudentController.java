package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bean.SINHVIEN;

@Transactional
@Controller
@RequestMapping("teacher")
public class GVManageStudentController {

    @Autowired
    private SessionFactory factory;

    @RequestMapping(value = "insertsv", method = RequestMethod.POST)
    public String insertStudent(ModelMap model, @ModelAttribute("sinhvien") SINHVIEN sinhvien,
            HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(sinhvien);
            t.commit();
            model.addAttribute("sinhvien", new SINHVIEN());
            redirectAttributes.addFlashAttribute("message", "Thêm sinh viên thành công!");
        } catch (Exception e) {
            t.rollback();
            redirectAttributes.addFlashAttribute("message", "Thêm sinh viên thất bại!");
        } finally {
            session.close();
        }
        return "redirect:student-management.htm";
    }

    @RequestMapping(value = "deletesv", method = RequestMethod.GET)
    public String deleteStudent(ModelMap model, @RequestParam("MASV") String id,
            RedirectAttributes redirectAttributes) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        try {
            SINHVIEN sinhvien = (SINHVIEN) session.get(SINHVIEN.class, id);
            session.delete(sinhvien);
            t.commit();
            redirectAttributes.addFlashAttribute("message", "Xóa sinh viên thành công!");
        } catch (Exception e) {
            t.rollback();
            redirectAttributes.addFlashAttribute("message", "Xóa sinh viên thất bại!");
        } finally {
            session.close();
        }
        return "redirect:student-management.htm";
    }

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Transactional
    @RequestMapping(value = "student-management")
    public String showSV(ModelMap model) {
        Session session = sessionFactory.getCurrentSession();
        List<SINHVIEN> dsSINHVIEN = session.createQuery("FROM SINHVIEN").list();
        model.addAttribute("dsSINHVIEN", dsSINHVIEN);
        model.addAttribute("sinhvien", new SINHVIEN());
        return "teacher/student-management";
    }

}