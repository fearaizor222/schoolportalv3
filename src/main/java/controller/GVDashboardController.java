package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bean.DisplayLTCObject;
import bean.GIANGVIEN;
import bean.KHOA;

import java.sql.Connection;

import service.ClassService;
import service.ConnectionService;
import service.TeacherService;

@Controller
@RequestMapping("teacher")
public class GVDashboardController {
    @RequestMapping("dashboard")
    public String sinhVien(HttpServletRequest request, ModelMap model) {
        HttpSession session = request.getSession();
        Connection connection = ConnectionService.getConnection();
        TeacherService.setConnection(connection);
        String loginuser = (String) session.getAttribute("username");
        GIANGVIEN teacher = TeacherService.getGIANGVIENByMAGV(loginuser);
        List<DisplayLTCObject> AllLTCList = TeacherService.getAllLTCByMAGV(loginuser);
        model.addAttribute("GIANGVIEN", teacher);
        model.addAttribute("AllLTCList", AllLTCList);

        return "teacher/dashboard";
    }

    @ModelAttribute("toanbokhoa")
    public List<KHOA> toanbokhoa() {
        return ClassService.getAllKHOA();
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
        if (TeacherService.updatePASSWORDByMAGV(username, oldPassword, newPassword, confirmPassword)) {
            redirectAttribute.addFlashAttribute("passwordUpdateMsg", "Đổi mật khẩu thành công");
            return "redirect:/student/dashboard.htm";
        } else {
            redirectAttribute.addFlashAttribute("passwordUpdateMsg", "Đổi mật khẩu thất bại");
            return "redirect:/student/dashboard.htm";
        }
    }
}
