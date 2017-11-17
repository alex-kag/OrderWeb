package pst.kopendakov.dbService.hibernate.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tblCeh", schema = "nariad", catalog = "")
public class TblCehEntity {
    private int idCeh;
    private String cehName;

    @Basic
    @Column(name = "idCeh", nullable = false)
    public int getIdCeh() {
        return idCeh;
    }

    public void setIdCeh(int idCeh) {
        this.idCeh = idCeh;
    }

    @Basic
    @Column(name = "CehName", nullable = false, length = 20)
    public String getCehName() {
        return cehName;
    }

    public void setCehName(String cehName) {
        this.cehName = cehName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblCehEntity that = (TblCehEntity) o;

        if (idCeh != that.idCeh) return false;
        if (cehName != null ? !cehName.equals(that.cehName) : that.cehName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCeh;
        result = 31 * result + (cehName != null ? cehName.hashCode() : 0);
        return result;
    }
}
