package DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.THONGBAO;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class THONGBAODAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<THONGBAO> getAllThongBao() {
        return sessionFactory.getCurrentSession().createQuery("FROM THONGBAO ORDER BY NGAYDANG DESC").list();
    }
}
