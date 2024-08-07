package bean;

public class DANGKYObjectWithName {
    private int MALTC;
    private String MASV;
    private int DIEM_CC;
    private float DIEM_GK;
    private float DIEM_CK;
    private boolean HUYDANGKY;
    private String HOTEN;
    private String MAKHOA;

    public DANGKYObjectWithName() {
        this.MALTC = 0;
        this.MASV = "";
        this.DIEM_CC = 0;
        this.DIEM_GK = 0;
        this.DIEM_CK = 0;
        this.HUYDANGKY = false;
        this.HOTEN = "";
        this.MAKHOA = "";
    }

    public DANGKYObjectWithName(int MALTC, String MASV, int DIEM_CC, float DIEM_GK, float DIEM_CK, boolean HUYDANGKY, String HOTEN, String MAKHOA) {
        this.MALTC = MALTC;
        this.MASV = MASV;
        this.DIEM_CC = DIEM_CC;
        this.DIEM_GK = DIEM_GK;
        this.DIEM_CK = DIEM_CK;
        this.HUYDANGKY = HUYDANGKY;
        this.HOTEN = HOTEN;
        this.MAKHOA = MAKHOA;
    }

    public int getMALTC() {
        return MALTC;
    }

    public void setMALTC(int mALTC) {
        MALTC = mALTC;
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String mASV) {
        MASV = mASV;
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

    public boolean isHUYDANGKY() {
        return HUYDANGKY;
    }

    public void setHUYDANGKY(boolean hUYDANGKY) {
        HUYDANGKY = hUYDANGKY;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public void setHOTEN(String hOTEN) {
        HOTEN = hOTEN;
    }

    public String getMAKHOA() {
        return MAKHOA;
    }

    public void setMAKHOA(String mAKHOA) {
        MAKHOA = mAKHOA;
    }
}
