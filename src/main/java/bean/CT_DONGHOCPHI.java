package bean;

import java.util.Date;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CT_DONGHOCPHI")
public class CT_DONGHOCPHI implements Serializable {
    @Id
    private String MASV;
    @Id
    private String NIENKHOA;
    @Id
    private int HOCKY;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Id
    private Date NGAYDONG;
    private int SOTIENDONG;

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

    public int getSOTIENDONG() {
        return SOTIENDONG;
    }

    public void setSOTIENDONG(int sOTIENDONG) {
        SOTIENDONG = sOTIENDONG;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CT_DONGHOCPHI that = (CT_DONGHOCPHI) o;
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
