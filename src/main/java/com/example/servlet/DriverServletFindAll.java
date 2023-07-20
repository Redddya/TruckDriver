package com.example.servlet;

import com.example.domain.Truck;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import static com.example.util.Constants.DRIVER_SERVICE;
import static com.example.util.Constants.MAPPER;

@WebServlet(urlPatterns = "/driver/all")
public class DriverServletFindAll extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("dr_id");
        int newId = Integer.parseInt(id);

        List<Truck> trucks = DRIVER_SERVICE.findAllTrucksByDriverId(newId);
        String json = MAPPER.writeValueAsString(trucks);
        response.getWriter().println(json);
    }
}
