package pst.kopendakov.dbService.hibernate.models;

import javax.persistence.*;

@Entity
@Table(name = "tblUser", schema = "nariad", catalog = "")
public class TblUserEntity {
    private int id;
    private String login;
    private String pass;
    private String soll;
    private Integer idCeh;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 20)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "pass", nullable = false, length = 50)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "soll", nullable = false, length = 50)
    public String getSoll() {
        return soll;
    }

    public void setSoll(String soll) {
        this.soll = soll;
    }

    @Basic
    @Column(name = "idCeh", nullable = true)
    public Integer getIdCeh() {
        return idCeh;
    }

    public void setIdCeh(Integer idCeh) {
        this.idCeh = idCeh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblUserEntity that = (TblUserEntity) o;

        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (pass != null ? !pass.equals(that.pass) : that.pass != null) return false;
        if (soll != null ? !soll.equals(that.soll) : that.soll != null) return false;
        if (idCeh != null ? !idCeh.equals(that.idCeh) : that.idCeh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (soll != null ? soll.hashCode() : 0);
        result = 31 * result + (idCeh != null ? idCeh.hashCode() : 0);
        return result;
    }
}
