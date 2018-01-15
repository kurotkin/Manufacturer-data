package com.kurotkin.manufacturer_data.controller.Products;

import com.kurotkin.manufacturer_data.controller.Manufacturers.ManufacturersPage;
import com.kurotkin.manufacturer_data.dao.hibernate.HProductDAO;
import com.kurotkin.manufacturer_data.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductsRename extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HProductDAO productDAO = new HProductDAO();
        long id = Long.parseLong(request.getParameter("rename"));
        String newName = request.getParameter("newname");

        Product product = new Product().withId(id).withName(newName);
        productDAO.update(product);

        new ProductsPage().doGet(request, response);
    }
}
