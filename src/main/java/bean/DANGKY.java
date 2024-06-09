package bean;

import java.io.Serializable;

import javax.persistence.Embeddable;
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

    @Embeddable
    public static class DANGKYID implements Serializable {
        private int MALTC;
        private String MASV;

        public DANGKYID(){
            
        }

        public DANGKYID(int maltc, String masv){
            setMALTC(maltc);
            setMASV(masv);
        }

        public int getMALTC() {
            return MALTC;
        }

        public void setMALTC(int maltc2) {
            MALTC = maltc2;
        }

        public String getMASV() {
            return MASV;
        }

        public void setMASV(String mASV) {
            MASV = mASV;
        }
    }
}
