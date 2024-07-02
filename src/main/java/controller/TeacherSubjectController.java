package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bean.DisplayMONHOCObject;
import service.SubjectService;

@Controller
@RequestMapping("/teacher")
public class TeacherSubjectController {

    //Show môn
    @RequestMapping("/subject-management")
    public String subjectManagement(HttpServletRequest request, RedirectAttributes redirectAttributes, ModelMap model) {
        List<DisplayMONHOCObject> dsMonHoc = SubjectService.getAllMONHOC();
        model.addAttribute("dsMonHoc", dsMonHoc);

        return "teacher/subject-management";
    }

    @RequestMapping("/insertsubject")
    public String insertSubject( @RequestParam("MAMH") String MAMH, @RequestParam("TENMH") String TENMH, @RequestParam("SOTIET_LT") int SOTIET_LT, @RequestParam("SOTIET_TH") int SOTIET_TH, @RequestParam("SOTINCHI") int SOTINCHI, RedirectAttributes redirectAttributes) {
        try {
            SubjectService.insertMonHoc(MAMH, TENMH, SOTIET_LT, SOTIET_TH, SOTINCHI);
            redirectAttributes.addFlashAttribute("InsertSubjectMsg", "Thêm môn học thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("InsertSubjectMsg", e.getMessage());
        }
        return "redirect:/teacher/subject-management.htm";
    }

    @RequestMapping("/updatesubject")
    public String updateSubject(@RequestParam("MAMH") String MAMH, @RequestParam("TENMH") String TENMH, @RequestParam("SOTIET_LT") int SOTIET_LT, @RequestParam("SOTIET_TH") int SOTIET_TH, @RequestParam("SOTINCHI") int SOTINCHI, RedirectAttributes redirectAttributes) {
        try {
            SubjectService.updateMonHoc(MAMH, TENMH, SOTIET_LT, SOTIET_TH, SOTINCHI);
            redirectAttributes.addFlashAttribute("UpdateSubjectMsg", "Cập nhật môn học thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("UpdateSubjectMsg", e.getMessage());
        }
        return "redirect:/teacher/subject-management.htm";
    }

    @RequestMapping("/deletesubject")
    public String deleteSubject(@RequestParam("MAMH") String MAMH, RedirectAttributes redirectAttributes) {
        try {
            SubjectService.deleteMonHoc(MAMH);
            redirectAttributes.addFlashAttribute("DeleteSubjectMsg", "Xóa môn học thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("DeleteSubjectMsg", e.getMessage());
        }
        return "redirect:/teacher/subject-management.htm";
    }
    
    
}
