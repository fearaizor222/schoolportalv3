package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.StudentService;
import bean.REPORT_BANGDIEMObject;

@Controller
@RequestMapping("teacher")
public class ReportBDLTCController {
    @RequestMapping("reportBANGDIEM")
    public String reportBDLTC(HttpSession session) {
        return "teacher/reportBANGDIEM";
    }

    @RequestMapping("timkiembangdiemltc")
    public String timkiembangdiemltc(@RequestParam("nienkhoa") String nienkhoa,
            @RequestParam("hocky") int hocky, @RequestParam("mamh") String mamh, @RequestParam("nhom") int nhom,
            ModelMap model) {
        try {
            List<REPORT_BANGDIEMObject> listltc = StudentService.getBangDiemLTC(nienkhoa, hocky, mamh, nhom);
            model.addAttribute("nienkhoa", nienkhoa);
            model.addAttribute("hocky", hocky);
            model.addAttribute("nhom", nhom);
            model.addAttribute("mamh", mamh);
            model.addAttribute("listltc", listltc);
            model.addAttribute("soluong", listltc.size());
            model.addAttribute("msg", "Đã tìm thấy");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "teacher/reportBANGDIEM";
    }
}
