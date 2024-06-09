package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import bean.HOCPHI.HocPhiId;

@Entity
@Table(name = "SINHVIEN")
public class SINHVIEN {
    @Id
    private String MASV;
    private String HO;
    private String TEN;
    private boolean PHAI;
    private String DIACHI;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NGAYSINH;
    @ManyToOne
    @JoinColumn(name = "MALOP")
    private LOP lop;
    private boolean DANGHIHOC;
    private String PASSWORD;
    private String EMAIL;
    private String LINKANH;

    @OneToMany(mappedBy = "sinhvien")
    private List<DANGKY> dangkys;

    @OneToMany(mappedBy = "sinhVien")
    private List<HOCPHI> hocPhis;

    public List<HOCPHI> getHocPhis() {
        return hocPhis;
    }

    public HOCPHI getHocPhiTheoKey(HocPhiId hocPhiId) {
        for (HOCPHI hocPhi : hocPhis) {
            HocPhiId temp = hocPhi.getHocPhiId();
            if (temp.getMASV().equals(hocPhiId.getMASV())
                    && temp.getNIENKHOA().equals(hocPhiId.getNIENKHOA())
                    && temp.getHOCKY() == hocPhiId.getHOCKY()) {
                return hocPhi;
            }
        }
        return null;
    }

    public List<LOPTINCHI> getLopTinChiTheoNienKhoaHocKy(String nienKhoa, int hocKy) {
        List<LOPTINCHI> lopTinChi = new ArrayList<>();
        try{
            for (DANGKY dangKy : dangkys) {
                if (dangKy.getLoptinchi().getHOCKY() == hocKy
                        && dangKy.getLoptinchi().getNIENKHOA().equals(nienKhoa)) {
                    lopTinChi.add(dangKy.getLoptinchi());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lopTinChi;
    }

    public int getSoTinChiDaDangKyTheoKy(String nienKhoa, int hocKy) {
        int soTinChi = 0;
        List<LOPTINCHI> lopTinChi = getLopTinChiTheoNienKhoaHocKy(nienKhoa, hocKy);
        for (LOPTINCHI lop : lopTinChi) {
            soTinChi += lop.getMonhoc().getSOTINCHI();
        }
        return soTinChi;
    }

    public int getTongTienCanDongTrongKy(String nienKhoa, int hocKy) {
        int sotinchi = getSoTinChiDaDangKyTheoKy(nienKhoa, hocKy);
        int tongTien = sotinchi * 600000;

        // getHocPhiTheoKey(new HocPhiId(MASV, nienKhoa, hocKy)).setHOCPHI(tongTien);
        
        return tongTien;
    }

    public void setHocPhis(List<HOCPHI> hocPhis) {
        this.hocPhis = hocPhis;
    }

    public List<DANGKY> getDangkys() {
        return dangkys;
    }

    public void setDangkys(List<DANGKY> dangkys) {
        this.dangkys = dangkys;
    }

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

    public LOP getLop() {
        return lop;
    }

    public void setLop(LOP lop) {
        this.lop = lop;
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

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getLINKANH() {
        return LINKANH;
    }

    public void setLINKANH(String LINKANH) {
        this.LINKANH = LINKANH;
    }
}
