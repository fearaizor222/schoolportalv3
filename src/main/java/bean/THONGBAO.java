package bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "THONGBAO")
public class THONGBAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int MATB;
    private String TIEUDE;
    private String NOIDUNG;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NGAYDANG;

    public int getMATB() {
        return MATB;
    }

    public void setMATB(int MATB) {
        this.MATB = MATB;
    }

    public String getTIEUDE() {
        return TIEUDE;
    }

    public void setTIEUDE(String TIEUDE) {
        this.TIEUDE = TIEUDE;
    }

    public String getNOIDUNG() {
        return NOIDUNG;
    }

    public void setNOIDUNG(String NOIDUNG) {
        this.NOIDUNG = NOIDUNG;
    }

    public Date getNGAYDANG() {
        return NGAYDANG;
    }

    public void setNGAYDANG(Date NGAYDANG) {
        this.NGAYDANG = NGAYDANG;
    }
}
