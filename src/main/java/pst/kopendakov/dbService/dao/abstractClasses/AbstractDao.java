package pst.kopendakov.dbService.dao.abstractClasses;


import pst.kopendakov.dbService.dao.abstractClasses.Dao;
import pst.kopendakov.dbService.hibernate.HibernateUtilFactory;
import pst.kopendakov.servlets.model.Model;

import javax.persistence.EntityManager;
import java.io.IOException;
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
        List<T> result = entityManager.createQuery(
                "from "+type.getSimpleName() )
                .getResultList();

        return result;
    }

    @Override
    public T getById(Long itemId) throws IOException {
//        T item = cacheGet(itemId);
//        if (item != null) return item;

        T result = (T)entityManager.createQuery(
                "select r from " + type.getSimpleName() + " r " +
                        "where r.id = :id" )
                .setParameter("id",itemId)
                .getSingleResult();

//        cachePut(item);
        return result;
    }

    @Override
    public void insert(T entity) throws IOException {

        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(T entity) throws IOException {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) throws IOException {
        entityManager.getTransaction().begin();
        int deletedEntities = entityManager.createQuery(
                "delete " +type.getSimpleName() + " d " +
                        "where d.id = :id" )
                .setParameter( "id", id )
                .executeUpdate();

        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(T entity) throws IOException {

        entityManager.getTransaction().begin();
        entityManager.remove(entity);
//        entityManager.getTransaction().begin();
//        int deletedEntities = entityManager.createQuery(
//                "delete " +type.getSimpleName() + " d " +
//                        "where d.id = :id" )
//                .setParameter( "id", id )
//                .executeUpdate();

        entityManager.getTransaction().commit();

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
    public int getNumOfRecords(T entity) throws IOException {
        int numOfRecords = -1;

        numOfRecords = (int)entityManager.createQuery(
                "select count (e.id) from "+type.getSimpleName()+" e " )
                .getSingleResult();

        return numOfRecords;
    }
}
