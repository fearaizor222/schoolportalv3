package bean;

import java.util.Date;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CT_DONGHOCPHI")
public class CT_DONGHOCPHI {
    @EmbeddedId
    private CT_DONGHOCPHIID ID;
    private int SOTIENDONG;

    public CT_DONGHOCPHIID getID() {
        return ID;
    }

    public void setID(CT_DONGHOCPHIID iD) {
        ID = iD;
    }

    public int getSOTIENDONG() {
        return SOTIENDONG;
    }

    public void setSOTIENDONG(int sOTIENDONG) {
        SOTIENDONG = sOTIENDONG;
    }

    @Embeddable
    public static class CT_DONGHOCPHIID implements Serializable{
        private String MASV;
        private String NIENKHOA;
        private int HOCKY;
        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date NGAYDONG;

        public String getMASV() {
            return MASV;
        }

        public void setMASV(String mASV) {
            MASV = mASV;
        }

        public String getNIENKHOA() {
            return NIENKHOA;
        }

        public void setNIENKHOA(String nIENKHOA) {
            NIENKHOA = nIENKHOA;
        }

        public int getHOCKY() {
            return HOCKY;
        }

        public void setHOCKY(int hOCKY) {
            HOCKY = hOCKY;
        }

        public Date getNGAYDONG() {
            return NGAYDONG;
        }

        public void setNGAYDONG(Date nGAYDONG) {
            NGAYDONG = nGAYDONG;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            CT_DONGHOCPHIID that = (CT_DONGHOCPHIID) o;
            return HOCKY == that.HOCKY &&
                    Objects.equals(MASV, that.MASV) &&
                    Objects.equals(NIENKHOA, that.NIENKHOA) &&
                    Objects.equals(NGAYDONG, that.NGAYDONG);
        }

        @Override
        public int hashCode() {
            return Objects.hash(MASV, NIENKHOA, HOCKY, NGAYDONG);
        }
    }
}
