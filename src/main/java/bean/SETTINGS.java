package bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SETTINGS {
    @Id
    private int MASETTINGS;
    private int HOCKY;
    private String NIENKHOA;
    private boolean DANGKYMON;

    public int getMASETTINGS() {
        return MASETTINGS;
    }

    public void setMASETTINGS(int mASETTINGS) {
        MASETTINGS = mASETTINGS;
    }

    public int getHOCKY() {
        return HOCKY;
    }

    public void setHOCKY(int hOCKY) {
        HOCKY = hOCKY;
    }

    public String getNIENKHOA() {
        return NIENKHOA;
    }

    public void setNIENKHOA(String nIENKHOA) {
        NIENKHOA = nIENKHOA;
    }

    public boolean getDANGKYMON() {
        return DANGKYMON;
    }

    public void setDANGKYMON(boolean dANGKYMON) {
        DANGKYMON = dANGKYMON;
    }
}
