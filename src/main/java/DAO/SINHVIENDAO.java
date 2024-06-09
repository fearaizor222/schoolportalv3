package DAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bean.SINHVIEN;
import bean.DANGKY;
import bean.HOCPHI;
import bean.LICH;
import bean.LOPTINCHI;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class SINHVIENDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public boolean authenticate(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT 1 FROM SINHVIEN WHERE MASV = :username AND PASSWORD = :password";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        if (query.uniqueResult() != null) {
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

    public SINHVIEN getSinhvienByEmail(String Email) {
        Session curr = sessionFactory.getCurrentSession();
        String hql = "FROM SINHVIEN WHERE EMAIL = :email";
        Query query = curr.createQuery(hql);
        query.setParameter("email", Email);
        SINHVIEN sv = (SINHVIEN) query.list().get(0);

        return sv;
    }

    public boolean isDangKyDuoc(String MASV, LOPTINCHI newLopTinChi) {
        SINHVIEN sv = getSinhVienByMASV(MASV);

        List<DANGKY> existingLopTinChi = sv.getDangkys();

        for (DANGKY lopTinChi : existingLopTinChi) {
            if (lopTinChi.getLoptinchi().getMonhoc().getMAMH().equals(newLopTinChi.getMonhoc().getMAMH()) &&
                    lopTinChi.getLoptinchi().getNIENKHOA().equals(newLopTinChi.getNIENKHOA()) &&
                    lopTinChi.getLoptinchi().getHOCKY() == newLopTinChi.getHOCKY()) {
                return false;
            }
        }
        return true;
    }

    public List<HOCPHI> getHocPhiByMASV(String MASV) {
        Session curr = sessionFactory.getCurrentSession();
        String hql = "FROM HOCPHI WHERE MASV = :loginuser";
        Query query = curr.createQuery(hql);
        query.setParameter("loginuser", MASV);
        List<HOCPHI> list = query.list();

        return list;
    }

    public List<DANGKY> getDiemByMASV(String MASV) {
        Session curr = sessionFactory.getCurrentSession();
        String hql = "FROM DANGKY WHERE MASV = :loginuser";
        Query query = curr.createQuery(hql);
        query.setParameter("loginuser", MASV);
        List<DANGKY> list = query.list();

        return list;
    }

    public List<LOPTINCHI> getLopTinChiByMASV(String MASV) {
        Session curr = sessionFactory.getCurrentSession();
        List<DANGKY> listDiem = getDiemByMASV(MASV);
        List<LOPTINCHI> listLopTinChi = new ArrayList<LOPTINCHI>();
        for (DANGKY dk : listDiem) {
            String hql = "FROM LOPTINCHI WHERE MALTC = :maloptc";
            Query query = curr.createQuery(hql);
            query.setParameter("maloptc", dk.getLoptinchi().getMALTC());
            listLopTinChi.addAll((Collection<LOPTINCHI>) query.list());
        }
        return listLopTinChi;
    }

    public List<LICH> getLichByMASV(String MASV) {
        Session curr = sessionFactory.getCurrentSession();
        List<LOPTINCHI> listLopTinChi = getLopTinChiByMASV(MASV);
        List<LICH> listLich = new ArrayList<LICH>();
        for (LOPTINCHI ltc : listLopTinChi) {
            String hql = "FROM LICH WHERE MALTC = :maloptc";
            Query query = curr.createQuery(hql);
            query.setParameter("maloptc", ltc.getMALTC());
            listLich.addAll((Collection<LICH>) query.list());
        }

        return listLich;
    }

    public List<LICH> getLichThi(String MASV) {
        List<LICH> listLich = getLichByMASV(MASV);
        List<LICH> listLichThi = new ArrayList<LICH>();
        for (LICH lich : listLich) {
            if (lich.getLOAILICH() == true) {
                listLichThi.add(lich);
            }
        }
        listLichThi.sort(new Comparator<LICH>() {
            @Override
            public int compare(LICH l1, LICH l2) {
                return l2.getNGAYHOC().compareTo(l1.getNGAYHOC());
            }
        });
        return listLichThi;
    }

    public List<LICH> getLichSangFromDateToDate(String MASV, Date fromDate, Date toDate) {
        Session curr = sessionFactory.getCurrentSession();
        List<LOPTINCHI> listLopTinChi = getLopTinChiByMASV(MASV);
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
        List<LOPTINCHI> listLopTinChi = getLopTinChiByMASV(MASV);
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
