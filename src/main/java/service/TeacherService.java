package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;

import java.util.List;

import bean.DisplayLTCObject;
import bean.GIANGVIEN;

public class TeacherService {
    private static Connection connection;

    public TeacherService() {
    }

    public static void setConnection(Connection connection) {
        TeacherService.connection = connection;
    }

    public static GIANGVIEN getGIANGVIENByMAGV(String username) {
        GIANGVIEN teacher = new GIANGVIEN();
        try {
            CallableStatement cstmt = connection.prepareCall("{call sp_getGIANGVIENByMAGV(?)}");
            cstmt.setString(1, username);
            ResultSet rs = cstmt.executeQuery();

            if (rs.next()) {
                teacher.setMAGV(rs.getString("MAGV"));
                teacher.setHO(rs.getString("HO"));
                teacher.setTEN(rs.getString("TEN"));
                teacher.setMAKHOA(rs.getString("MAKHOA"));
                teacher.setHOCVI(rs.getString("HOCVI"));
                teacher.setHOCHAM(rs.getString("HOCHAM"));
                teacher.setCHUYENMON(rs.getString("CHUYENMON"));
                teacher.setPASSWORD(rs.getString("PASSWORD"));
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
}