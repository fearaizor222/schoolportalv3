package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherService {
    private static final String STUDENT_PATTERN = "N\\d{2}DC(CN|VT|TD|DT|AT)\\d{3}";
    private static final String SITE_CHU = "jdbc:sqlserver://26.26.244.217:1434; Database=QLDSV_TC";
    private static final String SITE_CN = "jdbc:sqlserver://26.26.244.217:1344; Database=QLDSV_TC";
    private static final String SITE_VT = "jdbc:sqlserver://26.26.244.217:1444; Database=QLDSV_TC";
    private static final String SITE_HP = "jdbc:sqlserver://26.26.244.217:1334; Database=QLDSV_TC";

    public static String getStudentClass(String username) {
        Pattern pattern = Pattern.compile(STUDENT_PATTERN);
        Matcher matcher = pattern.matcher(username);
        if (matcher.find()) {
            String classType = matcher.group(1);
            switch (classType) {
                case "CN":
                    return SITE_CN;
                case "VT":
                    return SITE_VT;
                default:
                    return SITE_CHU;
            }
        }
        return "Unknown";
    }

    public static String getSite(int index){
        switch (index) {
            case 1:
                return SITE_CN;
            case 2:
                return SITE_VT;
            case 3:
                return SITE_HP;
            default:
                return SITE_CHU;
        }
    }

    public static boolean isStudent(String username) {
        Pattern pattern = Pattern.compile(STUDENT_PATTERN);
        Matcher matcher = pattern.matcher(username);
        return matcher.find();
    }
}
