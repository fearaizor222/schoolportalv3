package bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOP")
public class LOP {
    @Id
    private String MALOP;
    private String TENLOP;
    private String KHOAHOC;
    @ManyToOne
    @JoinColumn(name = "MAKHOA")
    private KHOA khoa;

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

    public void setMALOP(String mALOP) {
        MALOP = mALOP;
    }

    public void setTENLOP(String tENLOP) {
        TENLOP = tENLOP;
    }

    public void setKHOAHOC(String kHOAHOC) {
        KHOAHOC = kHOAHOC;
    }

    public List<SINHVIEN> getSinhviens() {
        return sinhviens;
    }

    public void setSinhviens(List<SINHVIEN> sinhviens) {
        this.sinhviens = sinhviens;
    }

    public KHOA getKhoa() {
        return khoa;
    }

    public void setKhoa(KHOA khoa) {
        this.khoa = khoa;
    }
}
