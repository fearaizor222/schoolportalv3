package bean;

public class KHOA {
    private String MAKHOA;
    private String TENKHOA;

    public KHOA() {
    }

    public KHOA(String MAKHOA, String TENKHOA) {
        this.MAKHOA = MAKHOA;
        this.TENKHOA = TENKHOA;
    }

    public String getMAKHOA() {
        return MAKHOA;
    }

    public void setMAKHOA(String MAKHOA) {
        this.MAKHOA = MAKHOA;
    }

    public String getTENKHOA() {
        return TENKHOA;
    }

    public void setTENKHOA(String TENKHOA) {
        this.TENKHOA = TENKHOA;
    }
}
