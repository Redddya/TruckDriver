package com.example.dao.impl;

import com.example.dao.DriverDao;
import com.example.domain.Driver;
import com.example.domain.Truck;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
@Repository
public class DriverDaoImpl implements DriverDao {
    @PersistenceContext
    private EntityManager em;
    @Override
    public void save(Driver entity) {
        em.persist(entity);
    }

    @Override
    public Driver findById(int id) {
        return em.find(Driver.class, id);
    }

    @Override
    public void delete(int id) {
        Query query = em.createQuery("DELETE Driver d WHERE d.id = :dr_id");
        query.setParameter("dr_id", id);
        query.executeUpdate();
    }

    @Override
    public void update(Driver entity) {
        Driver driver = em.merge(entity);
        em.merge(driver);
    }

    @Override
    public List<Truck> findAllTrucksByDriverId(int id) {
        TypedQuery<Truck> query = em.createQuery("FROM Truck t where t.driver.id = :dr_id", Truck.class);
        query.setParameter("dr_id", id);
        return  query.getResultList();
    }
}
