package com.example.util;

import com.example.config.ConfigApp;
import com.example.domain.Truck;
import com.example.service.CRUDService;
import com.example.service.DriverService;
import com.example.service.impl.DriverServiceImpl;
import com.example.service.impl.TruckServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Constants {
    public static final ObjectMapper MAPPER = new ObjectMapper();
    public static final AnnotationConfigApplicationContext CONTEXT =
            new AnnotationConfigApplicationContext(ConfigApp.class);
    public static final DriverService DRIVER_SERVICE = CONTEXT.getBean(DriverServiceImpl.class);
    public static final CRUDService<Truck> TRUCK_SERVICE = CONTEXT.getBean(TruckServiceImpl.class);
}
