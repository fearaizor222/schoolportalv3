package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bean.GIANGVIEN;
import service.TeacherService;

@Controller
@RequestMapping("teacher")
public class TeacherTaoLoginController {
    @ModelAttribute("allmagv")
    public List<GIANGVIEN> getAllGiangVien() {
        return TeacherService.getAllGIANGVIEN();
    }

    @RequestMapping("taologin")
    public String taologin() {
        return "teacher/makelogin";
    }

    @RequestMapping("makelogin-action")
    public String makelogin(@RequestParam("LGNAME") String username, @RequestParam("PASSWORD") String password, @RequestParam("ROLE") String role, ModelMap modelMap) {
        try{
            TeacherService.taoLOGIN(username, password, role);
            modelMap.addAttribute("message", "Tạo tài khoản thành công");
        }
        catch(Exception e){
            modelMap.addAttribute("message", e.getMessage());
        }
        return "teacher/makelogin";
    }
}
