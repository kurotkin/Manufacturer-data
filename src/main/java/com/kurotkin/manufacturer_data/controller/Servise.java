package com.kurotkin.manufacturer_data.controller;

import com.kurotkin.manufacturer_data.dao.hibernate.HProductDAO;
import com.kurotkin.manufacturer_data.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Servise extends HttpServlet{

    private String mess;

    public void init() throws ServletException {
        mess = "Product data";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter p = response.getWriter();
        p.println("<!DOCTYPE html>" + "<html><head><title>" + mess + "</title></head><body>");
        p.println("<h1>" + mess + "<h1>");

        HProductDAO productDAO = new HProductDAO();
        List<Product> products = productDAO.getAll();

        products.stream().forEach(  product -> {
            p.println("ID: " + product.getId() + "<br/>");
            p.println("Name: " + product.getName() + "<br/>");
            p.println("Price: " + product.getPrice() + "<br/>");
            p.println("Manufacturer: " + product.getManufacturer().getName() + "<br/>");
        });

        p.println("</body></html>");
    }


    public void destroy() {

    }
}
