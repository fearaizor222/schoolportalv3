package DAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.GIANGVIEN;
import bean.LICH;
import bean.LOPTINCHI;

@Repository
@Transactional
@SuppressWarnings("unchecked")
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

    public List<LOPTINCHI> getLopTinChiByMAGV(String MAGV) {
        Session curr = sessionFactory.getCurrentSession();
        String hql = "FROM LOPTINCHI WHERE MAGV = :magv";
        Query query = curr.createQuery(hql);
        query.setParameter("magv", MAGV);
        List<LOPTINCHI> listLopTinChi = (List<LOPTINCHI>) query.list();

        return listLopTinChi;
    }

    public List<LICH> getLichSangFromDateToDate(String MASV, Date fromDate, Date toDate) {
        Session curr = sessionFactory.getCurrentSession();
        List<LOPTINCHI> listLopTinChi = getLopTinChiByMAGV(MASV);
        List<LICH> listLichSang = new ArrayList<LICH>();

        for (int i = 0; i < 6; i++) {
            LICH placeholder = new LICH();
            placeholder.setTIETBD(-1);
            listLichSang.add(i, placeholder);
        }

        List<Date> datesInRange = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(fromDate);

        while (calendar.getTime().before(toDate)) {
            Date result = calendar.getTime();
            datesInRange.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        datesInRange.add(calendar.getTime());

        for (LOPTINCHI ltc : listLopTinChi) {
            for (int i = 0; i < 6; i++) {
                String hql = "FROM LICH WHERE MALTC = :maloptc AND NGAYHOC = :date AND TIETBD = 1";
                Query query = curr.createQuery(hql);
                query.setParameter("maloptc", ltc.getMALTC());
                query.setParameter("date", new java.sql.Date(datesInRange.get(i).getTime()));
                List<LICH> result = (List<LICH>) query.list();
                if (!result.isEmpty() && listLichSang.get(i).getTIETBD() == -1) {
                    listLichSang.set(i, result.get(0));
                }
            }
        }
        return listLichSang;
    }

    public List<LICH> getLichChieuFromDateToDate(String MASV, Date fromDate, Date toDate) {
        Session curr = sessionFactory.getCurrentSession();
        List<LOPTINCHI> listLopTinChi = getLopTinChiByMAGV(MASV);
        List<LICH> listLichChieu = new ArrayList<LICH>();

        for (int i = 0; i < 6; i++) {
            LICH placeholder = new LICH();
            placeholder.setTIETBD(-1);
            listLichChieu.add(i, placeholder);
        }

        List<Date> datesInRange = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(fromDate);

        while (calendar.getTime().before(toDate)) {
            Date result = calendar.getTime();
            datesInRange.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        datesInRange.add(calendar.getTime());

        for (LOPTINCHI ltc : listLopTinChi) {
            for (int i = 0; i < 6; i++) {
                String hql = "FROM LICH WHERE MALTC = :maloptc AND NGAYHOC = :date AND TIETBD = 7";
                Query query = curr.createQuery(hql);
                query.setParameter("maloptc", ltc.getMALTC());
                query.setParameter("date", new java.sql.Date(datesInRange.get(i).getTime()));
                List<LICH> result = (List<LICH>) query.list();
                if (!result.isEmpty() && listLichChieu.get(i).getTIETBD() == -1) {
                    listLichChieu.set(i, result.get(0));
                }
            }
        }
        return listLichChieu;
    }
}
