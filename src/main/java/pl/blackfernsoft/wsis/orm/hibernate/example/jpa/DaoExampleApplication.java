package pl.blackfernsoft.wsis.orm.hibernate.example.jpa;

import pl.blackfernsoft.wsis.orm.hibernate.dao.CarDao;
import pl.blackfernsoft.wsis.orm.hibernate.entity.Car;
import pl.blackfernsoft.wsis.orm.hibernate.example.nat.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoExampleApplication {

    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        CarDao carDao = new CarDao(entityManager);

        entityManager.getTransaction().begin();

        Car carEntity = new Car();
        carEntity.setName("Volvo");
        carDao.save(carEntity);

        entityManager.getTransaction().commit();

        List<Car> cars = carDao.findAll();
        for (Car car : cars) {
            System.out.println(car);
        }

        HibernateUtil.closeEntityManager();

    }
}
