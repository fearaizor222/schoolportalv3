package DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bean.SINHVIEN;

@Repository
public class SINHVIENDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public boolean authenticate(String username, String password){
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT 1 FROM SINHVIEN WHERE MASV = :username AND PASSWORD = :password";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        if(query.uniqueResult() != null) {
            return true;
        }
        return false;
    }

    public SINHVIEN getSinhVienByMASV(String MASV) {
        Session curr = sessionFactory.getCurrentSession();
        String hql = "FROM SINHVIEN WHERE MASV = :loginuser";
        Query query = curr.createQuery(hql);
        query.setParameter("loginuser", MASV);
        SINHVIEN sv = (SINHVIEN) query.list().get(0);

        return sv;
    }
}
