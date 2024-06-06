package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOP")
public class LOP {
    @Id
    private String MALOP;
    private String TENLOP;
    private String KHOAHOC;
    private String MAKHOA;

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
}
