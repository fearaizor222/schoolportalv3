package bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "DANGKY")
public class DANGKY {
    @EmbeddedId
    private DANGKYID ID;
    private int DIEM_CC;
    private float DIEM_GK;
    private float DIEM_CK;
    private boolean HUYDANGKY;

    @MapsId("MALTC")
    @ManyToOne
    @JoinColumn(name = "MALTC")
    private LOPTINCHI loptinchi;

    @MapsId("MASV")
    @ManyToOne
    @JoinColumn(name = "MASV")
    private SINHVIEN sinhvien;

    public DANGKYID getID() {
        return ID;
    }

    public void setID(DANGKYID iD) {
        ID = iD;
    }

    public int getDIEM_CC() {
        return DIEM_CC;
    }

    public void setDIEM_CC(int dIEM_CC) {
        DIEM_CC = dIEM_CC;
    }

    public float getDIEM_GK() {
        return DIEM_GK;
    }

    public void setDIEM_GK(float dIEM_GK) {
        DIEM_GK = dIEM_GK;
    }

    public float getDIEM_CK() {
        return DIEM_CK;
    }

    public void setDIEM_CK(float dIEM_CK) {
        DIEM_CK = dIEM_CK;
    }

    public LOPTINCHI getLoptinchi() {
        return loptinchi;
    }

    public void setLoptinchi(LOPTINCHI loptinchi) {
        this.loptinchi = loptinchi;
    }

    public SINHVIEN getSinhVien() {
        return sinhvien;
    }

    public void setSinhVien(SINHVIEN sinhVien) {
        this.sinhvien = sinhVien;
    }

    public boolean getHUYDANGKY() {
        return HUYDANGKY;
    }

    public void setHUYDANGKY(boolean hUYDANGKY) {
        HUYDANGKY = hUYDANGKY;
    }
}