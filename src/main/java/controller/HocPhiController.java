package controller;


import bean.CT_DONGHOCPHI;
import bean.HOCPHI;
// import bean.SINHVIEN;
// import DAO.SINHVIENDAO;

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

    // @Autowired
    // private SINHVIENDAO SINHVIENDAO;

    @RequestMapping("fee")
    public String hocPhiByMaSV(Model model, HttpServletRequest request){
        request.getSession().getAttribute("username");
        String username = (String) request.getSession().getAttribute("username");
        Session session = sessionFactory.getCurrentSession();
        // SINHVIEN sv = SINHVIENDAO.getSinhVienByMASV(username);
        // model.addAttribute("SINHVIEN", sv);
        List<HOCPHI> hocPhi = session.createQuery("FROM HOCPHI WHERE MASV = :username")
                    .setParameter("username", username)
                    .list();
        model.addAttribute("hocPhi", hocPhi);
        List<CT_DONGHOCPHI> dsCt_DONGHOCPHI = session.createQuery("FROM CT_DONGHOCPHI WHERE MASV = :username")
                .setParameter("username", username)
                .list();
        model.addAttribute("dsCt_DONGHOCPHI", dsCt_DONGHOCPHI);
        return "student/fee";
    }

}