package pl.blackfernsoft.wsis.orm.hibernate.dao;

import pl.blackfernsoft.wsis.orm.hibernate.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerDao {

    private static EntityManager em;

    public CustomerDao(EntityManager entityManager) {
        em = entityManager;
    }

    public void save(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    public List<Customer> findAll() {
        return em.createQuery("from Customer").getResultList();
    }

    public Customer findById(Long id) {
        return em.find(Customer.class, id);
    }

    public void remove(Customer customer) {
        em.remove(customer);
    }

}
