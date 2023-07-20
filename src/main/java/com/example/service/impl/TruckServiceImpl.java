package com.example.service.impl;

import com.example.dao.CRUDDao;
import com.example.domain.Truck;
import com.example.service.CRUDService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TruckServiceImpl implements CRUDService<Truck> {

    private final CRUDDao<Truck> dao;

    public TruckServiceImpl(@Qualifier("truckDaoImpl") CRUDDao<Truck> dao) {
        this.dao = dao;
    }

    @Override
    public void save(Truck entity) {
        dao.save(entity);
    }

    @Override
    public Truck findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Truck entity) {
        dao.update(entity);
    }
}
