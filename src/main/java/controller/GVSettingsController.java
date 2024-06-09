package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import DAO.SETTINGSDAO;

@RequestMapping("teacher")
@Controller
public class GVSettingsController {
    @Autowired
    private SETTINGSDAO settingsDAO;

    @RequestMapping("settings")
    public String settings(HttpServletRequest request) {
        String nienkhoa = settingsDAO.getNIENKHOA();
        int hocKy = settingsDAO.getHOCKY();
        boolean dangkymon = settingsDAO.getDANGKYMON();

        HttpSession session = request.getSession();
        session.setAttribute("nienkhoa", nienkhoa);
        session.setAttribute("hocky", hocKy);
        session.setAttribute("dangkymon", dangkymon);

        return "teacher/settings";
    }

    @RequestMapping(value = "change", method = RequestMethod.POST)
    public String handleSettingsForm(HttpServletRequest request) {
        String nienkhoa = request.getParameter("nienkhoa");
        int hocky = Integer.parseInt(request.getParameter("hocky"));
        boolean dangkymon = Boolean.parseBoolean(request.getParameter("dangkymon"));

        // Now you can use these values to update your settings
        settingsDAO.setNIENKHOA(nienkhoa);
        settingsDAO.setHOCKY(hocky);
        settingsDAO.setDANGKYMON(dangkymon);

        // Redirect back to the settings page
        return "redirect:/teacher/settings.htm";
    }
}
