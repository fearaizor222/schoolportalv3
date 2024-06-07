package bean;

import java.util.Date;

import javax.persistence.Entity;
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
    private int MALICH;
    private int MALTC;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NGAYHOC;
    private int TIETBD;
    private int SOTIET;
    private boolean LOAILICH;

    @ManyToOne
    @JoinColumn(name = "MALTC", insertable = false, updatable = false)
    private LOPTINCHI LOPTINCHI;

    public int getMALICH() {
        return MALICH;
    }

    public void setMALICH(int mALICH) {
        MALICH = mALICH;
    }

    public int getMALTC() {
        return MALTC;
    }

    public void setMALTC(int mALTC) {
        MALTC = mALTC;
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

    public boolean isLOAILICH() {
        return LOAILICH;
    }

    public void setLOAILICH(boolean lOAILICH) {
        LOAILICH = lOAILICH;
    }
}
