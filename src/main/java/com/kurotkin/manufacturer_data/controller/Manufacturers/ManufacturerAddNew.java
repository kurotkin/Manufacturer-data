package com.kurotkin.manufacturer_data.controller.Manufacturers;

import com.kurotkin.manufacturer_data.dao.hibernate.HManufacturerDAO;
import com.kurotkin.manufacturer_data.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManufacturerAddNew extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HManufacturerDAO manufacturerDAO = new HManufacturerDAO();
        String name = request.getParameter("name");
        Manufacturer manufacturer = new Manufacturer().withName(name);
        manufacturerDAO.save(manufacturer);

        new ManufacturersPage().doGet(request, response);
    }
}
