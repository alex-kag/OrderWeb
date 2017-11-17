package pst.kopendakov.dbService.hibernate.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tblOneRecord", schema = "nariad", catalog = "")
public class TblOneRecordEntity {
    private int idOneRecord;
    private int idCeh;
    private Date dateRec;
    private int nariad;
    private int raspor;
    private int count;
    private int podrForm;
    private int podrCount;

    @Id
    @Column(name = "IdOneRecord", nullable = false)
    public int getIdOneRecord() {
        return idOneRecord;
    }

    public void setIdOneRecord(int idOneRecord) {
        this.idOneRecord = idOneRecord;
    }

    @Basic
    @Column(name = "IdCeh", nullable = false)
    public int getIdCeh() {
        return idCeh;
    }

    public void setIdCeh(int idCeh) {
        this.idCeh = idCeh;
    }

    @Basic
    @Column(name = "DateRec", nullable = false)
    public Date getDateRec() {
        return dateRec;
    }

    public void setDateRec(Date dateRec) {
        this.dateRec = dateRec;
    }

    @Basic
    @Column(name = "Nariad", nullable = false)
    public int getNariad() {
        return nariad;
    }

    public void setNariad(int nariad) {
        this.nariad = nariad;
    }

    @Basic
    @Column(name = "Raspor", nullable = false)
    public int getRaspor() {
        return raspor;
    }

    public void setRaspor(int raspor) {
        this.raspor = raspor;
    }

    @Basic
    @Column(name = "Count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Basic
    @Column(name = "PodrForm", nullable = false)
    public int getPodrForm() {
        return podrForm;
    }

    public void setPodrForm(int podrForm) {
        this.podrForm = podrForm;
    }

    @Basic
    @Column(name = "PodrCount", nullable = false)
    public int getPodrCount() {
        return podrCount;
    }

    public void setPodrCount(int podrCount) {
        this.podrCount = podrCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblOneRecordEntity that = (TblOneRecordEntity) o;

        if (idOneRecord != that.idOneRecord) return false;
        if (idCeh != that.idCeh) return false;
        if (nariad != that.nariad) return false;
        if (raspor != that.raspor) return false;
        if (count != that.count) return false;
        if (podrForm != that.podrForm) return false;
        if (podrCount != that.podrCount) return false;
        if (dateRec != null ? !dateRec.equals(that.dateRec) : that.dateRec != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOneRecord;
        result = 31 * result + idCeh;
        result = 31 * result + (dateRec != null ? dateRec.hashCode() : 0);
        result = 31 * result + nariad;
        result = 31 * result + raspor;
        result = 31 * result + count;
        result = 31 * result + podrForm;
        result = 31 * result + podrCount;
        return result;
    }
}
