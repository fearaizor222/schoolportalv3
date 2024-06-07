package bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GIANGVIEN")
public class GIANGVIEN {
    @Id
    private String MAGV;
    @ManyToOne
    @JoinColumn(name = "MAKHOA")
    private KHOA khoa;
    private String HO;
    private String TEN;
    private String HOCVI;
    private String HOCHAM;
    private String CHUYENMON;
    private String PASSWORD;

    @OneToMany(mappedBy = "giangvien")
    private List<LOPTINCHI> loptinchis;

    public List<LOPTINCHI> getLoptinchis() {
        return loptinchis;
    }

    public void setLoptinchis(List<LOPTINCHI> loptinchis) {
        this.loptinchis = loptinchis;
    }

    public String getMAGV() {
        return MAGV;
    }

    public void setMAGV(String MAGV) {
        this.MAGV = MAGV;
    }

    public KHOA getKhoa() {
        return khoa;
    }

    public void setKhoa(KHOA khoa) {
        this.khoa = khoa;
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