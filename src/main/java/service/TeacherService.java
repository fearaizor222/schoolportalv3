package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import bean.DisplayLTCObject;
import bean.GIANGVIEN;
import bean.KHOA;

public class TeacherService {
    private static Connection connection;

    public TeacherService() {
    }

    public static void setConnection(Connection connection) {
        TeacherService.connection = connection;
    }

    public static GIANGVIEN getGIANGVIENByMAGV(String username) {
        connection = ConnectionService.getConnection();
        GIANGVIEN teacher = new GIANGVIEN();
        try {
            CallableStatement cstmt = connection.prepareCall("{call SP_getGIANGVIENbyMAGV(?)}");
            cstmt.setString(1, username);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                teacher.setMAGV(rs.getString("MAGV"));
                teacher.setMAKHOA(rs.getString("MAKHOA"));
                teacher.setHO(rs.getString("HO"));
                teacher.setTEN(rs.getString("TEN"));
                teacher.setHOCVI(rs.getString("HOCVI"));
                teacher.setHOCHAM(rs.getString("HOCHAM"));
                teacher.setCHUYENMON(rs.getString("CHUYENMON"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacher;
    }

    public static boolean updatePASSWORDByMAGV(String magv, String oldPassword, String newPassword,
            String confirmPassword) {
        boolean isRightPass = getGIANGVIENByMAGV(magv).getPASSWORD().equals(oldPassword);
        boolean isNewPassMatch = newPassword.equals(confirmPassword);
        if (isRightPass && isNewPassMatch) {
            try {
                CallableStatement cstmt = connection.prepareCall("{call sp_updatePASSWORDByMAGV(?, ?)}");
                cstmt.setString(1, magv);
                cstmt.setString(2, newPassword);
                cstmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static List<DisplayLTCObject> getAllLTCByNienKhoaHocKy(String nienKhoa, int hocKy, String maKhoa) {
        Connection connection = ConnectionService.getConnection();
        List<DisplayLTCObject> loptinchis = new ArrayList<>();

        try {
            CallableStatement cstmt = connection.prepareCall("{call SP_DSLTC(?, ?, ?)}");
            cstmt.setString(1, nienKhoa);
            cstmt.setInt(2, hocKy);
            cstmt.setString(3, maKhoa);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                if (!rs.getBoolean("HUYLOP")) {
                    DisplayLTCObject loptinchi = new DisplayLTCObject();

                    loptinchi.setTENMH(rs.getString("TENMH"));
                    loptinchi.setNHOM(rs.getInt("NHOM"));
                    loptinchi.setHOTENGV(rs.getString("HOTENGV"));
                    loptinchi.setSOSVTOITHIEU(rs.getInt("SOSVTOITHIEU"));
                    loptinchi.setSOSVDANGKY(rs.getInt("SOSVDANGKY"));
                    loptinchis.add(loptinchi);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loptinchis;
    }

    public static List<DisplayLTCObject> getAllLTC() {
        Connection connection = ConnectionService.getConnection();
        List<DisplayLTCObject> loptinchis = new ArrayList<>();

        try {
            CallableStatement cstmt = connection.prepareCall("{call sp_getAllLOPTINCHI}");
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                DisplayLTCObject loptinchi = new DisplayLTCObject();
                loptinchi.setMALTC(rs.getInt("MALTC"));
                loptinchi.setNIENKHOA(rs.getString("NIENKHOA"));
                loptinchi.setHOCKY(rs.getInt("HOCKY"));
                loptinchi.setMAMH(rs.getString("MAMH"));
                loptinchi.setTENMH(rs.getString("TENMH"));
                loptinchi.setNHOM(rs.getInt("NHOM"));
                loptinchi.setMAGV(rs.getString("MAGV"));
                loptinchi.setHOTENGV(rs.getString("HOTENGV"));
                loptinchi.setMAKHOA(rs.getString("MAKHOA"));
                loptinchi.setSOSVTOITHIEU(rs.getInt("SOSVTOITHIEU"));
                loptinchi.setSOSVDANGKY(rs.getInt("SOSVDANGKY"));
                loptinchis.add(loptinchi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loptinchis;
    }

    public static List<DisplayLTCObject> getAllLTCByMAGV(String magv) {
        Connection connection = ConnectionService.getConnection();
        List<DisplayLTCObject> loptinchis = new ArrayList<>();

        try {
            CallableStatement cstmt = connection.prepareCall("{call sp_getAllLTCByMAGV(?)}");
            cstmt.setString(1, magv);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                DisplayLTCObject loptinchi = new DisplayLTCObject();
                loptinchi.setMALTC(rs.getInt("MALTC"));
                loptinchi.setNIENKHOA(rs.getString("NIENKHOA"));
                loptinchi.setHOCKY(rs.getInt("HOCKY"));
                loptinchi.setNHOM(rs.getInt("NHOM"));
                loptinchi.setMAMH(rs.getString("MAMH"));
                loptinchis.add(loptinchi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loptinchis;
    }

    public static List<KHOA> getAllKHOA() {
        connection = ConnectionService.getConnection();
        List<KHOA> list = new ArrayList<KHOA>();
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM LINK0.QLDSV_TC.DBO.v_getAllKHOA";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KHOA khoa = new KHOA();
                khoa.setMAKHOA(rs.getString("MAKHOA"));
                khoa.setTENKHOA(rs.getString("TENKHOA"));
                list.add(khoa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<GIANGVIEN> getAllGIANGVIEN() {
        connection = ConnectionService.getConnection();
        List<GIANGVIEN> list = new ArrayList<GIANGVIEN>();
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM v_getAllGIANGVIEN";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                GIANGVIEN gv = new GIANGVIEN();
                gv.setMAGV(rs.getString("MAGV"));
                gv.setMAKHOA(rs.getString("MAKHOA"));
                gv.setHO(rs.getString("HO"));
                gv.setTEN(rs.getString("TEN"));
                // gv.setHOCVI(rs.getString("HOCVI"));
                // gv.setHOCHAM(rs.getString("HOCHAM"));
                // gv.setCHUYENMON(rs.getString("CHUYENMON"));
                list.add(gv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void taoLOGIN(String lgname, String password, String role) throws Exception {
        connection = ConnectionService.getConnection();
        CallableStatement cstmt = connection.prepareCall("{call sp_taoLOGIN(?, ?, ?, ?)}");
        cstmt.setString(1, lgname);
        cstmt.setString(2, password);
        cstmt.setString(3, lgname);
        cstmt.setString(4, role);
        cstmt.executeUpdate();
    }
}