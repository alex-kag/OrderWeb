package pst.kopendakov.dbService.hibernate.models;


import pst.kopendakov.servlets.model.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tblUser")
public class TblUserEntity extends Model {

    @Id
//    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "login", nullable = false, length = 20)
    private String login;

    @Column(name = "pass", nullable = false, length = 50)
    private String pass;

    @Column(name = "soll", nullable = false, length = 50)
    private String soll;

    @ManyToOne
    @JoinColumn(name = "idCeh")
    private TblCehEntity tblCehEntity;

    public TblCehEntity getTblCehEntity() { return tblCehEntity; }

    public void setTblCehEntity(TblCehEntity tblCehEntity){
        this.tblCehEntity = tblCehEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSoll() {
        return soll;
    }

    public void setSoll(String soll) {
        this.soll = soll;
    }

}
