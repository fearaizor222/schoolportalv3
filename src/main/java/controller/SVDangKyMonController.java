package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bean.DisplayLTCObject;
import service.ConnectionService;
import service.StudentService;

@Controller
@RequestMapping("student")
public class SVDangKyMonController {
    @RequestMapping("dangkymon")
    public String dangkymon(ModelMap model, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");

        model.addAttribute("ltc", StudentService.getLTCByMASV(username));
        return "student/dangkymon";
    }

    @RequestMapping("dangky")
    public String dangky(@RequestParam("maltc") String maltc, HttpServletRequest request,
            RedirectAttributes redirectAttributes) {
        int MALTC = Integer.parseInt(maltc);
        String masv = (String) request.getSession().getAttribute("username");

        try{
            StudentService.dangKyMon(masv, MALTC);
            redirectAttributes.addFlashAttribute("message", "Đăng ký thành công");
        } catch (Exception e) {
            System.err.println(e);
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }

        ConnectionService.retryConnection();
        return "redirect:dangkymon.htm";
    }

    @RequestMapping("huydangky")
    public String huydangky(@RequestParam("maltc") String maltc, HttpServletRequest request,
            RedirectAttributes redirectAttributes) {
        
        int MALTC = Integer.parseInt(maltc);
        String masv = (String) request.getSession().getAttribute("username");

        try{
            StudentService.huyDangKyMon(masv, MALTC);
            redirectAttributes.addFlashAttribute("message", "Hủy đăng ký thành công");
        } catch (Exception e) {
            System.err.println(e);
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        
        ConnectionService.retryConnection();
        return "redirect:dangkymon.htm";
    }

    @RequestMapping("timkiem")
    public String timkiem(@RequestParam("nienkhoa") String nienkhoa, @RequestParam("hocky") String hocky, ModelMap model, HttpServletRequest request) {
        int hockyint = Integer.parseInt(hocky);
        String username = (String) request.getSession().getAttribute("username");

        List<DisplayLTCObject> ltc = StudentService.getLTCByMASV(username);
        List<DisplayLTCObject> ltc2 = new ArrayList<DisplayLTCObject>();
        for(DisplayLTCObject l : ltc) {
            if(l.getNIENKHOA().equals(nienkhoa) && l.getHOCKY() == hockyint) {
                ltc2.add(l);
            }
        }
        model.addAttribute("ltc", ltc2);
        return "student/dangkymon";
    }
}
