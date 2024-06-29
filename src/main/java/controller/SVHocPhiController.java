package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.DisplayHPObject;
import service.StudentService;

@Controller
@RequestMapping("/student")
public class SVHocPhiController {
    @RequestMapping("/fee")
    public String hocPhi(HttpServletRequest request, ModelMap model) {
        String username = (String) request.getSession().getAttribute("username");
        List<DisplayHPObject> list = StudentService.getHPByMASV(username);
        model.addAttribute("list", list);
        return "student/fee";
    }
}
