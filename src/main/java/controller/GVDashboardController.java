package controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import DAO.GIANGVIENDAO;
import DAO.THONGBAODAO;
import bean.GIANGVIEN;
import bean.LICH;
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

        if(session.getAttribute("firstDayOfWeek") == null || session.getAttribute("lastDayOfWeek") == null) {
            LocalDate today = LocalDate.now();

            LocalDate firstDayOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            LocalDate lastDayOfWeek = firstDayOfWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
            
            session.setAttribute("firstDayOfWeek", firstDayOfWeek);
            session.setAttribute("lastDayOfWeek", lastDayOfWeek);

            Date firstDayOfWeekDate = Date.from(firstDayOfWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date lastDayOfWeekDate = Date.from(lastDayOfWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());

            List<LICH> listLICH = GIANGVIENDAO.getLichSangFromDateToDate(loginuser, firstDayOfWeekDate, lastDayOfWeekDate);
            session.setAttribute("dsLICHSANG", listLICH);

            List<LICH> listLICH2 = GIANGVIENDAO.getLichChieuFromDateToDate(loginuser, firstDayOfWeekDate, lastDayOfWeekDate);
            session.setAttribute("dsLICHCHIEU", listLICH2);
        }

        return "teacher/dashboard";
    }

    @RequestMapping(value = "truoc", method = RequestMethod.GET)
    public String previousWeek(HttpServletRequest request) {
        HttpSession session = request.getSession();
        LocalDate firstDayOfWeek = (LocalDate) session.getAttribute("firstDayOfWeek");
        LocalDate lastDayOfWeek = (LocalDate) session.getAttribute("lastDayOfWeek");

        LocalDate previousFirstDayOfWeek = firstDayOfWeek.minusDays(7);
        LocalDate previousLastDayOfWeek = lastDayOfWeek.minusDays(7);

        session.setAttribute("firstDayOfWeek", previousFirstDayOfWeek);
        session.setAttribute("lastDayOfWeek", previousLastDayOfWeek);

        Date previousFirstDayOfWeekDate = Date.from(previousFirstDayOfWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date previousLastDayOfWeekDate = Date.from(previousLastDayOfWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<LICH> list1 = GIANGVIENDAO.getLichSangFromDateToDate((String) session.getAttribute("username"), previousFirstDayOfWeekDate, previousLastDayOfWeekDate);
        session.setAttribute("dsLICHSANG", list1);

        List<LICH> list2 = GIANGVIENDAO.getLichChieuFromDateToDate((String) session.getAttribute("username"), previousFirstDayOfWeekDate, previousLastDayOfWeekDate);
        session.setAttribute("dsLICHCHIEU", list2);

        return "redirect:/teacher/dashboard.htm";
    }

    @RequestMapping(value = "sau", method = RequestMethod.GET)
    public String nextWeek(HttpServletRequest request) {
        HttpSession session = request.getSession();
        LocalDate firstDayOfWeek = (LocalDate) session.getAttribute("firstDayOfWeek");
        LocalDate lastDayOfWeek = (LocalDate) session.getAttribute("lastDayOfWeek");

        LocalDate nextFirstDayOfWeek = firstDayOfWeek.plusDays(7);
        LocalDate nextLastDayOfWeek = lastDayOfWeek.plusDays(7);

        session.setAttribute("firstDayOfWeek", nextFirstDayOfWeek);
        session.setAttribute("lastDayOfWeek", nextLastDayOfWeek);

        Date nextFirstDayOfWeekDate = Date.from(nextFirstDayOfWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date nextLastDayOfWeekDate = Date.from(nextLastDayOfWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<LICH> list1 = GIANGVIENDAO.getLichSangFromDateToDate((String) session.getAttribute("username"), nextFirstDayOfWeekDate, nextLastDayOfWeekDate);
        session.setAttribute("dsLICHSANG", list1);

        List<LICH> list2 = GIANGVIENDAO.getLichChieuFromDateToDate((String) session.getAttribute("username"), nextFirstDayOfWeekDate, nextLastDayOfWeekDate);
        session.setAttribute("dsLICHCHIEU", list2);

        return "redirect:/teacher/dashboard.htm";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login.htm";
    }
}
