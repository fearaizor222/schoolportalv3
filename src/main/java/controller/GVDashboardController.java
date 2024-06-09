package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.GIANGVIENDAO;
import DAO.THONGBAODAO;
import bean.GIANGVIEN;
import bean.THONGBAO;

@Controller
@RequestMapping("teacher")
public class GVDashboardController {
    @Autowired
    private GIANGVIENDAO GIANGVIENDAO;

    @Autowired
    private THONGBAODAO THONGBAODAO;

    @Transactional
    @RequestMapping("dashboard")
    public String giangVien(ModelMap model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String loginuser = (String) session.getAttribute("username");

        GIANGVIEN gv = GIANGVIENDAO.getGiangVienByMAGV(loginuser);
        model.addAttribute("GIANGVIEN", gv);

        model.addAttribute("CHUYENMON", gv.getCHUYENMON());

        model.addAttribute("Khoa", gv.getKhoa());

        model.addAttribute("KHOA", gv.getKhoa().getTENKHOA());

        List<THONGBAO> list = THONGBAODAO.getAllThongBao();
        model.addAttribute("dsTHONGBAO", list);

        request.getSession().setAttribute("DIEM", gv.getLoptinchis()); // chưa chắc đoạn này

        return "teacher/dashboard";

        
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login.htm";
    }
}
