package com.example.servlet;

import com.example.domain.Driver;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

import static com.example.util.Constants.DRIVER_SERVICE;
import static com.example.util.Constants.MAPPER;

@WebServlet(urlPatterns = "/driver")
public class DriverServlet extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        Driver driver = MAPPER.readValue(reader, Driver.class);
        DRIVER_SERVICE.update(driver);
        super.doPut(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();

        Driver driver = MAPPER.readValue(reader, Driver.class);

        DRIVER_SERVICE.save(driver);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("dr_id");
        DRIVER_SERVICE.delete(Integer.parseInt(id));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("dr_id");

        Driver driver = DRIVER_SERVICE.findById(Integer.parseInt(id));
        String json = MAPPER.writeValueAsString(driver);
        response.getWriter().println(json);

    }

}
