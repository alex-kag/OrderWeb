package pst.kopendakov.dbService.dao;

import org.junit.Before;
import org.junit.Test;
import pst.kopendakov.dbService.hibernate.models.TblUserEntity;
import pst.kopendakov.servlets.model.UserRole;

import static org.junit.Assert.*;

public class AuthorizationDaoTest {
    @Test
    public void checkAccess() throws Exception {
        AuthorizationDao authorizationDao = new AuthorizationDao();
        String login = "testuserlogin";
        String password = "testuserpass";

        TblUserEntity tblUserEntity = authorizationDao.checkAccess(login, password);
        assertEquals(tblUserEntity.getLogin(),login);
        assertEquals(tblUserEntity.getPass(),password);

        tblUserEntity = authorizationDao.checkAccess(login, "");
        assertNull(tblUserEntity);
//        assertNotEquals(tblUserEntity.getLogin(),login);
//        assertNotEquals(tblUserEntity.getPass(),password);

        tblUserEntity = authorizationDao.checkAccess(login, "123");
        assertNull(tblUserEntity);
//        assertNotEquals(tblUserEntity.getLogin(),login);
//        assertNotEquals(tblUserEntity.getPass(),password);
    }

    @Test
    public void getUserId() throws Exception {
        AuthorizationDao authorizationDao = new AuthorizationDao();
        long idReturn = authorizationDao.getUserId("testuserlogin");
        assertEquals(3,idReturn);
    }


    @Test
    public void getRole() throws Exception {
        AuthorizationDao authorizationDao = new AuthorizationDao();

        UserRole userRole = authorizationDao.getRole(1);

        assertEquals(userRole.name(),UserRole.user.toString());
        userRole = authorizationDao.getRole(100);
        assertEquals(userRole.name(),UserRole.boss.toString());
        userRole = authorizationDao.getRole(999);
        assertEquals(userRole.name(),UserRole.admin.toString());
    }

}