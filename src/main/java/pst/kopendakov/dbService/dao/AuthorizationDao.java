package pst.kopendakov.dbService.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import pst.kopendakov.dbService.hibernate.HibernateUtil;
import pst.kopendakov.servlets.model.UserRole;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by proton2 on 29.10.2016.
 */
public class AuthorizationDao {

    private Session session = null;

    public AuthorizationDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public UserRole checkAccess(String login, String password) throws IOException {

        session.createQuery("from TblUserEntity")

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;//DataSource.getInstance().getConnection();
        String checkUserSql = "select login, password, role_id from usertable where login = ?";
        try {
            ps = connection.prepareStatement(checkUserSql);
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.next()) {
                String role_id = rs.getString("role_id");
                if(login.equals(rs.getString("login")) && password.equals(rs.getString("password"))){
                    return role_id.equalsIgnoreCase("admin") ? UserRole.admin : (role_id.equalsIgnoreCase("boss") ? UserRole.boss : UserRole.user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException(e.getMessage());
        } finally {
            if (rs != null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}
            if (ps != null) try {ps.close();} catch (SQLException e) {e.printStackTrace();}
            try {connection.close();} catch (SQLException e) {e.printStackTrace();}
        }

        return null;
    }

    public Long getUserId(String login) throws IOException {
        Long id = -1l;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;//DataSource.getInstance().getConnection();
        String getUserIdSql = "select id from usertable where login = ?";
        try {
            ps = connection.prepareStatement(getUserIdSql);
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getLong("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException(e.getMessage());
        } finally {
            if (rs != null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}
            if (ps != null) try {ps.close();} catch (SQLException e) {e.printStackTrace();}
            try {connection.close();} catch (SQLException e) {e.printStackTrace();}
        }
        return id;
    }
}