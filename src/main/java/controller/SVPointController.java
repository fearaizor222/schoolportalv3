package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.SINHVIENDAO;

@Transactional
@Controller
@RequestMapping("student")
public class SVPointController {
    @Autowired
    private SINHVIENDAO SINHVIENDAO;

    @RequestMapping("point")
    public String point(ModelMap model, HttpServletRequest request) {
        String username = request.getSession().getAttribute("username").toString();
        model.addAttribute("points", SINHVIENDAO.getDiemByMASV(username));

        return "student/point";
    }
}
