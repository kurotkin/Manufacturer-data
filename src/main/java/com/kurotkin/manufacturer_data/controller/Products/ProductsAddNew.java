package com.kurotkin.manufacturer_data.controller.Products;

import com.kurotkin.manufacturer_data.dao.hibernate.HManufacturerDAO;
import com.kurotkin.manufacturer_data.dao.hibernate.HProductDAO;
import com.kurotkin.manufacturer_data.model.Manufacturer;
import com.kurotkin.manufacturer_data.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class ProductsAddNew extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HProductDAO productDAO = new HProductDAO();
        String name = request.getParameter("name");
        BigDecimal price = new BigDecimal(request.getParameter("price"));

        HManufacturerDAO manufacturerDAO = new HManufacturerDAO();

        Long manufacturerId = Long.parseLong(request.getParameter("manufacturer"));
        Manufacturer manufacturer = manufacturerDAO.getById(manufacturerId);

        Product product = new Product(name, price, manufacturer);
        productDAO.save(product);

        new ProductsPage().doGet(request, response);
    }
}
