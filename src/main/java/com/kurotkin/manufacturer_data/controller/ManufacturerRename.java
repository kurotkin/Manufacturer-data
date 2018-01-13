package com.kurotkin.manufacturer_data.controller;

import com.kurotkin.manufacturer_data.dao.hibernate.HManufacturerDAO;
import com.kurotkin.manufacturer_data.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManufacturerRename extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HManufacturerDAO manufacturerDAO = new HManufacturerDAO();
        String idString = request.getParameter("rename");
        long id = Long.parseLong(idString);
        String newName = request.getParameter("newname");

        Manufacturer manufacturer = new Manufacturer().withID(id).withName(newName);
        manufacturerDAO.update(manufacturer);

        new Manufacturers_page().doGet(request, response);
    }
}
