package bean;



public class DisplayMONHOCObject {
    private String MAMH;
    private String TENMH;
    private int SOTIET_LT;
    private int SOTIET_TH;
    private int SOTINCHI;

    public DisplayMONHOCObject() {
        this.MAMH = "";
        this.TENMH = "";
        this.SOTIET_LT = 0;
        this.SOTIET_TH = 0;
        this.SOTINCHI = 0;
    }

    public DisplayMONHOCObject(String MAMH, String TENMH, int SOTIET_LT, int SOTIET_TH, int SOTINCHI) {
        this.MAMH = MAMH;
        this.TENMH = TENMH;
        this.SOTIET_LT = SOTIET_LT;
        this.SOTIET_TH = SOTIET_TH;
        this.SOTINCHI = SOTINCHI;
    }

    public String getMAMH() {
        return MAMH;
    }

    public void setMAMH(String mAMH) {
        this.MAMH = mAMH;
    }

    public String getTENMH() {
        return TENMH;
    }

    public void setTENMH(String tENMH) {
        this.TENMH = tENMH;
    }

    public int getSOTIET_LT() {
        return SOTIET_LT;
    }

    public void setSOTIET_LT(int SOTIET_LT) {
        this.SOTIET_LT = SOTIET_LT;
    }

    public int getSOTIET_TH() {
        return SOTIET_TH;
    }

    public void setSOTIET_TH(int SOTIET_TH) {
        this.SOTIET_TH = SOTIET_TH;
    }

    public int getSOTINCHI() {
        return SOTINCHI;
    }

    public void setSOTINCHI(int SOTINCHI) {
        this.SOTINCHI = SOTINCHI;
    }
}
