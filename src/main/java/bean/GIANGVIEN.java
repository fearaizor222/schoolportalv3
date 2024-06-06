package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GIANGVIEN")
public class GIANGVIEN {
    @Id
    private String MAGV;
    private String MAKHOA;
    private String HO;
    private String TEN;
    private String HOCVI;
    private String HOCHAM;
    private String CHUYENMON;
    private String PASSWORD;

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