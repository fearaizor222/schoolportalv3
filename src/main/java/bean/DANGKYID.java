package bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DANGKYID implements Serializable {
    private String MALTC;

    private String MASV;

    public String getMALTC() {
        return MALTC;
    }

    public void setMALTC(String mALTC) {
        MALTC = mALTC;
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String mASV) {
        MASV = mASV;
    }
}
