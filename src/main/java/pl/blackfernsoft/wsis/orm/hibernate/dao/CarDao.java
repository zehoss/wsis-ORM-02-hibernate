package pl.blackfernsoft.wsis.orm.hibernate.dao;

import pl.blackfernsoft.wsis.orm.hibernate.entity.Car;

import javax.persistence.EntityManager;
import java.util.List;

public class CarDao extends AbstractDao<Car> {

    public CarDao(EntityManager em) {
        super(em, Car.class);
    }

    public List<Car> findByPlates(String plates) {
        return em.createQuery("from Car where plates = :platesNumber")
                .setParameter("platesNumber", plates)
                .getResultList();
    }
}
