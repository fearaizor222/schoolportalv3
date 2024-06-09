package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.SINHVIENDAO;

@RequestMapping("student")
@Controller
public class SVTestController {
    @Autowired
    private SINHVIENDAO SINHVIENDAO;

    @RequestMapping("test")
    public String test(ModelMap model, HttpServletRequest request) {
        String username = request.getSession().getAttribute("username").toString();
        model.addAttribute("lichthi", SINHVIENDAO.getLichThi(username));
        return "student/test";
    }
}
