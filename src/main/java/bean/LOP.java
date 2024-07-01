package bean;

public class LOP {
    private String MALOP;
    private String TENLOP;
    private String KHOAHOC;
    private String MAKHOA;
    private String TENKHOA;

    public LOP() {
        this.MALOP = "";
        this.TENLOP = "";
        this.KHOAHOC = "";
        this.MAKHOA = "";
        this.TENKHOA = "";
    }

    public LOP(String MALOP, String TENLOP, String KHOAHOC, String MAKHOA, String TENKHOA) {
        this.MALOP = MALOP;
        this.TENLOP = TENLOP;
        this.KHOAHOC = KHOAHOC;
        this.MAKHOA = MAKHOA;
        this.TENKHOA = TENKHOA;
    }

    public String getMALOP() {
        return MALOP;
    }

    public String getTENLOP() {
        return TENLOP;
    }

    public String getKHOAHOC() {
        return KHOAHOC;
    }

    public void setMALOP(String mALOP) {
        MALOP = mALOP;
    }

    public void setTENLOP(String tENLOP) {
        TENLOP = tENLOP;
    }

    public void setKHOAHOC(String kHOAHOC) {
        KHOAHOC = kHOAHOC;
    }

    public String getMAKHOA() {
        return MAKHOA;
    }

    public void setMAKHOA(String mAKHOA) {
        MAKHOA = mAKHOA;
    }

    public String getTENKHOA() {
        return TENKHOA;
    }

    public void setTENKHOA(String tENKHOA) {
        TENKHOA = tENKHOA;
    }
}
