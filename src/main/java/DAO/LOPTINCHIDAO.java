package DAO;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.LOPTINCHI;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class LOPTINCHIDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<LOPTINCHI> getAllLopTinChiCurrent(String NIENKHOA, int HOCKY){
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM LOPTINCHI WHERE NIENKHOA = :nienkhoa AND HOCKY = :hocky ORDER BY HOCKY ASC";
        Query query = session.createQuery(hql);
        query.setParameter("nienkhoa", NIENKHOA);
        query.setParameter("hocky", HOCKY);
        return query.list();
    }

    public Set<String> getAllNIENKHOA(){
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM LOPTINCHI";
        Query query = session.createQuery(hql);
        Set<String> list = new TreeSet<>(Comparator.reverseOrder());
        for(LOPTINCHI ltc : (List<LOPTINCHI>)query.list()){
                list.add(ltc.getNIENKHOA());
        }
        return list;
    }
}