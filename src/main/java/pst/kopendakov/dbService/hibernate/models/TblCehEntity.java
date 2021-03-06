package pst.kopendakov.dbService.hibernate.models;

import pst.kopendakov.servlets.model.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tblCeh")
public class TblCehEntity extends Model{

    @Id
//    @GeneratedValue
    @Column(name = "idCeh", nullable = false)
    private long idCeh;

    @Column(name = "CehName", nullable = false, length = 20)
    private String cehName;

    public long getIdCeh() {
        return idCeh;
    }

    public void setIdCeh(long idCeh) {
        this.idCeh = idCeh;
    }

    public String getCehName() {
        return cehName;
    }

    public void setCehName(String cehName) {
        this.cehName = cehName;
    }


    @OneToMany(mappedBy = "tblCehEntity", cascade = CascadeType.ALL)
    private Set<TblUserEntity> tblUserEntities;

    public Set<TblUserEntity> getTblUserEntities() {
        return tblUserEntities;
    }

    public void setTblUserEntities(Set<TblUserEntity> tblUserEntities) {
        this.tblUserEntities = tblUserEntities;
    }

    @OneToMany(mappedBy = "tblCehEntity", cascade = CascadeType.ALL)
    private Set<TblOneRecordEntity> tblOneRecordEntities;

    public Set<TblOneRecordEntity> getTblOneRecordEntities() {
        return tblOneRecordEntities;
    }

    public void setTblOneRecordEntities(Set<TblOneRecordEntity> tblOneRecordEntities) {
        this.tblOneRecordEntities= tblOneRecordEntities;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        TblCehEntity that = (TblCehEntity) o;
//
//        if (idCeh != that.idCeh) return false;
//        if (cehName != null ? !cehName.equals(that.cehName) : that.cehName != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = idCeh;
//        result = 31 * result + (cehName != null ? cehName.hashCode() : 0);
//        return result;
//    }
}
