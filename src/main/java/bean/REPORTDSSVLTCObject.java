package bean;

public class REPORTDSSVLTCObject {
    private String MASV;
    private String HO;
    private String TEN;
    private boolean PHAI;
    private String MALOP;

    public REPORTDSSVLTCObject() {
    }

    public REPORTDSSVLTCObject(String MASV, String HO, String TEN, boolean PHAI, String MALOP) {
        this.MASV = MASV;
        this.HO = HO;
        this.TEN = TEN;
        this.PHAI = PHAI;
        this.MALOP = MALOP;
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public String getHO() {
        return HO;
    }

    public void setHO(String HO) {
        this.HO = HO;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public boolean isPHAI() {
        return PHAI;
    }

    public void setPHAI(boolean PHAI) {
        this.PHAI = PHAI;
    }

    public String getMALOP() {
        return MALOP;
    }

    public void setMALOP(String MALOP) {
        this.MALOP = MALOP;
    }

}
