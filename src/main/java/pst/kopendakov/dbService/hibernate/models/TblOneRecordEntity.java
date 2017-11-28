package pst.kopendakov.dbService.hibernate.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "tblOneRecord", schema = "nariad", catalog = "")
public class TblOneRecordEntity {


    @Id
    @GeneratedValue
    @Column(name = "IdOneRecord", nullable = false)
    private int idOneRecord;

    @Column(name = "DateRec", nullable = false)
    private Date dateRec;

    @Column(name = "Nariad", nullable = false)
    private int nariad;

    @Column(name = "Raspor", nullable = false)
    private int raspor;

    @Column(name = "Count", nullable = false)
    private int count;

    @Column(name = "PodrForm", nullable = false)
    private int podrForm;

    @Column(name = "PodrCount", nullable = false)
    private int podrCount;

    public int getIdOneRecord() {
        return idOneRecord;
    }

    public void setIdOneRecord(int idOneRecord) {
        this.idOneRecord = idOneRecord;
    }

    public Date getDateRec() {
        return dateRec;
    }

    public void setDateRec(Date dateRec) {
        this.dateRec = dateRec;
    }

    public int getNariad() {
        return nariad;
    }

    public void setNariad(int nariad) {
        this.nariad = nariad;
    }

    public int getRaspor() {
        return raspor;
    }

    public void setRaspor(int raspor) {
        this.raspor = raspor;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPodrForm() {
        return podrForm;
    }

    public void setPodrForm(int podrForm) {
        this.podrForm = podrForm;
    }

    public int getPodrCount() {
        return podrCount;
    }

    public void setPodrCount(int podrCount) {
        this.podrCount = podrCount;
    }


    @ManyToOne
    @JoinColumn(name = "idCeh")
    private TblCehEntity tblCehEntity;

    public TblCehEntity getTblCehEntity() { return tblCehEntity; }

    public void setTblCehEntity(TblCehEntity tblCehEntity){
        this.tblCehEntity = tblCehEntity;
    }



}
