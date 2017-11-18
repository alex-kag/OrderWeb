package pst.kopendakov.dbService.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class HibernateUtilFactory {
    private static EntityManagerFactory emf;
//    private static SessionFactory sessionFactory;

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }


    private static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {

//            Map<String, String> properties = new HashMap<>();
//
//            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//            properties.put("hibernate.connection.datasource", "java:comp/env/jdbc/dbOrder");
//            properties.put("hibernate.show_sql", "true");
//            properties.put("hibernate.hbm2ddl.auto", "hibernate_hbm2ddl_auto");
//            properties.put("hibernate.c3p0.min_size", "5");
//            properties.put("hibernate.current_session_context_class", "thread");


//            emf = Persistence.createEntityManagerFactory(null, properties);


//            emf = Persistence.createEntityManagerFactory("*");
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