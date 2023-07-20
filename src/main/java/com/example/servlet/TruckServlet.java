package com.example.servlet;


import com.example.domain.Truck;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

import static com.example.util.Constants.*;

@WebServlet(urlPatterns = "/truck")
public class TruckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();

        Truck truck = MAPPER.readValue(reader, Truck.class);
        TRUCK_SERVICE.save(truck);

        System.out.println(truck);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("tr_id");

        Truck truck = TRUCK_SERVICE.findById(Integer.parseInt(id));
        String json = MAPPER.writeValueAsString(truck);
        response.getWriter().println(json);
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        Truck truck = MAPPER.readValue(reader, Truck.class);
        TRUCK_SERVICE.update(truck);
        super.doPut(request, response);
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("dr_id");
        TRUCK_SERVICE.delete(Integer.parseInt(id));
    }
}
