package pst.kopendakov.dbService.dao;


import pst.kopendakov.dbService.hibernate.HibernateUtilFactory;
import pst.kopendakov.servlets.model.Model;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.sql.*;
import java.util.List;

/**
 * Created by proton2 on 03.06.2017.
 */
public class AbstractDao<T extends Model> implements Dao<T> {

    private Class<T> type;
//    private DataSource dataSource;
    private EntityManager entityManager = null;

    public Class<T> getType() {
        return type;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public AbstractDao(Class<T> type) {
        this.type = type;
        entityManager = HibernateUtilFactory.getEntityManager();

    }

    @Override
    public List<T> getAll(int offcet, int limit) throws IOException {
//        String getAllSql = SqlXmlReader.getQuerryStr(type.getSimpleName(), "getAll");
        List<T> result = null;

        return result;
    }

    @Override
    public T getById(Long itemId) throws IOException {
        T item = cacheGet(itemId);
        if (item != null) return item;

//        String getSql = SqlXmlReader.getQuerryStr(type.getSimpleName(), "getById");

//        try (Connection conn = dataSource.getConnection();
//             PreparedStatement ps = conn.prepareStatement(getSql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
//            ps.setLong(1, itemId);
//            ResultSet rs = ps.executeQuery();
//            ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
//            item = resultSetMapper.mapRersultSetToObject(rs, type);
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new IOException(e.getMessage());
//        }
        cachePut(item);
        return item;
    }

    @Override
    public void insert(T entity) throws IOException {
//        String insertSql = SqlXmlReader.getQuerryStr(type.getSimpleName(), "insert");
//        try (Connection conn = dataSource.getConnection();
//             PreparedStatement ps = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {
//            ResultSetMapper.putEntityToPreparedStatement(ps, entity);
//            ps.executeUpdate();
//
//            ResultSet generatedKeys = ps.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                entity.setId(generatedKeys.getLong(1));
//            } else {
//                throw new IOException("Creating user failed, no ID obtained.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new IOException(e.getMessage());
//        }
//        cachePut(entity);
    }

    @Override
    public void update(T entity) throws IOException {
//        String updateSql = SqlXmlReader.getQuerryStr(type.getSimpleName(), "update");
//        try (Connection conn = dataSource.getConnection();
//             PreparedStatement ps = conn.prepareStatement(updateSql);) {
//            ResultSetMapper.putEntityToPreparedStatement(ps, entity);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new IOException(e.getMessage());
//        }
//        cachePut(entity);
    }

    @Override
    public void delete(Long id) throws IOException {
//        String deleteSql = SqlXmlReader.getQuerryStr(type.getSimpleName(), "delete");
//        try (Connection conn = dataSource.getConnection();
//             PreparedStatement ps = conn.prepareStatement(deleteSql);) {
//            ps.setLong(1, id);
//            ps.executeUpdate();
//            cacheRemove(id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new IOException(e.getMessage());
//        }
    }

    private void cachePut(T item) {
//        Cache cache = EHCacheManger.getCache();
//        cache.put(new Element(item.getId(), item));
    }

    private void cacheRemove(Long itemId) {
//        Cache cache = EHCacheManger.getCache();
//        cache.remove(itemId);
    }

    private T cacheGet(Long itemId) {
//        Cache cache = EHCacheManger.getCache();
//        Element element = cache.get(itemId);
//        if (element != null) {
//            return (T) element.getObjectValue();
//        }
        return null;
    }

    @Override
    public int getNumOfRecords(String tableName) throws IOException {
//        Connection connection = DataSource.getInstance().getConnection();
//        Statement statement = null;
//        ResultSet resultSet = null;
        int numOfRecords = -1;
//        try {
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("select count(*) from " + tableName);
//            while (resultSet.next()) {
//                numOfRecords = resultSet.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new IOException(e.getMessage());
//        } finally {
//            if (resultSet != null) try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
//            if (statement != null) try {statement.close();} catch (SQLException e) {e.printStackTrace();}
//            try {connection.close();} catch (SQLException e) {e.printStackTrace();}
//        }
        return numOfRecords;
    }
}
