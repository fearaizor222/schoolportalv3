package controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class SVDashboardController {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @RequestMapping("dashboard")
    public String sinhVien(ModelMap model, HttpServletRequest request) {
        String loginuser = (String) request.getSession().getAttribute("username");
        Session curr = sessionFactory.getCurrentSession();
        String hql = "FROM SINHVIEN WHERE MASV = :loginuser";
        Query query = curr.createQuery(hql);
        query.setParameter("loginuser", loginuser);
        model.addAttribute("SINHVIEN", query.list().get(0));
        return "student/dashboard";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login.htm";
    }
}
