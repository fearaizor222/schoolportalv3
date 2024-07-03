package bean;

public class REPORT_BANGDIEMObject {
    private String MASV;
    private String HO;
    private String TEN;
    private int DIEM_CC;
    private float DIEM_GK;
    private float DIEM_CK;
    private float DIEMKT;

    public REPORT_BANGDIEMObject() {
    }

    public REPORT_BANGDIEMObject(String mASV, String hO, String tEN, int dIEM_CC, float dIEM_GK, float dIEM_CK,
            float dIEMKT) {
        MASV = mASV;
        HO = hO;
        TEN = tEN;
        DIEM_CC = dIEM_CC;
        DIEM_GK = dIEM_GK;
        DIEM_CK = dIEM_CK;
        DIEMKT = dIEMKT;
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String mASV) {
        MASV = mASV;
    }

    public String getHO() {
        return HO;
    }

    public void setHO(String hO) {
        HO = hO;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String tEN) {
        TEN = tEN;
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

    public float getDIEMKT() {
        return DIEMKT;
    }

    public void setDIEMKT(float dIEMKT) {
        DIEMKT = dIEMKT;
    }

}
