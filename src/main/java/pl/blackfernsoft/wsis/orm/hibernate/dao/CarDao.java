package pl.blackfernsoft.wsis.orm.hibernate.dao;

import pl.blackfernsoft.wsis.orm.hibernate.entity.Car;

import javax.persistence.EntityManager;

public class CarDao extends AbstractDao<Car> {

    public CarDao(EntityManager em) {
        super(em, Car.class);
    }

}
