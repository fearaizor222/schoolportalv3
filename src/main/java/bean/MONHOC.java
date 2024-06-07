package bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MONHOC")
public class MONHOC {
    @Id
    private String MAMH;
    private String TENMH;
    private int SOTIET_LT;
    private int SOTIET_TH;
    private int SOTINCHI;

    @OneToMany(mappedBy = "monhoc")
    private List<LOPTINCHI> lopTinChis;

    public List<LOPTINCHI> getLopTinChis() {
        return lopTinChis;
    }

    public void setLopTinChis(List<LOPTINCHI> lopTinChis) {
        this.lopTinChis = lopTinChis;
    }

    public String getMAMH() {
        return MAMH;
    }

    public void setMAMH(String MAMH) {
        this.MAMH = MAMH;
    }

    public String getTENMH() {
        return TENMH;
    }

    public void setTENMH(String TENMH) {
        this.TENMH = TENMH;
    }

    public int getSOTIET_LT() {
        return SOTIET_LT;
    }

    public void setSOTIET_LT(int SOTIET_LT) {
        this.SOTIET_LT = SOTIET_LT;
    }

    public int getSOTIET_TH() {
        return SOTIET_TH;
    }

    public void setSOTIET_TH(int SOTIET_TH) {
        this.SOTIET_TH = SOTIET_TH;
    }

    public int getSOTINCHI() {
        return SOTINCHI;
    }

    public void setSOTINCHI(int SOTINCHI) {
        this.SOTINCHI = SOTINCHI;
    }
}
