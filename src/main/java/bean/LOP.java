package bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOP")
public class LOP {
    @Id
    private String MALOP;
    private String TENLOP;
    private String KHOAHOC;
    private String MAKHOA;

    @OneToMany(mappedBy = "lop")
    private List<SINHVIEN> sinhviens;

    public String getMALOP() {
        return MALOP;
    }

    public String getTENLOP() {
        return TENLOP;
    }

    public String getKHOAHOC() {
        return KHOAHOC;
    }

    public String getMAKHOA() {
        return MAKHOA;
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

    public void setMAKHOA(String mAKHOA) {
        MAKHOA = mAKHOA;
    }

    public List<SINHVIEN> getSinhviens() {
        return sinhviens;
    }

    public void setSinhviens(List<SINHVIEN> sinhviens) {
        this.sinhviens = sinhviens;
    }
}
