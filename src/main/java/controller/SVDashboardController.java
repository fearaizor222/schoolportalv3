package controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bean.DANGKY;
import bean.LOP;
import bean.SINHVIEN;
import service.ConnectionService;
import service.StudentService;

@Controller
@RequestMapping("student")
public class SVDashboardController {

    @RequestMapping("dashboard")
    public String sinhVien(HttpServletRequest request, ModelMap model) {
        HttpSession session = request.getSession();
        Connection connection = ConnectionService.getConnection();
        StudentService.setConnection(connection);
        String loginuser = (String) session.getAttribute("username");
        SINHVIEN student = StudentService.getSINHVIENByMASV(loginuser);
        LOP lop = StudentService.getLOPByMASV(student.getMALOP());
        List<DANGKY> listDangKy = StudentService.getAllDANGKYByMASV(loginuser);

        model.addAttribute("SINHVIEN", student);
        model.addAttribute("LOP", lop);
        model.addAttribute("points", listDangKy);

        return "student/dashboard";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        ConnectionService.closeConnection();
        return "redirect:/login.htm";
    }

    @RequestMapping("change-password")
    public String changePassword(@RequestParam("curPass") String oldPassword,
            @RequestParam("newPass") String newPassword,
            @RequestParam("newPassConf") String confirmPassword,
            HttpServletRequest request,
            RedirectAttributes redirectAttribute) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (StudentService.updatePASSWORDByMASV(username, oldPassword, newPassword, confirmPassword)) {
            redirectAttribute.addFlashAttribute("passwordUpdateMsg", "Đổi mật khẩu thành công");
            return "redirect:/student/dashboard.htm";
        } else {
            redirectAttribute.addFlashAttribute("passwordUpdateMsg", "Đổi mật khẩu thất bại");
            return "redirect:/student/dashboard.htm";
        }
    }
}
