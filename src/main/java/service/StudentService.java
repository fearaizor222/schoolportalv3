package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.DisplayHPObject;
import bean.DisplayLTCObject;
import bean.DisplayPointObject;
import bean.LOP;
import bean.SINHVIEN;

public class StudentService {
    private static Connection connection;

    public StudentService() {
    }

    public static SINHVIEN getSINHVIENByMASV(String username) {
        connection = ConnectionService.getConnection();
        SINHVIEN student = new SINHVIEN();
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public static LOP getLOPByMASV(String malop) {
        connection = ConnectionService.getConnection();

        LOP lop = new LOP();
        try {
            CallableStatement cstmt = connection.prepareCall("{call sp_getLOPByMASV(?)}");
            cstmt.setString(1, malop);
            ResultSet rs = cstmt.executeQuery();

            if (rs.next()) {
                lop.setMALOP(rs.getString("MALOP"));
                lop.setTENLOP(rs.getString("TENLOP"));
                lop.setKHOAHOC(rs.getString("KHOAHOC"));
                lop.setMAKHOA(rs.getString("MAKHOA"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lop;
    }

    public static List<DisplayPointObject> getAllDANGKYByMASV(String masv) {
        connection = ConnectionService.getConnection();

        List<DisplayPointObject> dangkys = new ArrayList<DisplayPointObject>();
        try {
            CallableStatement cstmt = connection.prepareCall("{call sp_getDisplayPoint(?)}");
            cstmt.setString(1, masv);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                DisplayPointObject dangky = new DisplayPointObject();
                dangky.setHOTEN(rs.getString("HOTEN"));
                dangky.setMAMH(rs.getString("MAMH"));
                dangky.setTENMH(rs.getString("TENMH"));
                dangky.setNIENKHOA(rs.getString("NIENKHOA"));
                dangky.setHOCKY(rs.getInt("HOCKY"));
                dangky.setNHOM(rs.getInt("NHOM"));
                dangky.setSOTINCHI(rs.getInt("SOTINCHI"));
                dangky.setDIEM_CC(rs.getInt("DIEM_CC"));
                dangky.setDIEM_GK(rs.getFloat("DIEM_GK"));
                dangky.setDIEM_CK(rs.getFloat("DIEM_CK"));

                dangkys.add(dangky);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dangkys;
    }

    public static boolean updatePASSWORDByMASV(String masv, String oldPassword, String newPassword,
            String confirmPassword) {
        connection = ConnectionService.getConnection();

        boolean isRightPass = getSINHVIENByMASV(masv).getPASSWORD().equals(oldPassword);
        boolean isNewPassMatch = newPassword.equals(confirmPassword);
        if (isRightPass && isNewPassMatch) {
            try {
                CallableStatement cstmt = connection.prepareCall("{call sp_updatePASSWORDByMASV(?, ?)}");
                cstmt.setString(1, masv);
                cstmt.setString(2, newPassword);
                cstmt.executeUpdate();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean dangKyMon(String masv, int maltc) throws Exception {
        connection = ConnectionService.getConnection();

        CallableStatement cstmt = connection.prepareCall("{call sp_dangKyMon(?, ?, ?)}");
        cstmt.setInt(1, maltc);
        cstmt.setString(2, masv);
        cstmt.setInt(3, 650000);
        cstmt.execute();
        return true;
    }

    public static boolean huyDangKyMon(String masv, int maltc) throws Exception {
        connection = ConnectionService.getConnection();

        CallableStatement cstmt = connection.prepareCall("{call sp_huyDangKyMon(?, ?, ?)}");
        cstmt.setInt(1, maltc);
        cstmt.setString(2, masv);
        cstmt.setInt(3, 650000);
        cstmt.execute();
        return true;
    }

    public static List<DisplayLTCObject> getLTCByMASV(String masv) {
        connection = ConnectionService.getConnection();

        List<DisplayLTCObject> loptinchis = new ArrayList<DisplayLTCObject>();
        try {
            CallableStatement cstmt = connection.prepareCall("{call sp_getLTCWithDADANGKY(?)}");
            cstmt.setString(1, masv);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                DisplayLTCObject loptinchi = new DisplayLTCObject();
                loptinchi.setMALTC(rs.getInt("MALTC"));
                loptinchi.setNIENKHOA(rs.getString("NIENKHOA"));
                loptinchi.setHOCKY(rs.getInt("HOCKY"));
                loptinchi.setMAMH(rs.getString("MAMH"));
                loptinchi.setNHOM(rs.getInt("NHOM"));
                loptinchi.setMAGV(rs.getString("MAGV"));
                loptinchi.setMAKHOA(rs.getString("MAKHOA"));
                loptinchi.setHUYLOP(rs.getBoolean("HUYLOP"));
                loptinchi.setDADANGKY(rs.getBoolean("DADANGKY"));
                loptinchi.setSOSVTOITHIEU(rs.getInt("SOSVTOITHIEU"));
                loptinchi.setHOTENGV(rs.getString("HOTENGV"));
                loptinchi.setTENMH(rs.getString("TENMH"));
                loptinchi.setSOSVDANGKY(rs.getInt("SOSVDANGKY"));

                loptinchis.add(loptinchi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loptinchis;
    }

    public static List<DisplayHPObject> getHPByMASV(String masv) {
        connection = ConnectionService.getConnection();

        List<DisplayHPObject> hocphis = new ArrayList<DisplayHPObject>();
        try {
            CallableStatement cstmt = connection.prepareCall("{call sp_getHOCPHIbyMASV(?)}");
            cstmt.setString(1, masv);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                DisplayHPObject hocphi = new DisplayHPObject();
                hocphi.setMASV(rs.getString("MASV"));
                hocphi.setNIENKHOA(rs.getString("NIENKHOA"));
                hocphi.setHOCKY(rs.getInt("HOCKY"));
                hocphi.setHOCPHI(rs.getInt("HOCPHI"));
                hocphi.setPAID(rs.getInt("PAID"));
                hocphi.setNGAYDONG(rs.getDate("NGAYNOPTIEN"));

                hocphis.add(hocphi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hocphis;
    }

    public static List<SINHVIEN> getAllSINHVIENByMALOP(String malop){
        connection = ConnectionService.getConnection();
        List<SINHVIEN> list = new ArrayList<SINHVIEN>();
        try {
            CallableStatement cstmt = connection.prepareCall("{call LINK0.QLDSV_TC.DBO.sp_getAllSINHVIENByMALOP(?)}");
            cstmt.setString(1, malop);
            ResultSet rs = cstmt.executeQuery();

            while(rs.next()) {
                SINHVIEN student = new SINHVIEN();
                student.setMASV(rs.getString("MASV"));
                student.setHO(rs.getString("HO"));
                student.setTEN(rs.getString("TEN"));
                student.setPHAI(rs.getBoolean("PHAI"));
                student.setDIACHI(rs.getString("DIACHI"));
                student.setNGAYSINH(rs.getDate("NGAYSINH"));
                student.setMALOP(rs.getString("MALOP"));
                student.setDANGHIHOC(rs.getBoolean("DANGHIHOC"));
                student.setPASSWORD(rs.getString("PASSWORD"));
                list.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insertSINHVIEN(String masv, String ho, String ten, boolean phai, String diachi, Date ngaysinh, String malop, String password) throws Exception{
        connection = ConnectionService.getConnection();
        CallableStatement cstmt = connection.prepareCall("{call SP_INSERTSINHVIEN(?, ?, ?, ?, ?, ?, ?, ?)}");
        cstmt.setString(1, masv);
        cstmt.setString(2, ho);
        cstmt.setString(3, ten);
        cstmt.setBoolean(4, phai);
        cstmt.setString(5, diachi);
        cstmt.setDate(6, ngaysinh);
        cstmt.setString(7, malop);
        cstmt.setString(8, password);
        cstmt.execute();
    }

    public static void updateSINHVIEN(String masv, String ho, String ten, boolean phai, String diachi, Date ngaysinh, boolean danghi, String password) throws Exception{
        connection = ConnectionService.getConnection();
        CallableStatement cstmt = connection.prepareCall("{call sp_updateSINHVIEN(?, ?, ?, ?, ?, ?, ?, ?)}");
        cstmt.setString(1, masv);
        cstmt.setString(2, ho);
        cstmt.setString(3, ten);
        cstmt.setBoolean(4, phai);
        cstmt.setString(5, diachi);
        cstmt.setDate(6, ngaysinh);
        cstmt.setBoolean(7, danghi);
        cstmt.setString(8, password);

        cstmt.execute();
    }

    public static void xacnhanHOCPHI(String masv, String nienkhoa, int hocky, int hocphi) throws Exception{
        connection = ConnectionService.getConnection();
        CallableStatement cstmt = connection.prepareCall("{call sp_xacnhanHOCPHI(?, ?, ?, ?)}");
        cstmt.setString(1, masv);
        cstmt.setString(2, nienkhoa);
        cstmt.setInt(3, hocky);
        cstmt.setInt(4, hocphi);

        cstmt.execute();
    }
}
