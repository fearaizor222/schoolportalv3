package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bean.REPORTDSSVLTCObject;
import service.LTCService;

@Controller
@RequestMapping("/teacher")
public class ReportDSSVLTCController {
    @RequestMapping("/reportDSSVLTC")
    public String reportDSSVLTC(HttpSession session) {
        return "teacher/reportDSSVLTC";
    }

    @RequestMapping("/timkiemdssvloptinchi")
    public String timkiemdssvloptinchi(@RequestParam("nienkhoa") String nienkhoa, @RequestParam("hocky") int hocky,
            @RequestParam("mamonhoc") String mamonhoc, @RequestParam("nhom") int nhom, ModelMap model) {
        List<REPORTDSSVLTCObject> listsvltc = LTCService.getDSSVLTC(nienkhoa, hocky, mamonhoc, nhom);
        model.addAttribute("nienkhoa", nienkhoa);
        model.addAttribute("hocky", hocky);
        model.addAttribute("mamonhoc", mamonhoc);
        model.addAttribute("nhom", nhom);
        model.addAttribute("listsvltc", listsvltc);
        model.addAttribute("msg", "Đã tìm thấy" + listsvltc.size() + "sinh viên");
        return "teacher/reportDSSVLTC";
    }
}
