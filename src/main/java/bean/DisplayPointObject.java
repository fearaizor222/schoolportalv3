package bean;

public class DisplayPointObject {
    private String HOTEN;
    private String MAMH;
    private String TENMH;
    private String NIENKHOA;
    private int HOCKY;
    private int NHOM;
    private int SOTINCHI;
    private int DIEM_CC;
    private float DIEM_GK;
    private float DIEM_CK;

    public DisplayPointObject() {
        this.HOTEN = "";
        this.MAMH = "";
        this.TENMH = "";
        this.NIENKHOA = "";
        this.HOCKY = 0;
        this.NHOM = 0;
        this.SOTINCHI = 0;
        this.DIEM_CC = 0;
        this.DIEM_GK = 0;
        this.DIEM_CK = 0;
    }

    public DisplayPointObject(String HOTEN, String MAMH, String TENMH, String NIENKHOA, int HOCKY, int NHOM, int SOTINCHI,
            int DIEM_CC, float DIEM_GK, float DIEM_CK) {
        this.HOTEN = HOTEN;
        this.MAMH = MAMH;
        this.TENMH = TENMH;
        this.NIENKHOA = NIENKHOA;
        this.HOCKY = HOCKY;
        this.NHOM = NHOM;
        this.SOTINCHI = SOTINCHI;
        this.DIEM_CC = DIEM_CC;
        this.DIEM_GK = DIEM_GK;
        this.DIEM_CK = DIEM_CK;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public String getMAMH() {
        return MAMH;
    }

    public String getTENMH() {
        return TENMH;
    }

    public String getNIENKHOA() {
        return NIENKHOA;
    }

    public int getHOCKY() {
        return HOCKY;
    }

    public int getNHOM() {
        return NHOM;
    }

    public int getSOTINCHI() {
        return SOTINCHI;
    }

    public int getDIEM_CC() {
        return DIEM_CC;
    }

    public float getDIEM_GK() {
        return DIEM_GK;
    }

    public float getDIEM_CK() {
        return DIEM_CK;
    }

    public void setHOTEN(String hOTEN) {
        HOTEN = hOTEN;
    }

    public void setMAMH(String mAMH) {
        MAMH = mAMH;
    }   

    public void setTENMH(String tENMH) {
        TENMH = tENMH;
    }

    public void setNIENKHOA(String nIENKHOA) {
        NIENKHOA = nIENKHOA;
    }

    public void setHOCKY(int hOCKY) {
        HOCKY = hOCKY;
    }

    public void setNHOM(int nHOM) {
        NHOM = nHOM;
    }

    public void setSOTINCHI(int sOTINCHI) {
        SOTINCHI = sOTINCHI;
    }

    public void setDIEM_CC(int dIEM_CC) {
        DIEM_CC = dIEM_CC;
    }

    public void setDIEM_GK(float dIEM_GK) {
        DIEM_GK = dIEM_GK;
    }

    public void setDIEM_CK(float dIEM_CK) {
        DIEM_CK = dIEM_CK;
    }
}
