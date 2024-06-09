package controller;

import bean.CT_DONGHOCPHI;
import bean.HOCPHI;
import bean.HOCPHI.HocPhiId;
// import bean.HOCPHI;
import bean.SINHVIEN;
import DAO.SETTINGSDAO;
import DAO.SINHVIENDAO;
// import bean.SINHVIEN;
// import bean.HOCPHI.HocPhiId;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("unchecked")
@Transactional
@Controller
@RequestMapping("student")
public class HocPhiController {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SINHVIENDAO SINHVIENDAO;

    @Autowired
    private SETTINGSDAO SETTINGSDAO;

    @RequestMapping("fee")
    public String hocPhiByMaSV(Model model, HttpServletRequest request) {
        String nienkhoa = SETTINGSDAO.getNIENKHOA();
        int hocky = SETTINGSDAO.getHOCKY();
        String username = request.getSession().getAttribute("username").toString();
        SINHVIEN sv = SINHVIENDAO.getSinhVienByMASV(username);

        Session session = sessionFactory.getCurrentSession();
        HOCPHI hocPhi = sv.getHocPhiTheoKey(new HocPhiId(username, nienkhoa, hocky));
        int tienHP = sv.getTongTienCanDongTrongKy(nienkhoa, hocky);

        if (hocPhi == null) {
            if (tienHP != 0) {
                hocPhi = new HOCPHI();
                hocPhi.setHocPhiId(new HocPhiId(username, nienkhoa, hocky));
                hocPhi.setHOCPHI(tienHP);
                hocPhi.setSinhVien(sv);
                session.save(hocPhi);
                List<HOCPHI> list = new ArrayList<HOCPHI>();
                list.add(hocPhi);
                sv.setHocPhis(list);
            } else {
                return "student/fee";
            }
        } else {
            if (tienHP == 0) {
                session.delete(hocPhi);
                sv.getHocPhis().remove(hocPhi);
            } else {
                hocPhi.setHOCPHI(tienHP);
                session.update(hocPhi);
            }
        }

        request.getSession().setAttribute("SINHVIEN", sv);
        List<CT_DONGHOCPHI> dsCt_DONGHOCPHI = session.createQuery("FROM CT_DONGHOCPHI WHERE MASV = :username")
                .setParameter("username", username)
                .list();
        model.addAttribute("dsCt_DONGHOCPHI", dsCt_DONGHOCPHI);

        return "student/fee";
    }

}