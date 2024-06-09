package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SETTINGSDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public int getHOCKY() {
        Session session = sessionFactory.getCurrentSession();
        return (int)session.createQuery("SELECT HOCKY FROM SETTINGS").list().get(0);
    }

    public String getNIENKHOA() {
        Session session = sessionFactory.getCurrentSession();
        return (String)session.createQuery("SELECT NIENKHOA FROM SETTINGS").list().get(0);
    }

    public boolean getDANGKYMON() {
        Session session = sessionFactory.getCurrentSession();
        return (boolean)session.createQuery("SELECT DANGKYMON FROM SETTINGS").list().get(0);
    }

    public void setHOCKY(int hocky) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("UPDATE SETTINGS SET HOCKY = :hocky").setParameter("hocky", hocky).executeUpdate();
    }

    public void setNIENKHOA(String nienkhoa) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("UPDATE SETTINGS SET NIENKHOA = :nienkhoa").setParameter("nienkhoa", nienkhoa).executeUpdate();
    }

    public void setDANGKYMON(boolean dangkymon) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("UPDATE SETTINGS SET DANGKYMON = :dangkymon").setParameter("dangkymon", dangkymon).executeUpdate();
    }
}
