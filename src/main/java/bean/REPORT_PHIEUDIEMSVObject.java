package bean;

public class REPORT_PHIEUDIEMSVObject {
    private String TENMH;
    private int DIEMKT;

    public REPORT_PHIEUDIEMSVObject() {

    }

    public REPORT_PHIEUDIEMSVObject(String tENMH, int dIEMKT) {
        TENMH = tENMH;
        DIEMKT = dIEMKT;
    }

    public String getTENMH() {
        return TENMH;
    }

    public void setTENMH(String tENMH) {
        TENMH = tENMH;
    }

    public int getDIEMKT() {
        return DIEMKT;
    }

    public void setDIEMKT(int dIEMKT) {
        DIEMKT = dIEMKT;
    }

}