package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bean.KHOA;
import bean.REPORT_DSLTCObject;
import service.ClassService;
import service.LTCService;

@Controller
@RequestMapping("/teacher")
public class ReportDSLTCController {
    @RequestMapping("/reportDSLTC")
    public String reportDSLTC(HttpSession session) {
        String makhoasite = (String) session.getAttribute("site");
        List<KHOA> listkhoa = ClassService.getAllKHOA();
        for(KHOA khoa : listkhoa){
            if(khoa.getMAKHOA().trim().equals(makhoasite)){
                session.setAttribute("tenkhoa", khoa.getTENKHOA());
                break;
            }
        }
        return "teacher/reportDSLTC";
    }

    @RequestMapping("/timkiemloptinchi")
    public String timkiemloptinchi(@RequestParam("nienkhoa") String nienkhoa, @RequestParam("hocky") int hocky, ModelMap model) {
        try{
            List<REPORT_DSLTCObject> listltc = LTCService.getDSLTC(nienkhoa, hocky);
            model.addAttribute("nienkhoa", nienkhoa);
            model.addAttribute("hocky", hocky);
            model.addAttribute("listltc",listltc);
            model.addAttribute("soluong", listltc.size());
            model.addAttribute("msg", "Tìm thấy " + listltc.size() + " lớp tín chỉ");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "teacher/reportDSLTC";
    }
}