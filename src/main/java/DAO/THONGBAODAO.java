package DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bean.THONGBAO;

@SuppressWarnings("unchecked")
@Repository
public class THONGBAODAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<THONGBAO> getAllThongBao() {
        return sessionFactory.getCurrentSession().createQuery("FROM THONGBAO ORDER BY NGAYDANG DESC").list();
    }
}
