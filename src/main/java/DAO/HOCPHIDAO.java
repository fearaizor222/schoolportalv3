package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.CT_DONGHOCPHI;
import bean.HOCPHI;

@Transactional
@Repository
@SuppressWarnings({ "unchecked"})
public class HOCPHIDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<HOCPHI> getHocPhi() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM HOCPHI ORDER BY hocPhiId.NIENKHOA DESC, hocPhiId.HOCKY DESC, hocPhiId.MASV ASC";
        List<HOCPHI> list = session.createQuery(hql).list();
        return list;
    }

    public boolean isPaid(String maSV, String nienKhoa, int hocKy) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM CT_DONGHOCPHI WHERE ID.MASV = :maSV AND ID.NIENKHOA = :nienKhoa AND ID.HOCKY = :hocKy";
        List<HOCPHI> list = session.createQuery(hql).setParameter("maSV", maSV).setParameter("nienKhoa", nienKhoa).setParameter("hocKy", hocKy).list();
        return list.size() > 0;
    }

    public HOCPHI getHocPhi(String maSV, String nienKhoa, int hocKy) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM HOCPHI WHERE MASV = :maSV AND NIENKHOA = :nienKhoa AND HOCKY = :hocKy";
        List<HOCPHI> list = session.createQuery(hql).setParameter("maSV", maSV).setParameter("nienKhoa", nienKhoa).setParameter("hocKy", hocKy).list();
        return list.size() > 0 ? list.get(0) : null;
    }

    public CT_DONGHOCPHI getCTDongHocPhi(String maSV, String nienKhoa, int hocKy) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM CT_DONGHOCPHI WHERE ID.MASV = :maSV AND ID.NIENKHOA = :nienKhoa AND ID.HOCKY = :hocKy";
        List<CT_DONGHOCPHI> list = session.createQuery(hql).setParameter("maSV", maSV).setParameter("nienKhoa", nienKhoa).setParameter("hocKy", hocKy).list();
        return list.size() > 0 ? list.get(0) : null;
    }
}
