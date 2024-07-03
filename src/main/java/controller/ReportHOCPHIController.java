package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bean.LOP;
import bean.KHOA;
import bean.REPORTHOCPHI;
import service.ClassService;

@Controller
@RequestMapping("/teacher")
public class ReportHOCPHIController {
    @RequestMapping("/reportHOCPHI")
    public String reportHOCPHI(HttpSession session) {
        return "teacher/reportHOCPHI";
    }

    @RequestMapping("/timkiemhocphireport")
    public String timkiemhocphi(@RequestParam("malop") String malop, @RequestParam("nienkhoa") String nienkhoa,
            @RequestParam("hocky") int hocky, ModelMap model) {
        try {
            List<REPORTHOCPHI> listhocphi = ClassService.getReportHocPhi(malop, nienkhoa, hocky);
            model.addAttribute("malop", malop);
            model.addAttribute("nienkhoa", nienkhoa);
            model.addAttribute("hocky", hocky);
            model.addAttribute("listhocphi", listhocphi);
            model.addAttribute("soluong", listhocphi.size());
            model.addAttribute("tenkhoa", listhocphi.get(0).getTENKHOA());
            int tonghocphi = 0;
            for (REPORTHOCPHI reporthocphi : listhocphi) {
                tonghocphi += reporthocphi.getHOCPHI();
            }
            model.addAttribute("msg", "thanh cong");
            model.addAttribute("tonghocphi", tonghocphi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "teacher/reportHOCPHI";
    }
}
