package pst.kopendakov.dbService.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import pst.kopendakov.dbService.hibernate.models.TblCehEntity;

public class HibernateUtilFactory {
    private static EntityManagerFactory emf;
//    private static SessionFactory sessionFactory;

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }


    private static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {

            emf = Persistence.createEntityManagerFactory( "pst.kopendakov.order.jpa.hibernate" );
        }

        return emf;
    }

}


/*

    final Map<String, String> properties = new HashMap<>();

      properties.put("javax.persistence.provider", "org.hibernate.ogm.jpa.HibernateOgmPersistence");
      properties.put("javax.persistence.transactionType", "RESOURCE_LOCAL");
      properties.put("hibernate.ogm.datastore.provider", "mongodb");
      properties.put("hibernate.ogm.datastore.grid_dialect", "org.hibernate.ogm.datastore.mongodb.MongoDBDialect");
      properties.put("hibernate.ogm.datastore.database", "allandequeiroz");
      properties.put("hibernate.ogm.mongodb.host", "127.0.0.1");
      properties.put("hibernate.ogm.datastore.create_database", "false");
      properties.put("hibernate.ogm.mongodb.username", "");
      properties.put("hibernate.ogm.mongodb.password", "");

      final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default", properties);
      return factory.createEntityManager();

 */