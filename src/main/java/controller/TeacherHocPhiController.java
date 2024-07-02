package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.StudentService;

@Controller
@RequestMapping("/teacher")
public class TeacherHocPhiController {
    @RequestMapping("/fee")
    public String fee() {
        return "teacher/fee";
    }

    @RequestMapping("/timkiemhocphi")
    public String searchFee(@RequestParam("masv") String masv, ModelMap model) {
        model.addAttribute("listfee", StudentService.getHPByMASV(masv));
        model.addAttribute("hocphisearchmasv", masv);
        return "teacher/fee";
    }

    @RequestMapping("xacnhandadong")
    public String confirm(@RequestParam("nienkhoa") String nienkhoa, @RequestParam("hocky") int hocky, @RequestParam("masv") String masv, @RequestParam("sotien") int hocphi, ModelMap model) {
        try{
            StudentService.xacnhanHOCPHI(masv, nienkhoa, hocky, hocphi);
            model.addAttribute("ConfirmFeeMsg", "Xác nhận học phí thành công");
        }
        catch(Exception e){
            model.addAttribute("ConfirmFeeMsg", e.getMessage());
        }
        model.addAttribute("listfee", StudentService.getHPByMASV(masv));
        model.addAttribute("hocphisearchmasv", masv);
        return "teacher/fee";
    }
}
