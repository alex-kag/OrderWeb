package pst.kopendakov.dbService.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration();

            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            configuration.setProperty("hibernate.connection.datasource", "java:comp/env/jdbc/dbOrder");
            configuration.setProperty("hibernate.show_sql", "true");
            //configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
            configuration.setProperty("hibernate.current_session_context_class", "thread");

            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

//            configuration.addAnnotatedClass(me.svetilnik.dbService.hibernate.model.dataSet.ClientsEntity.class);
//            configuration.addAnnotatedClass(me.svetilnik.dbService.hibernate.model.dataSet.DealEntity.class);
//            configuration.addAnnotatedClass(me.svetilnik.dbService.hibernate.model.dataSet.EmployeesEntity.class);
//            configuration.addAnnotatedClass(me.svetilnik.dbService.hibernate.model.dataSet.LocationEntity.class);
//            configuration.addAnnotatedClass(me.svetilnik.dbService.hibernate.model.dataSet.ParampropertyEntity.class);
//            configuration.addAnnotatedClass(me.svetilnik.dbService.hibernate.model.dataSet.PositionsEntity.class);
//            configuration.addAnnotatedClass(me.svetilnik.dbService.hibernate.model.dataSet.PropertyEntity.class);
//            configuration.addAnnotatedClass(me.svetilnik.dbService.hibernate.model.dataSet.StreetsEntity.class);
//            configuration.addAnnotatedClass(me.svetilnik.dbService.hibernate.model.dataSet.ViewdealEntity.class);


            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }
}