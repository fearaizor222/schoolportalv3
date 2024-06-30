package bean;

import java.sql.Date;

public class DisplayHPObject {
    private String MASV;
    private String NIENKHOA;
    private int HOCKY;
    private int HOCPHI;
    private int PAID;
    private Date NGAYDONG;

    public DisplayHPObject() {
    }

    public DisplayHPObject(String MASV, String NIENKHOA, int HOCKY, int HOCPHI, int PAID, Date NGAYDONG) {
        this.MASV = MASV;
        this.NIENKHOA = NIENKHOA;
        this.HOCKY = HOCKY;
        this.HOCPHI = HOCPHI;
        this.PAID = PAID;
        this.NGAYDONG = NGAYDONG;
    }

    public Date getNGAYDONG() {
        return NGAYDONG;
    }

    public void setNGAYDONG(Date NGAYDONG) {
        this.NGAYDONG = NGAYDONG;
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public String getNIENKHOA() {
        return NIENKHOA;
    }

    public void setNIENKHOA(String NIENKHOA) {
        this.NIENKHOA = NIENKHOA;
    }

    public int getHOCKY() {
        return HOCKY;
    }

    public void setHOCKY(int HOCKY) {
        this.HOCKY = HOCKY;
    }

    public int getHOCPHI() {
        return HOCPHI;
    }

    public void setHOCPHI(int HOCPHI) {
        this.HOCPHI = HOCPHI;
    }

    public int getPAID() {
        return PAID;
    }

    public void setPAID(int PAID) {
        this.PAID = PAID;
    }
}
