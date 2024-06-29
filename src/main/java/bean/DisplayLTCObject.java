package bean;

public class DisplayLTCObject {
    private int MALTC;
    private String NIENKHOA;
    private int HOCKY;
    private String MAMH;
    private int NHOM;
    private String MAGV;
    private String MAKHOA;
    private int SOSVTOITHIEU;
    private boolean HUYLOP;
    private boolean DADANGKY;
    private int SOSVDANGKY;
    private String HOTENGV;
    private String TENMH;

    public DisplayLTCObject() {
        this.MALTC = 0;
        this.NIENKHOA = "";
        this.HOCKY = 0;
        this.MAMH = "";
        this.NHOM = 0;
        this.MAGV = "";
        this.MAKHOA = "";
        this.SOSVTOITHIEU = 0;
        this.HUYLOP = false;
        this.DADANGKY = false;
        this.SOSVDANGKY = 0;
        this.HOTENGV = "";
        this.TENMH = "";
    }

    public DisplayLTCObject(int MALTC, String NIENKHOA, int HOCKY, String MAMH, int NHOM, String MAGV, String MAKHOA, int SOSVTOITHIEU, boolean HUYLOP, boolean DADANGKY, int SOSVDANGKY, String HOTENGV, String TENMH) {
        this.MALTC = MALTC;
        this.NIENKHOA = NIENKHOA;
        this.HOCKY = HOCKY;
        this.MAMH = MAMH;
        this.NHOM = NHOM;
        this.MAGV = MAGV;
        this.MAKHOA = MAKHOA;
        this.SOSVTOITHIEU = SOSVTOITHIEU;
        this.HUYLOP = HUYLOP;
        this.DADANGKY = DADANGKY;
        this.SOSVDANGKY = SOSVDANGKY;
        this.HOTENGV = HOTENGV;
        this.TENMH = TENMH;
    }

    public int getSOSVDANGKY() {
        return SOSVDANGKY;
    }

    public void setSOSVDANGKY(int sOSVDANGKY) {
        SOSVDANGKY = sOSVDANGKY;
    }

    public String getHOTENGV() {
        return HOTENGV;
    }

    public void setHOTENGV(String hOTENGV) {
        HOTENGV = hOTENGV;
    }

    public String getTENMH() {
        return TENMH;
    }

    public void setTENMH(String tENMH) {
        TENMH = tENMH;
    }

    public boolean isDADANGKY() {
        return DADANGKY;
    }

    public void setDADANGKY(boolean dADANGKY) {
        DADANGKY = dADANGKY;
    }

    public String getMAMH() {
        return MAMH;
    }

    public void setMAMH(String mAMH) {
        MAMH = mAMH;
    }

    public String getMAGV() {
        return MAGV;
    }

    public void setMAGV(String mAGV) {
        MAGV = mAGV;
    }

    public String getMAKHOA() {
        return MAKHOA;
    }

    public void setMAKHOA(String mAKHOA) {
        MAKHOA = mAKHOA;
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

    public int getNHOM() {
        return NHOM;
    }

    public void setNHOM(int nHOM) {
        NHOM = nHOM;
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
