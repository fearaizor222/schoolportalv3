package bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "KHOA")
public class KHOA {
    @Id
    private String MAKHOA;
    private String TENKHOA;

    @OneToMany(mappedBy = "khoa")
    private List<LOP> lops;

    @OneToMany(mappedBy = "khoa")
    private List<GIANGVIEN> giangviens;

    @OneToMany(mappedBy = "khoa")
    private List<LOPTINCHI> loptinchis;

    public List<LOPTINCHI> getLoptinchis() {
        return loptinchis;
    }

    public void setLoptinchis(List<LOPTINCHI> loptinchis) {
        this.loptinchis = loptinchis;
    }

    public List<GIANGVIEN> getGiangviens() {
        return giangviens;
    }

    public void setGiangviens(List<GIANGVIEN> giangviens) {
        this.giangviens = giangviens;
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

    public List<LOP> getLops() {
        return lops;
    }

    public void setLops(List<LOP> lops) {
        this.lops = lops;
    }
}
