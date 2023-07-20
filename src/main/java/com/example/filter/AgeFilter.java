package com.example.filter;

import com.example.domain.Driver;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

import static com.example.util.Constants.MAPPER;

@WebFilter(urlPatterns = "/driver")
public class AgeFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        BufferedReader reader = req.getReader();

        Driver driver = MAPPER.readValue(reader, Driver.class);

        if (driver.getAge() > 100) {
            res.setStatus(403);
            res.getWriter().println("Your age > 100");
        } else {
            chain.doFilter(req,res);
        }
    }
}
