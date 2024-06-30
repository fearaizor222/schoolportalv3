package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.ClassService;

import java.util.List;
import bean.KHOA;
import bean.LOP;

@Controller
@RequestMapping("/teacher")
public class TeacherClassManagement {
    @ModelAttribute("toanbokhoa")
    public List<KHOA> toanbokhoa() {
        return ClassService.getAllKHOA();
    }

    @ModelAttribute("dsLop")
    public List<LOP> dsLop() {
        return ClassService.getAllLOP();
    }

    @RequestMapping("/class-management")
    public String classManagement(ModelMap model) {
        return "teacher/class-management";
    }

    @RequestMapping("/insertclass")
    public String insertClass(@RequestParam("MALOP") String MALOP, @RequestParam("TENLOP") String TENLOP, @RequestParam("KHOAHOC") String KHOAHOC, RedirectAttributes redirectAttributes) {
        String makhoa = ClassService.getAllLOP().get(0).getMAKHOA();
        try {
            ClassService.insertClass(MALOP, TENLOP, KHOAHOC,makhoa);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("InsertClassMsg", e.getMessage());
        }
        return "redirect:/teacher/class-management.htm";
    }

    @RequestMapping("/deleteclass")
    public String deleteClass(@RequestParam("malop") String MALOP, RedirectAttributes redirectAttributes) {
        try {
            ClassService.deleteClass(MALOP);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("DeleteClassMsg", e.getMessage());
        }
        return "redirect:/teacher/class-management.htm";
    }

    @RequestMapping("/updateclass")
    public String updateClass(@RequestParam("MALOP") String MALOP, @RequestParam("TENLOP") String TENLOP, @RequestParam("KHOAHOC") String KHOAHOC, RedirectAttributes redirectAttributes) {
        try {
            ClassService.updateClass(MALOP, TENLOP, KHOAHOC);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("UpdateClassMsg", e.getMessage());
        }
        return "redirect:/teacher/class-management.htm";
    }
}
