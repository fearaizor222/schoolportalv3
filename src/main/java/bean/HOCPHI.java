package bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "HOCPHI")
public class HOCPHI {
    @EmbeddedId
    private HocPhiId hocPhiId;

    private int HOCPHI;

    @MapsId("MASV")
    @ManyToOne
    @JoinColumn(name = "MASV")
    private SINHVIEN sinhVien;

    // Getters and setters
    public SINHVIEN getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SINHVIEN sinhVien) {
        this.sinhVien = sinhVien;
    }

    public HocPhiId getHocPhiId() {
        return hocPhiId;
    }

    public void setHocPhiId(HocPhiId hocPhiId) {
        this.hocPhiId = hocPhiId;
    }

    public int getHOCPHI() {
        return HOCPHI;
    }

    public void setHOCPHI(int HOCPHI) {
        this.HOCPHI = HOCPHI;
    }

    // Composite key class
    @Embeddable
    public static class HocPhiId implements Serializable {
        private String MASV;
        private String NIENKHOA;
        private int HOCKY;

        public HocPhiId() {
            
        }

        public HocPhiId(String mASV2, String nienKhoa2, int hocKy2) {
            this.MASV = mASV2;
            this.NIENKHOA = nienKhoa2;
            this.HOCKY = hocKy2;
        }

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

    public void setHocPhiId(String username, String nienkhoa, int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHocPhiId'");
    }
}