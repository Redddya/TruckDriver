package com.example.dao;

import com.example.domain.Driver;
import com.example.domain.Truck;

import java.util.List;

public interface DriverDao extends CRUDDao<Driver>{
    public List<Truck> findAllTrucksByDriverId(int id);
}