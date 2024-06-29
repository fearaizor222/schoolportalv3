package bean;


public class GIANGVIEN {
    private String MAGV;
    private String MAKHOA;
    private String HO;
    private String TEN;
    private String HOCVI;
    private String HOCHAM;
    private String CHUYENMON;
    private String PASSWORD;

    public GIANGVIEN() {
        this.MAGV = "";
        this.MAKHOA = "";
        this.HO = "";
        this.TEN = "";
        this.HOCVI = "";
        this.HOCHAM = "";
        this.CHUYENMON = "";
        this.PASSWORD = "";
    }

    public GIANGVIEN(String MAGV, String MAKHOA, String HO, String TEN, String HOCVI, String HOCHAM, String CHUYENMON, String PASSWORD) {
        this.MAGV = MAGV;
        this.MAKHOA = MAKHOA;
        this.HO = HO;
        this.TEN = TEN;
        this.HOCVI = HOCVI;
        this.HOCHAM = HOCHAM;
        this.CHUYENMON = CHUYENMON;
        this.PASSWORD = PASSWORD;
    }

    public String getMAGV() {
        return MAGV;
    }

    public void setMAGV(String MAGV) {
        this.MAGV = MAGV;
    }

    public String getMAKHOA() {
        return MAKHOA;
    }

    public void setMAKHOA(String MAKHOA) {
        this.MAKHOA = MAKHOA;
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

    public String getHOCVI() {
        return HOCVI;
    }

    public void setHOCVI(String HOCVI) {
        this.HOCVI = HOCVI;
    }

    public String getHOCHAM() {
        return HOCHAM;
    }

    public void setHOCHAM(String HOCHAM) {
        this.HOCHAM = HOCHAM;
    }

    public String getCHUYENMON() {
        return CHUYENMON;
    }

    public void setCHUYENMON(String CHUYENMON) {
        this.CHUYENMON = CHUYENMON;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}