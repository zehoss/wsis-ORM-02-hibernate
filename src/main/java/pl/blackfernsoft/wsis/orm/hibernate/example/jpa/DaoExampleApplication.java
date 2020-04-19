package pl.blackfernsoft.wsis.orm.hibernate.example.jpa;

import pl.blackfernsoft.wsis.orm.hibernate.dao.CarDao;
import pl.blackfernsoft.wsis.orm.hibernate.entity.Car;
import pl.blackfernsoft.wsis.orm.hibernate.example.nat.HibernateUtil;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class DaoExampleApplication {

    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        CarDao carDao = new CarDao(entityManager);

        List<Car> mojSamochod = carDao.findByPlates("DW1234");
        List<Car> mojSamochod2 = carDao.findByPlates("PO243243");

        entityManager.getTransaction().begin();

        Car carEntity = new Car();
        carEntity.setName("Volvo");
        carEntity.setCreatedAt(LocalDateTime.now());
        carDao.save(carEntity);

        entityManager.getTransaction().commit();

        List<Car> cars = carDao.findAll();
        for (Car car : cars) {
            System.out.println(car);
        }

        HibernateUtil.closeEntityManager();

    }
}
