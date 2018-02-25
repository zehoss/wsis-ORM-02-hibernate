package pl.blackfernsoft.wsis.orm.hibernate.example.jpa;

import pl.blackfernsoft.wsis.orm.hibernate.entity.Car;
import pl.blackfernsoft.wsis.orm.hibernate.example.nat.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class HibernateJpaApplication {


    public static void main(String[] args) {

        System.out.println("JPA Example");

        // Prepare a new entity
        Car car = new Car();
        car.setName("Audi");

        // Store entity in DB (persistence context)
        EntityManager em = HibernateUtil.getEntityManager();

//        em.getTransaction().begin();
//        em.persist(car);
//        em.getTransaction().commit();

        List<Car> result = em.createQuery("from Car").getResultList();
        System.out.println(result.size());
        for (Car carEntity : result) {
            System.out.println(carEntity);
        }

        result = em.createQuery("from Car").getResultList();
        System.out.println(result.size());
        for (Car carEntity : result) {
            System.out.println(carEntity);
        }


        Car carDb = em.find(Car.class, 3L);
        System.out.println("Found! " + carDb);

        // Parametry zapytania
        result = em.createQuery("FROM Car WHERE name=:MY_NAME AND plates=:MY_PLATES_PARAM")
                .setParameter("MY_NAME", "Audi")
                .setParameter("MY_PLATES_PARAM", "DW_234")
                .getResultList();
        for (Car carEntity : result) {
            System.out.println(carEntity);
        }

        // Close entity manager and entity manager factory
        HibernateUtil.closeEntityManager();

        System.out.println("fin");

    }


}
