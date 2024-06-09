package controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import DAO.GIANGVIENDAO;
import DAO.SINHVIENDAO;
import bean.SINHVIEN;

import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private SINHVIENDAO SINHVIENDAO;

    @Autowired
    private GIANGVIENDAO GIANGVIENDAO;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private String superAdmin;

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
                request.getSession().setMaxInactiveInterval(15 * 60);
                if(username.equals(superAdmin)){
                    request.getSession().setAttribute("role", "admin");
                }
                else{
                    request.getSession().setAttribute("role", "teacher");
                }
                return "redirect:/teacher/dashboard.htm";
        }

        redirectAttributes.addFlashAttribute("message", "Sai tên đăng nhập hoặc mật khẩu");
        return "redirect:/login.htm";
    }

    @RequestMapping("forgot-password")
    public String forgotPassword() {
        return "forgot-password";
    }

    @RequestMapping(value="forgot-password-action", method = RequestMethod.POST)
    public String forgotPasswordAction(@RequestParam("userEmail") String usernameString, ModelMap model) {
        try {
            SINHVIEN sv = SINHVIENDAO.getSinhvienByEmail(usernameString);

            String password = sv.getPASSWORD();
            String email = sv.getEMAIL();
    
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom("phuoc.lam.259@gmail.com", "forgot.password@no-reply");
            helper.setTo(email);
            helper.setReplyTo("phuoc.lam.259@gmail.com", "forgot.password@no-reply");
            helper.setSubject("Forgot password");
            helper.setText("Your password is: " + password, true);

            mailSender.send(message);
            model.addAttribute("message", "Gửi mail thành công");
        } catch (Exception e) {
            model.addAttribute("message", "Gửi mail thất bại");
        }   
        return "forgot-password";
    }
}
