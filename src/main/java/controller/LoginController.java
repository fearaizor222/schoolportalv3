package controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import helper.AuthenticateHelper;

import org.springframework.web.bind.annotation.*;

@Controller
@Transactional
public class LoginController {
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("login")
    public String login() {
        return "login";
    }
    
    @RequestMapping(value="login-action", method = RequestMethod.POST)
    public String dangnhap(@RequestParam("username") String username, 
                            @RequestParam("password") String password, 
                            HttpServletRequest request,
                            RedirectAttributes redirectAttributes) {
        Session session = sessionFactory.getCurrentSession();
        if(AuthenticateHelper.isStudent(username)){
            if(AuthenticateHelper.authenticateStudent(username, password, session)) {
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("role", "student");
                request.getSession().setMaxInactiveInterval(15);
                return "redirect:/student/dashboard.htm";
            }
        }
        else if(AuthenticateHelper.isTeacher(username)){
            if(AuthenticateHelper.authenticateTeacher(username, password, session)) {
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("role", "teacher");
                request.getSession().setMaxInactiveInterval(15);
                return "redirect:/teacher/dashboard.htm";
            }
        }
        redirectAttributes.addFlashAttribute("message", "Sai tên đăng nhập hoặc mật khẩu");
        return "redirect:/login.htm";
    }
}
