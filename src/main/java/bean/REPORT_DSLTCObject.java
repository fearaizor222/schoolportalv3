package bean;

public class REPORT_DSLTCObject {
    private String MONHOC;
    private int NHOM;
    private String GIANGVIEN;
    private int SOSVTOITHIEU;
    private int SVDANGKY;

    public REPORT_DSLTCObject() {
    }

    public REPORT_DSLTCObject(String MONHOC, int NHOM, String GIANGVIEN, int SOSVTOITHIEU, int SVDANGKY) {
        this.MONHOC = MONHOC;
        this.NHOM = NHOM;
        this.GIANGVIEN = GIANGVIEN;
        this.SOSVTOITHIEU = SOSVTOITHIEU;
        this.SVDANGKY = SVDANGKY;
    }

    public String getMONHOC() {
        return MONHOC;
    }

    public void setMONHOC(String MONHOC) {
        this.MONHOC = MONHOC;
    }

    public int getNHOM() {
        return NHOM;
    }

    public void setNHOM(int NHOM) {
        this.NHOM = NHOM;
    }

    public String getGIANGVIEN() {
        return GIANGVIEN;
    }

    public void setGIANGVIEN(String GIANGVIEN) {
        this.GIANGVIEN = GIANGVIEN;
    }

    public int getSOSVTOITHIEU() {
        return SOSVTOITHIEU;
    }

    public void setSOSVTOITHIEU(int SOSVTOITHIEU) {
        this.SOSVTOITHIEU = SOSVTOITHIEU;
    }

    public int getSVDANGKY() {
        return SVDANGKY;
    }

    public void setSVDANGKY(int SVDANGKY) {
        this.SVDANGKY = SVDANGKY;
    }
}
