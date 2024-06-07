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
@Table(name = "SINHVIEN")
public class SINHVIEN {
    @Id
    private String MASV;
    private String HO;
    private String TEN;
    private boolean PHAI;
    private String DIACHI;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NGAYSINH;
    @ManyToOne
    @JoinColumn(name = "MALOP")
    private LOP lop;
    private boolean DANGHIHOC;
    private String PASSWORD;
    private String EMAIL;
    private String LINKANH;

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public String getHO() {
        return HO;
    }

    public void setHO(String HO) {
        this.HO = HO;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public boolean isPHAI() {
        return PHAI;
    }

    public void setPHAI(boolean PHAI) {
        this.PHAI = PHAI;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public Date getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(Date NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public LOP getLop() {
        return lop;
    }

    public void setLop(LOP lop) {
        this.lop = lop;
    }

    public boolean isDANGHIHOC() {
        return DANGHIHOC;
    }

    public void setDANGHIHOC(boolean DANGHIHOC) {
        this.DANGHIHOC = DANGHIHOC;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getLINKANH() {
        return LINKANH;
    }

    public void setLINKANH(String LINKANH) {
        this.LINKANH = LINKANH;
    }
}
