package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Transactional
@Controller
@RequestMapping("student")
public class SVPointController {

    @RequestMapping("point")
    public String point(ModelMap model, HttpServletRequest request) {
        model.addAttribute("points", request.getSession().getAttribute("DIEM"));

        return "student/point";
    }
}
