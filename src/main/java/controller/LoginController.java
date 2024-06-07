package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import DAO.GIANGVIENDAO;
import DAO.SINHVIENDAO;

import org.springframework.web.bind.annotation.*;

@Controller
@Transactional
public class LoginController {
    @Autowired
    private SINHVIENDAO SINHVIENDAO;

    @Autowired
    private GIANGVIENDAO GIANGVIENDAO;

    @RequestMapping("login")
    public String login() {
        return "login";
    }
    
    @RequestMapping(value="login-action", method = RequestMethod.POST)
    public String dangnhap(@RequestParam("username") String username, 
                            @RequestParam("password") String password, 
                            HttpServletRequest request,
                            RedirectAttributes redirectAttributes) {
        if(SINHVIENDAO.authenticate(username, password)) {
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("role", "student");
            request.getSession().setMaxInactiveInterval(15 * 60);
            return "redirect:/student/dashboard.htm";
        }
        else if(GIANGVIENDAO.authenticate(username, password)) {
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("role", "teacher");
                request.getSession().setMaxInactiveInterval(15 * 60);
                return "redirect:/teacher/dashboard.htm";
        }

        redirectAttributes.addFlashAttribute("message", "Sai tên đăng nhập hoặc mật khẩu");
        return "redirect:/login.htm";
    }
}
