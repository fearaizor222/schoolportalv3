package DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.GIANGVIEN;

@Repository
public class GIANGVIENDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public boolean authenticate(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT 1 FROM GIANGVIEN WHERE MAGV = :username AND PASSWORD = :password";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        if(query.uniqueResult() != null) {
            return true;
        }
        return false;
    }

    public GIANGVIEN getGiangVienByMAGV(String MAGV) {
        Session curr = sessionFactory.getCurrentSession();
        String hql = "FROM GIANGVIEN WHERE MAGV = :loginuser";
        Query query = curr.createQuery(hql);
        query.setParameter("loginuser", MAGV);
        GIANGVIEN gv = (GIANGVIEN) query.list().get(0);

        return gv;
    }
}
