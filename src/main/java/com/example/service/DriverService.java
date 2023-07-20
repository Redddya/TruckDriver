package com.example.service;

import com.example.domain.Driver;
import com.example.domain.Truck;

import java.util.List;

public interface DriverService extends CRUDService<Driver> {
    public List<Truck> findAllTrucksByDriverId(int id);
}
