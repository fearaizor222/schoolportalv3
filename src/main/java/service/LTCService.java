package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.DANGKYObjectWithName;
import bean.MONHOC;
import bean.REPORT_DSLTCObject;
import bean.REPORTDSSVLTCObject;

public class LTCService {
    private static Connection connection;

    public LTCService() {
    }

    public static List<MONHOC> getAllMONHOC() {
        connection = ConnectionService.getConnection();

        List<MONHOC> monhocList = new ArrayList<MONHOC>();
        try {
            String sql = "SELECT * FROM v_getALLMONHOC";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MONHOC monhoc = new MONHOC();
                monhoc.setMAMH(resultSet.getString("MAMH"));
                monhoc.setTENMH(resultSet.getString("TENMH"));
                monhoc.setSOTIET_LT(resultSet.getInt("SOTIET_LT"));
                monhoc.setSOTIET_TH(resultSet.getInt("SOTIET_TH"));
                monhoc.setSOTINCHI(resultSet.getInt("SOTINCHI"));
                monhocList.add(monhoc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return monhocList;
    }

    public static List<DANGKYObjectWithName> getDANGKYOfLTC(String nienkhoa, int hocky, String monhoc, int nhom){
        connection = ConnectionService.getConnection();

        List<DANGKYObjectWithName> dangkyList = new ArrayList<DANGKYObjectWithName>();
        try {
            CallableStatement cstmt = connection.prepareCall("{call sp_getDANGKYOfLTC(?,?,?,?)}");
            cstmt.setString(1, nienkhoa);
            cstmt.setInt(2, hocky);
            cstmt.setInt(3, nhom);
            cstmt.setString(4, monhoc);
            ResultSet resultSet = cstmt.executeQuery();
            while (resultSet.next()) {
                DANGKYObjectWithName dangky = new DANGKYObjectWithName();
                dangky.setMALTC(resultSet.getInt("MALTC"));
                dangky.setMASV(resultSet.getString("MASV"));
                dangky.setDIEM_CC(resultSet.getInt("DIEM_CC"));
                dangky.setDIEM_GK(resultSet.getFloat("DIEM_GK"));
                dangky.setDIEM_CK(resultSet.getFloat("DIEM_CK"));
                dangky.setHUYDANGKY(resultSet.getBoolean("HUYDANGKY"));
                dangky.setHOTEN(resultSet.getString("HOTEN"));
                dangky.setMAKHOA(resultSet.getString("MAKHOA"));
                dangkyList.add(dangky);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dangkyList;
    }

    public static void updateDIEM(String maltc, String masv, int diemcc, float diemgk, float diemck) throws Exception {
        connection = ConnectionService.getConnection();
            CallableStatement cstmt = connection.prepareCall("{call SP_INSERTDIEM(?,?,?,?,?)}");
            cstmt.setString(1, maltc);
            cstmt.setString(2, masv);
            cstmt.setInt(3, diemcc);
            cstmt.setFloat(4, diemgk);
            cstmt.setFloat(5, diemck);
            cstmt.executeUpdate();
    }

    public static List<REPORT_DSLTCObject> getDSLTC(String nienkhoa, int hocky) throws Exception{
        connection = ConnectionService.getConnection();

        List<REPORT_DSLTCObject> reportDSLTCList = new ArrayList<REPORT_DSLTCObject>();
        CallableStatement cstmt = connection.prepareCall("{call SP_REPORT_LOPTINCHI(?,?)}");
        cstmt.setString(1, nienkhoa);
        cstmt.setInt(2, hocky);
        ResultSet resultSet = cstmt.executeQuery();
        while (resultSet.next()) {
            REPORT_DSLTCObject reportDSLTC = new REPORT_DSLTCObject();
            reportDSLTC.setMONHOC(resultSet.getString("MONHOC"));
            reportDSLTC.setNHOM(resultSet.getInt("NHOM"));
            reportDSLTC.setGIANGVIEN(resultSet.getString("GIANGVIEN"));
            reportDSLTC.setSOSVTOITHIEU(resultSet.getInt("SOSVTOITHIEU"));
            reportDSLTC.setSVDANGKY(resultSet.getInt("SVDANGKY"));
            reportDSLTCList.add(reportDSLTC);
        }

        return reportDSLTCList;
    }

    public static List<REPORTDSSVLTCObject> getDSSVLTC(String nienkhoa, int hocky, String mamonhoc, int nhom) {
        connection = ConnectionService.getConnection();

        List<REPORTDSSVLTCObject> reportDSSVLTCList = new ArrayList<REPORTDSSVLTCObject>();
        try {
            CallableStatement cstmt = connection.prepareCall("{call SP_REPORT_SINHVIENLTC(?,?,?,?)}");
        cstmt.setString(1, nienkhoa);
        cstmt.setInt(2, hocky);
        cstmt.setString(3, mamonhoc);
        cstmt.setInt(4, nhom);
        ResultSet resultSet = cstmt.executeQuery();
        while (resultSet.next()) {
                REPORTDSSVLTCObject reportDSSVLTC = new REPORTDSSVLTCObject();
                reportDSSVLTC.setMASV(resultSet.getString("MASV"));
                reportDSSVLTC.setHO(resultSet.getString("HO"));
                reportDSSVLTC.setTEN(resultSet.getString("TEN"));
                reportDSSVLTC.setPHAI(resultSet.getBoolean("PHAI"));
                reportDSSVLTC.setMALOP(resultSet.getString("MALOP"));
                reportDSSVLTCList.add(reportDSSVLTC);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reportDSSVLTCList;
    }
}
