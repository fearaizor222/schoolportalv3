package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.DANGKY;
import bean.LOP;
import bean.SINHVIEN;

public class StudentService {
    private static Connection connection;

    public StudentService() {
    }

    public static void setConnection(Connection connection) {
        StudentService.connection = connection;
    }

    public static SINHVIEN getSINHVIENByMASV(String username) {
        SINHVIEN student = new SINHVIEN();
        try{
            CallableStatement cstmt = connection.prepareCall("{call sp_getSINHVIENByMASV(?)}");
            cstmt.setString(1, username);
            ResultSet rs = cstmt.executeQuery();

            if (rs.next()) {
                student.setMASV(rs.getString("MASV"));
                student.setHO(rs.getString("HO"));
                student.setTEN(rs.getString("TEN"));
                student.setPHAI(rs.getBoolean("PHAI"));
                student.setDIACHI(rs.getString("DIACHI"));
                student.setNGAYSINH(rs.getDate("NGAYSINH"));
                student.setMALOP(rs.getString("MALOP"));
                student.setDANGHIHOC(rs.getBoolean("DANGHIHOC"));
                student.setPASSWORD(rs.getString("PASSWORD"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public static LOP getLOPByMASV(String malop) {
        LOP lop = new LOP();
        try{
            CallableStatement cstmt = connection.prepareCall("{call sp_getLOPByMASV(?)}");
            cstmt.setString(1, malop);
            ResultSet rs = cstmt.executeQuery();

            if (rs.next()) {
                lop.setMALOP(rs.getString("MALOP"));
                lop.setTENLOP(rs.getString("TENLOP"));
                lop.setKHOAHOC(rs.getString("KHOAHOC"));
                lop.setMAKHOA(rs.getString("MAKHOA"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return lop;
    }

    public static List<DANGKY> getAllDANGKYByMASV(String masv) {
        List<DANGKY> dangkys = new ArrayList<DANGKY>();
        try{
            CallableStatement cstmt = connection.prepareCall("{call sp_getAllDANGKYByMASV(?)}");
            cstmt.setString(1, masv);
            ResultSet rs = cstmt.executeQuery();

            while(rs.next()) {
                DANGKY dangky = new DANGKY();
                dangky.setMALTC(rs.getInt("MALTC"));
                dangky.setMASV(rs.getString("MASV"));
                dangky.setDIEM_CC(rs.getInt("DIEM_CC"));
                dangky.setDIEM_GK(rs.getFloat("DIEM_GK"));
                dangky.setDIEM_CK(rs.getFloat("DIEM_CK"));
                dangky.setHUYDANGKY(rs.getBoolean("HUYDANGKY"));

                dangkys.add(dangky);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return dangkys;
    }

    public static boolean updatePASSWORDByMASV(String masv, String oldPassword, String newPassword, String confirmPassword) {
        boolean isRightPass = getSINHVIENByMASV(masv).getPASSWORD().equals(oldPassword);
        boolean isNewPassMatch = newPassword.equals(confirmPassword);
        if (isRightPass && isNewPassMatch) {
            try{
                CallableStatement cstmt = connection.prepareCall("{call sp_updatePASSWORDByMASV(?, ?)}");
                cstmt.setString(1, masv);
                cstmt.setString(2, newPassword);
                cstmt.executeUpdate();
                return true;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
