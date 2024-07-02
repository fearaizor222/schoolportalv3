package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.KHOA;
import bean.LOPTINCHI;

public class CreditClassService {
    private static Connection connection;

    public CreditClassService() {

    }

    public static List<LOPTINCHI> getAllLTC() {
        connection = ConnectionService.getConnection();
        List<LOPTINCHI> list = new ArrayList<LOPTINCHI>();
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM LINK0.QLDSV_TC.DBO.v_getAllLTC";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                LOPTINCHI loptinchi = new LOPTINCHI();
                loptinchi.setMALTC(rs.getInt("MALTC"));
                loptinchi.setNIENKHOA(rs.getString("NIENKHOA"));
                loptinchi.setHOCKY(rs.getInt("HOCKY"));
                loptinchi.setMAMH(rs.getString("MAMH"));
                loptinchi.setNHOM(rs.getInt("NHOM"));
                loptinchi.setMAGV(rs.getString("MAGV"));
                loptinchi.setMAKHOA(rs.getString("MAKHOA"));
                loptinchi.setSOSVTOITHIEU(rs.getInt("SOSVTOITHIEU"));
                loptinchi.setHUYLOP(rs.getBoolean("HUYLOP"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insertCreditClass(String nienkhoa, int hocky, String mamh, int nhom, String magv,
            String makhoa, int sosvtoithieu) throws Exception {
        connection = ConnectionService.getConnection();

        CallableStatement cstmt = connection.prepareCall("{call SP_INSERTLTC(?,?,?,?,?,?,?)}");
        cstmt.setString(1, nienkhoa);
        cstmt.setInt(2, hocky);
        cstmt.setString(3, mamh);
        cstmt.setInt(4, nhom);
        cstmt.setString(5, magv);
        cstmt.setString(6, makhoa);
        cstmt.setInt(7, sosvtoithieu);
        cstmt.execute();
    }

    public static void deleteCreditClass(int maltc) throws Exception {
        connection = ConnectionService.getConnection();

        CallableStatement cstmt = connection.prepareCall("{call SP_DELETELTC(?)}");
        cstmt.setInt(1, maltc);
        cstmt.execute();
    }

    public static void updateCreditClass(int maltc, String nienkhoa, int hocky, int nhom, int sosvtoithieu)
            throws Exception {
        connection = ConnectionService.getConnection();

        CallableStatement cstmt = connection.prepareCall("{call SP_UPDATELTC(?,?,?,?,?)}");
        cstmt.setInt(1, maltc);
        cstmt.setString(2, nienkhoa);
        cstmt.setInt(3, hocky);
        cstmt.setInt(4, nhom);
        cstmt.setInt(5, sosvtoithieu);
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
}
