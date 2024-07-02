package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.StudentService;
import bean.REPORT_PHIEUDIEMSVObject;

@Controller
@RequestMapping("teacher")
public class ReportPHIEUDIEMSVController {
    @RequestMapping("reportPHIEUDIEMSV")
    public String reportPHIEUDIEMSV(HttpSession session) {
        return "teacher/reportPHIEUDIEMSV";
    }

    @RequestMapping("timkiemphieudiemsv")
    public String timkiem(@RequestParam("masv") String masv, ModelMap model) {
        try {
            List<REPORT_PHIEUDIEMSVObject> phieudiem = StudentService.getPhieuDiemSV(masv);
            model.addAttribute("masv", masv);
            model.addAttribute("phieudiem", phieudiem);
            model.addAttribute("msg", "Đã tìm thấy");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "teacher/reportPHIEUDIEMSV";
    }
}
