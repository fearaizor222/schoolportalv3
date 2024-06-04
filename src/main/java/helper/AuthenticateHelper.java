package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

public class AuthenticateHelper {
    public static boolean isStudent(String input) {
        Pattern compiledPattern = Pattern.compile("N\\d{2}DC(CN|VT|TD|DT|AT)\\d{3}");
        Matcher matcher = compiledPattern.matcher(input);
        return matcher.find();
    }

    public static boolean isTeacher(String input) {
        Pattern compiledPattern = Pattern.compile("GV\\d{2}");
        Matcher matcher = compiledPattern.matcher(input);
        return matcher.find();
    }

    @Transactional
    public static boolean authenticateStudent(String username, String password, Session session) {
        String hql = "SELECT 1 FROM SINHVIEN WHERE MASV = :username AND PASSWORD = :password";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        if(query.uniqueResult() != null) {
            return true;
        }
        return false;
    }

    @Transactional
    public static boolean authenticateTeacher(String username, String password, Session session) {
        String hql = "SELECT 1 FROM GIAOVIEN WHERE MAGV = :username AND PASSWORD = :password";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        if(query.uniqueResult() != null) {
            return true;
        }
        return false;
    }
}
