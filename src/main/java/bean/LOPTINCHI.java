package bean;

public class LOPTINCHI {
    private int MALTC;
    private String NIENKHOA;
    private int HOCKY;
    private String MAMH;
    private int NHOM;
    private String MAGV;
    private String MAKHOA;
    private int SOSVTOITHIEU;
    private boolean HUYLOP;

    public LOPTINCHI() {
        this.MALTC = 0;
        this.NIENKHOA = "";
        this.HOCKY = 0;
        this.MAMH = "";
        this.NHOM = 0;
        this.MAGV = "";
        this.MAKHOA = "";
        this.SOSVTOITHIEU = 0;
        this.HUYLOP = false;
    }

    public LOPTINCHI(int MALTC, String NIENKHOA, int HOCKY, String MAMH, int NHOM, String MAGV, String MAKHOA,
            int SOSVTOITHIEU, boolean HUYLOP) {
        this.MALTC = MALTC;
        this.NIENKHOA = NIENKHOA;
        this.HOCKY = HOCKY;
        this.MAMH = MAMH;
        this.NHOM = NHOM;
        this.MAGV = MAGV;
        this.MAKHOA = MAKHOA;
        this.SOSVTOITHIEU = SOSVTOITHIEU;
        this.HUYLOP = HUYLOP;
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

    public String getMAMH() {
        return MAMH;
    }

    public void setMAMH(String mAMH) {
        MAMH = mAMH;
    }

    public int getNHOM() {
        return NHOM;
    }

    public void setNHOM(int nHOM) {
        NHOM = nHOM;
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
