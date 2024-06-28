package bean;

import java.sql.Date;

public class SINHVIEN {
    private String MASV;
    private String HO;
    private String TEN;
    private boolean PHAI;
    private String DIACHI;
    private Date NGAYSINH;
    private String MALOP;
    private boolean DANGHIHOC;
    private String PASSWORD;

    

    public SINHVIEN() {
        this.MASV = "";
        this.HO = "";
        this.TEN = "";
        this.PHAI = false;
        this.DIACHI = "";
        this.NGAYSINH = new Date(0);
        this.MALOP = "";
        this.DANGHIHOC = false;
        this.PASSWORD = "";
    }

    public SINHVIEN(String MASV, String HO, String TEN, boolean PHAI, String DIACHI, Date NGAYSINH, String MALOP, boolean DANGHIHOC, String PASSWORD) {
        this.MASV = MASV;
        this.HO = HO;
        this.TEN = TEN;
        this.PHAI = PHAI;
        this.DIACHI = DIACHI;
        this.NGAYSINH = NGAYSINH;
        this.MALOP = MALOP;
        this.DANGHIHOC = DANGHIHOC;
        this.PASSWORD = PASSWORD;
    }

    // public HOCPHI getHocPhiTheoKey(HocPhiId hocPhiId) {
    //     for (HOCPHI hocPhi : hocPhis) {
    //         HocPhiId temp = hocPhi.getHocPhiId();
    //         if (temp.getMASV().equals(hocPhiId.getMASV())
    //                 && temp.getNIENKHOA().equals(hocPhiId.getNIENKHOA())
    //                 && temp.getHOCKY() == hocPhiId.getHOCKY()) {
    //             return hocPhi;
    //         }
    //     }
    //     return null;
    // }

    // public List<LOPTINCHI> getLopTinChiTheoNienKhoaHocKy(String nienKhoa, int hocKy) {
    //     List<LOPTINCHI> lopTinChi = new ArrayList<>();
    //     try{
    //         for (DANGKY dangKy : dangkys) {
    //             if (dangKy.getLoptinchi().getHOCKY() == hocKy
    //                     && dangKy.getLoptinchi().getNIENKHOA().equals(nienKhoa)) {
    //                 lopTinChi.add(dangKy.getLoptinchi());
    //             }
    //         }
    //     }
    //     catch (Exception e){
    //         e.printStackTrace();
    //     }
    //     return lopTinChi;
    // }

    // public int getSoTinChiDaDangKyTheoKy(String nienKhoa, int hocKy) {
    //     int soTinChi = 0;
    //     List<LOPTINCHI> lopTinChi = getLopTinChiTheoNienKhoaHocKy(nienKhoa, hocKy);
    //     for (LOPTINCHI lop : lopTinChi) {
    //         soTinChi += lop.getMonhoc().getSOTINCHI();
    //     }
    //     return soTinChi;
    // }

    // public int getTongTienCanDongTrongKy(String nienKhoa, int hocKy) {
    //     int sotinchi = getSoTinChiDaDangKyTheoKy(nienKhoa, hocKy);
    //     int tongTien = sotinchi * 600000;

    //     // getHocPhiTheoKey(new HocPhiId(MASV, nienKhoa, hocKy)).setHOCPHI(tongTien);
        
    //     return tongTien;
    // }

    // public void setHocPhis(List<HOCPHI> hocPhis) {
    //     this.hocPhis = hocPhis;
    // }

    // public List<DANGKY> getDangkys() {
    //     return dangkys;
    // }

    // public void setDangkys(List<DANGKY> dangkys) {
    //     this.dangkys = dangkys;
    // }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public String getHO() {
        return HO;
    }

    public void setHO(String HO) {
        this.HO = HO;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public boolean isPHAI() {
        return PHAI;
    }

    public void setPHAI(boolean PHAI) {
        this.PHAI = PHAI;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public Date getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(Date NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public String getMALOP() {
        return MALOP;
    }

    public void setMALOP(String MALOP) {
        this.MALOP = MALOP;
    }

    public boolean isDANGHIHOC() {
        return DANGHIHOC;
    }

    public void setDANGHIHOC(boolean DANGHIHOC) {
        this.DANGHIHOC = DANGHIHOC;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
