package controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.StudentService;

@Controller
@RequestMapping("/teacher")
public class TeacherStudentManagement {
    
    @RequestMapping("/student-management")
    public String studentManagement1(@RequestParam("malop") String malop, HttpServletRequest request, Model model) {
        request.getSession().setAttribute("malop", malop);
        model.addAttribute("dsSV", StudentService.getAllSINHVIENByMALOP(malop));
        return "teacher/student-management";
    }

    @RequestMapping("/insertsv")
    public String insertsv(@RequestParam("MASV") String masv, @RequestParam("HO") String ho, @RequestParam("TEN") String ten,
            @RequestParam("PHAI") boolean phai, @RequestParam("DIACHI") String diachi, @RequestParam("NGAYSINH") Date ngaysinh,
            @RequestParam("MALOP") String malop, @RequestParam("PASSWORD") String password, RedirectAttributes redirectAttributes) {
        try{
            StudentService.insertSINHVIEN(masv, ho, ten, phai, diachi, ngaysinh, malop, password);
            redirectAttributes.addFlashAttribute("InsertSVMsg", "Thêm sinh viên thành công");
        }
        catch(Exception e){
            redirectAttributes.addFlashAttribute("InsertSVMsg", e.getMessage());
        }
        return "redirect:/teacher/student-management.htm?malop=" + malop;
    }

    @RequestMapping("/updatesv")
    public String updatesv(@RequestParam("MASV") String masv, @RequestParam("HO") String ho, @RequestParam("TEN") String ten,
            @RequestParam("PHAI") boolean phai, @RequestParam("DIACHI") String diachi, @RequestParam("NGAYSINH") Date ngaysinh,
            @RequestParam("MALOP") String malop, @RequestParam("DANGHIHOC") boolean danghihoc, @RequestParam("PASSWORD") String password, RedirectAttributes redirectAttributes) {
        try{
            StudentService.updateSINHVIEN(masv, ho, ten, phai, diachi, ngaysinh, danghihoc, password);
            redirectAttributes.addFlashAttribute("UpdateSVMsg", "Cập nhật sinh viên thành công");
        }
        catch(Exception e){
            redirectAttributes.addFlashAttribute("UpdateSVMsg", e.getMessage());
        }
        return "redirect:/teacher/student-management.htm?malop=" + malop;
    }
}
