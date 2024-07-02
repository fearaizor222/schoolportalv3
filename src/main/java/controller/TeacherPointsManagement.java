package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.LTCService;

@Controller
@RequestMapping("/teacher")
public class TeacherPointsManagement {
    private String currentviewurl = null;
    @RequestMapping("/points-management")
    public String showPointsManagement(HttpServletRequest model) {
        model.getSession().setAttribute("monhocList", LTCService.getAllMONHOC());
        return "teacher/points";
    }

    @RequestMapping("timkiemdiem")
    public String timkiemdiem(@RequestParam("nienkhoa") String nienkhoa, @RequestParam("hocky") int hocky, @RequestParam("monhoc") String monhoc, @RequestParam("nhom") int nhom, ModelMap model) {
        model.addAttribute("points", LTCService.getDANGKYOfLTC(nienkhoa, hocky, monhoc, nhom));
        currentviewurl = "/teacher/timkiemdiem.htm?nienkhoa=" + nienkhoa + "&hocky=" + hocky + "&monhoc=" + monhoc + "&nhom=" + nhom;
        return "teacher/points";
    }

    @RequestMapping("updatepoint")
    public String updatepoint(@RequestParam("maltc") String maltc, @RequestParam("masv") String masv, @RequestParam("diemcc") int diemcc, @RequestParam("diemgk") float diemgk, @RequestParam("diemck") float diemck, RedirectAttributes redirectAttributes) {
        try{
            LTCService.updateDIEM(maltc, masv, diemcc, diemgk, diemck);
            redirectAttributes.addFlashAttribute("UpdatePointMsg", "Cập nhật điểm thành công");
        }
        catch(Exception e){
            redirectAttributes.addFlashAttribute("UpdatePointMsg", e.getMessage());
        }
        return "redirect:" + currentviewurl;
    }
}
