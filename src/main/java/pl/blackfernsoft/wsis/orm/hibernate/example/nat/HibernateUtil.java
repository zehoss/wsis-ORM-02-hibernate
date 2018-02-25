package pl.blackfernsoft.wsis.orm.hibernate.example.nat;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import pl.blackfernsoft.wsis.orm.hibernate.entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

public class HibernateUtil {

    // Configuration from file resources/META-INF/persistence.xml
    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("persistenceUnit-h2");

    private static EntityManager entityManager;

    private HibernateUtil() {
    }


    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }


    public static void closeEntityManager() {
        entityManager.close();
        emf.close();
    }


    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Car.class);

        configuration.setProperties(new Properties() {
            {
                put("hibernate.connection.driver_class", "org.h2.Driver");
                put("hibernate.connection.url", "jdbc:h2:./test-native");
                put("hibernate.hbm2ddl.auto", "create");
                put("hibernate.show_sql", "true");
                put("hibernate.format_sql", "true");
            }
        });

        SessionFactory sessionFactory = configuration.buildSessionFactory(
                new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build());
        return sessionFactory;
    }

    public static SessionFactory getSessionFactoryFromXml() {
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Car.class);

        // load config from hibernate.cfg.xml
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory(
                new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build());
        return sessionFactory;
    }
}
