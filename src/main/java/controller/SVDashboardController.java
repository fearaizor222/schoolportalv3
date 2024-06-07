package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.SINHVIENDAO;
import DAO.THONGBAODAO;
import bean.SINHVIEN;
import bean.THONGBAO;

@Controller
@RequestMapping("student")
public class SVDashboardController {
    @Autowired
    private SINHVIENDAO SINHVIENDAO;

    @Autowired
    private THONGBAODAO THONGBAODAO;

    @Transactional
    @RequestMapping("dashboard")
    public String sinhVien(ModelMap model, HttpServletRequest request) {
        String loginuser = (String) request.getSession().getAttribute("username");

        SINHVIEN sv = SINHVIENDAO.getSinhVienByMASV(loginuser);
        model.addAttribute("SINHVIEN", sv);

        model.addAttribute("LOP", sv.getLop());

        List<THONGBAO> list = THONGBAODAO.getAllThongBao();
        model.addAttribute("dsTHONGBAO", list);

        return "student/dashboard";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login.htm";
    }
}
