package bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOPTINCHI")
public class LOPTINCHI {
    @Id
    @GeneratedValue
    private int MALTC;
    private String NIENKHOA;
    private int HOCKY;
    @ManyToOne
    @JoinColumn(name = "MAMH")
    private MONHOC monhoc;
    private int NHOM;
    @ManyToOne
    @JoinColumn(name = "MAGV")
    private GIANGVIEN giangvien;
    @ManyToOne
    @JoinColumn(name = "MAKHOA")
    private KHOA khoa;
    private int SOSVTOITHIEU;
    private boolean HUYLOP;

    @OneToMany(mappedBy = "loptinchi")
    private List<DANGKY> dangkys;

    public List<DANGKY> getDangkys() {
        return dangkys;
    }

    public void setDangkys(List<DANGKY> dangkys) {
        this.dangkys = dangkys;
    }

    public boolean hasThisSINHVIEN(String MASV){
        for (DANGKY dangky : dangkys) {
            if (dangky.getSinhVien().getMASV().equals(MASV)) {
                return true;
            }
        }
        return false;
    }

    public int getMALTC() {
        return MALTC;
    }

    public void setMALTC(int mALTC) {
        MALTC = mALTC;
    }

    public String getNIENKHOA() {
        return NIENKHOA;
    }

    public void setNIENKHOA(String nIENKHOA) {
        NIENKHOA = nIENKHOA;
    }

    public int getHOCKY() {
        return HOCKY;
    }

    public void setHOCKY(int hOCKY) {
        HOCKY = hOCKY;
    }

    public MONHOC getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(MONHOC monhoc) {
        this.monhoc = monhoc;
    }

    public int getNHOM() {
        return NHOM;
    }

    public void setNHOM(int nHOM) {
        NHOM = nHOM;
    }

    public GIANGVIEN getGiangvien() {
        return giangvien;
    }

    public void setGiangvien(GIANGVIEN giangvien) {
        this.giangvien = giangvien;
    }

    public KHOA getKhoa() {
        return khoa;
    }

    public void setKhoa(KHOA khoa) {
        this.khoa = khoa;
    }

    public int getSOSVTOITHIEU() {
        return SOSVTOITHIEU;
    }

    public void setSOSVTOITHIEU(int sOSVTOITHIEU) {
        SOSVTOITHIEU = sOSVTOITHIEU;
    }

    public boolean isHUYLOP() {
        return HUYLOP;
    }

    public void setHUYLOP(boolean hUYLOP) {
        HUYLOP = hUYLOP;
    }
}
