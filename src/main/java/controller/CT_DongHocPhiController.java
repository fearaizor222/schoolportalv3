package controller;

import bean.CT_DONGHOCPHI;
import bean.SINHVIEN;
import DAO.SINHVIENDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("ctdonghocphi")
@SuppressWarnings("unchecked")
public class CT_DongHocPhiController {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private SINHVIENDAO SINHVIENDAO;

    @Transactional
    @RequestMapping("detailFee")
    public String listCTDongHocPhi(Model model, HttpServletRequest request) {
        request.getSession().getAttribute("username");
        String username = (String) request.getSession().getAttribute("username");
        Session session = sessionFactory.getCurrentSession();
        SINHVIEN sv = SINHVIENDAO.getSinhVienByMASV(username);
        model.addAttribute("SINHVIEN", sv);
        List<CT_DONGHOCPHI> dsCt_DONGHOCPHI = session.createQuery("FROM CT_DONGHOCPHI WHERE MASV = :username")
                .setParameter("username", username)
                .list();
        model.addAttribute("dsCt_DONGHOCPHI", dsCt_DONGHOCPHI);
        return "ctdonghocphi/detailFee";

    }
}
