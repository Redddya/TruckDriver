package com.example.service.impl;

import com.example.dao.DriverDao;
import com.example.domain.Driver;
import com.example.domain.Truck;
import com.example.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DriverServiceImpl implements DriverService {
    private DriverDao dao;
    @Override
    public void save(Driver entity) {
        dao.save(entity);
    }

    @Override
    public Driver findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Driver entity) {
        dao.update(entity);
    }

    @Override
    public List<Truck> findAllTrucksByDriverId(int id) {
        return dao.findAllTrucksByDriverId(id);
    }
}
