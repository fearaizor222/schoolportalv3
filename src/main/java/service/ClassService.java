package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.KHOA;
import bean.LOP;
import bean.REPORTHOCPHI;

public class ClassService {
    private static Connection connection;

    public ClassService() {
    }

    public static List<LOP> getAllLOP() {
        connection = ConnectionService.getConnection();
        List<LOP> list = new ArrayList<LOP>();
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT *, k.TENKHOA FROM LINK0.QLDSV_TC.DBO.v_getAllLOP l JOIN LINK0.QLDSV_TC.DBO.KHOA k ON l.MAKHOA = k.MAKHOA";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                LOP lop = new LOP();
                lop.setMALOP(rs.getString("MALOP"));
                lop.setTENLOP(rs.getString("TENLOP"));
                lop.setKHOAHOC(rs.getString("KHOAHOC"));
                lop.setMAKHOA(rs.getString("MAKHOA"));
                lop.setTENKHOA(rs.getString("TENKHOA"));
                list.add(lop);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insertClass(String malop, String tenlop, String khoahoc, String makhoa) throws Exception {
        connection = ConnectionService.getConnection();

        CallableStatement cstmt = connection.prepareCall("{call SP_INSERTLOP(?,?,?,?)}");
        cstmt.setString(1, malop);
        cstmt.setString(2, tenlop);
        cstmt.setString(3, khoahoc);
        cstmt.setString(4, makhoa);
        cstmt.execute();
    }

    public static void deleteClass(String mALOP) throws Exception {
        connection = ConnectionService.getConnection();
        CallableStatement cstmt = connection.prepareCall("{call SP_DELETELOP(?)}");
        cstmt.setString(1, mALOP);
        cstmt.execute();
    }

    public static void updateClass(String malop, String tenlop, String khoahoc) throws Exception {
        connection = ConnectionService.getConnection();
        CallableStatement cstmt = connection.prepareCall("{call SP_UPDATELOP(?,?,?)}");
        cstmt.setString(1, malop);
        cstmt.setString(2, tenlop);
        cstmt.setString(3, khoahoc);
        cstmt.execute();
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

    public static List<REPORTHOCPHI> getReportHocPhi(String malop, String nienkhoa, int hocky) throws Exception {
        connection = ConnectionService.getConnection();

        List<REPORTHOCPHI> list = new ArrayList<REPORTHOCPHI>();
        CallableStatement cstmt = connection.prepareCall("{call SP_REPORT_DSHOCPHI_LOP(?,?,?)}");
        cstmt.setString(1, malop);
        cstmt.setString(2, nienkhoa); // nienkhoa (e.g. 2021-2022)
        cstmt.setInt(3, hocky);
        ResultSet rs = cstmt.executeQuery();
        while (rs.next()) {
            REPORTHOCPHI reportHOCPHI = new REPORTHOCPHI();
            reportHOCPHI.setHOTEN(rs.getString("HOTEN"));
            reportHOCPHI.setHOCPHI(rs.getInt("HOCPHI"));
            reportHOCPHI.setSOTIENDADONG(rs.getInt("SOTIENDADONG"));
            reportHOCPHI.setTENKHOA(rs.getString("TENKHOA"));
            list.add(reportHOCPHI);
        }
        return list;
    }

}
