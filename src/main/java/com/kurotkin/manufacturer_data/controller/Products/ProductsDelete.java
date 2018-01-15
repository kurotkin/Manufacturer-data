package com.kurotkin.manufacturer_data.controller.Products;

import com.kurotkin.manufacturer_data.dao.hibernate.HProductDAO;
import com.kurotkin.manufacturer_data.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductsDelete extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HProductDAO productDAO = new HProductDAO();
        String idString = request.getParameter("del");
        long id = Long.parseLong(idString);

        Product product = new Product().withId(id);
        productDAO.delete(product);

        new Products_page().doGet(request, response);
    }
}
