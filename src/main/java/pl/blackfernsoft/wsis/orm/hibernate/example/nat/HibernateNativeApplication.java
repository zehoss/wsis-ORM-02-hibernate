package pl.blackfernsoft.wsis.orm.hibernate.example.nat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.blackfernsoft.wsis.orm.hibernate.entity.Car;

import java.util.List;

public class HibernateNativeApplication {

    public static void main(String[] args) {

        System.out.println("Hibernate native example");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactoryFromXml();

        Car car = new Car();
        car.setName("Audi");

        // Storing objects
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // entities
        session.save(car);
        session.getTransaction().commit();
        session.close();

        // Selecting objects
        session = sessionFactory.openSession();
        session.beginTransaction();
        List<Car> result = session.createQuery("from Car").list();
        for (Car event : result) {
            System.out.println(car);
        }
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();


        System.out.println("fin");

    }

}
