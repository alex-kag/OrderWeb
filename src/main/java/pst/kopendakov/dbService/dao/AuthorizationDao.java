package pst.kopendakov.dbService.dao;


import pst.kopendakov.dbService.hibernate.HibernateUtilFactory;
import pst.kopendakov.dbService.hibernate.models.TblUserEntity;
import pst.kopendakov.servlets.model.UserRole;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by proton2 on 29.10.2016.
 */
public class AuthorizationDao {

    private EntityManager entityManager = null;

    public AuthorizationDao() {
        entityManager = HibernateUtilFactory.getEntityManager();
    }

    public TblUserEntity checkAccess(String login, String password) throws IOException {

        TblUserEntity user = null;
        user = (TblUserEntity) entityManager.createQuery(
                "select u from TblUserEntity u " +
                        "where u.login like :login ")
                .setParameter("login", login)
                .getSingleResult();

//        if (null != user) {
//            String role_id = getRole(user.getTblCehEntity().getIdCeh());
//            if (login.equals(user.getLogin()) && password.equals(user.getPass())) {
//                return role_id.equalsIgnoreCase("admin") ? UserRole.admin : (role_id.equalsIgnoreCase("boss") ? UserRole.boss : UserRole.user);
//            }

        return user;
    }

    public UserRole getRole(long idCeh) {
        UserRole role =null;

        switch ((int)idCeh) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                role = UserRole.user;
                break;
            case 100:
                role = UserRole.boss;
                break;
            case 999:
                role = UserRole.admin;;
                break;
        }
        return role;
    }


    public Long getUserId(String login) throws IOException {
        Long id = -1l;

        TblUserEntity user = (TblUserEntity) entityManager.createQuery(
                "select u from TblUserEntity u " +
                        "where u.login like :login ")
                .setParameter("login", login)
                .getSingleResult();

        if (null != user) {
            id = (long) user.getId();
        }
        return id;
    }
}