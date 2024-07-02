package bean;

public class REPORTHOCPHI {
    private String HOTEN;
    private int HOCPHI;
    private int SOTIENDADONG;

    public REPORTHOCPHI() {
    }

    public REPORTHOCPHI(String HOTEN, int HOCPHI, int SOTIENDADONG) {
        this.HOTEN = HOTEN;
        this.HOCPHI = HOCPHI;
        this.SOTIENDADONG = SOTIENDADONG;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public void setHOTEN(String HOTEN) {
        this.HOTEN = HOTEN;
    }

    public int getHOCPHI() {
        return HOCPHI;
    }

    public void setHOCPHI(int HOCPHI) {
        this.HOCPHI = HOCPHI;
    }

    public int getSOTIENDADONG() {
        return SOTIENDADONG;
    }

    public void setSOTIENDADONG(int SOTIENDADONG) {
        this.SOTIENDADONG = SOTIENDADONG;
    }
}
