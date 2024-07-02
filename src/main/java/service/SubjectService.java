package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DisplayMONHOCObject;

public class SubjectService {
    private static Connection connection;

    public SubjectService() {
    }

    //Get all MONHOC
    public static List<DisplayMONHOCObject> getAllMONHOC() {
        connection = ConnectionService.getConnection();
        List<DisplayMONHOCObject> list = new ArrayList<>();
        try {
            CallableStatement cstmt = connection.prepareCall("{call SP_getAllMONHOC}");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                DisplayMONHOCObject monhoc = new DisplayMONHOCObject();
                monhoc.setMAMH(rs.getString("MAMH"));
                monhoc.setTENMH(rs.getString("TENMH"));
                monhoc.setSOTIET_LT(rs.getInt("SOTIET_LT"));
                monhoc.setSOTIET_TH(rs.getInt("SOTIET_TH"));
                monhoc.setSOTINCHI(rs.getInt("SOTINCHI"));
                list.add(monhoc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
}

    public static void insertMonHoc(String mamh, String tenmh, int sotiet_lt, int sotiet_th, int sotinchi) throws Exception {
        connection = ConnectionService.getConnection();
        CallableStatement cstmt = connection.prepareCall("{call SP_INSERTMONHOC(?,?,?,?,?)}");
        cstmt.setString(1, mamh);
        cstmt.setString(2, tenmh);
        cstmt.setInt(3, sotiet_lt);
        cstmt.setInt(4, sotiet_th);
        cstmt.setInt(5, sotinchi);
        cstmt.execute();
    }

    public static void updateMonHoc(String mamh, String tenmh, int sotiet_lt, int sotiet_th, int sotinchi) throws Exception {
        connection = ConnectionService.getConnection();
        CallableStatement cstmt = connection.prepareCall("{call SP_UPDATEMONHOC(?,?,?,?,?)}");
        cstmt.setString(1, mamh);
        cstmt.setString(2, tenmh);
        cstmt.setInt(3, sotiet_lt);
        cstmt.setInt(4, sotiet_th);
        cstmt.setInt(5, sotinchi);
        cstmt.execute();
    }

    public static void deleteMonHoc(String mamh) throws Exception {
        connection = ConnectionService.getConnection();
        CallableStatement cstmt = connection.prepareCall("{call SP_DELETEMONHOC(?)}");
        cstmt.setString(1, mamh);
        cstmt.execute();
    }

}
