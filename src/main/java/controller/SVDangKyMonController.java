package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Transactional
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
}
