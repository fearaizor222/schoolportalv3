package bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "HOCPHI")
@IdClass(HOCPHI.HocPhiId.class)
public class HOCPHI {

    @Id
    private String MASV;

    @Id
    private String NIENKHOA;

    @Id
    private int HOCKY;

    private int HOCPHI;

    // Getters and setters

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public String getNIENKHOA() {
        return NIENKHOA;
    }

    public void setNIENKHOA(String NIENKHOA) {
        this.NIENKHOA = NIENKHOA;
    }

    public int getHOCKY() {
        return HOCKY;
    }

    public void setHOCKY(int HOCKY) {
        this.HOCKY = HOCKY;
    }

    public int getHOCPHI() {
        return HOCPHI;
    }

    public void setHOCPHI(int HOCPHI) {
        this.HOCPHI = HOCPHI;
    }

    // Composite key class
    public static class HocPhiId implements Serializable {
        private String MASV;
        private String NIENKHOA;
        private int HOCKY;

        // Getters, setters and equals, hashCode methods
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HocPhiId hocPhiId = (HocPhiId) o;
            return HOCKY == hocPhiId.HOCKY && Objects.equals(MASV, hocPhiId.MASV) && Objects.equals(NIENKHOA, hocPhiId.NIENKHOA);
        }

        @Override
        public int hashCode() {
            return Objects.hash(MASV, NIENKHOA, HOCKY);
        }
    }
}