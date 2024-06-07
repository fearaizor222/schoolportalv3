package bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "LICH")
public class LICH {
    @Id
    @GeneratedValue
    private int MALICH;
    
    @ManyToOne
    @JoinColumn(name = "MALTC")
    private LOPTINCHI loptinchi;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NGAYHOC;

    private int TIETBD;
    private int SOTIET;
    private Boolean LOAILICH;
    private int PHONG;

    public int getMALICH() {
        return MALICH;
    }

    public void setMALICH(int mALICH) {
        MALICH = mALICH;
    }

    public LOPTINCHI getLoptinchi() {
        return loptinchi;
    }

    public void setLoptinchi(LOPTINCHI loptinchi) {
        this.loptinchi = loptinchi;
    }

    public Date getNGAYHOC() {
        return NGAYHOC;
    }

    public void setNGAYHOC(Date nGAYHOC) {
        NGAYHOC = nGAYHOC;
    }

    public int getTIETBD() {
        return TIETBD;
    }

    public void setTIETBD(int tIETBD) {
        TIETBD = tIETBD;
    }

    public int getSOTIET() {
        return SOTIET;
    }

    public void setSOTIET(int sOTIET) {
        SOTIET = sOTIET;
    }

    public Boolean getLOAILICH() {
        return LOAILICH;
    }

    public void setLOAILICH(Boolean lOAILICH) {
        LOAILICH = lOAILICH;
    }

    public int getPHONG() {
        return PHONG;
    }

    public void setPHONG(int pHONG) {
        PHONG = pHONG;
    }
}
