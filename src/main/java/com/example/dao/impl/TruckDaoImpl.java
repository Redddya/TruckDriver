package com.example.dao.impl;

import com.example.dao.CRUDDao;
import com.example.domain.Truck;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Transactional
@Repository
public class TruckDaoImpl implements CRUDDao<Truck> {
    @PersistenceContext
    private EntityManager em;
    @Override
    public void save(Truck entity) {
        em.persist(entity);
    }

    @Override
    public Truck findById(int id) {
        return em.find(Truck.class, id);
    }

    @Override
    public void delete(int id) {
        Query query = em.createQuery("DELETE Truck t WHERE t.id = :tr_id");
        query.setParameter("tr_id", id);
        query.executeUpdate();
    }

    @Override
    public void update(Truck entity) {
        Truck truck = em.merge(entity);
        em.persist(truck);
    }
}
