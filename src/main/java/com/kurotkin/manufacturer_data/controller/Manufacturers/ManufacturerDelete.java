package com.kurotkin.manufacturer_data.controller.Manufacturers;

import com.kurotkin.manufacturer_data.dao.hibernate.HManufacturerDAO;
import com.kurotkin.manufacturer_data.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManufacturerDelete  extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HManufacturerDAO manufacturerDAO = new HManufacturerDAO();
        String idString = request.getParameter("del");
        long id = Long.parseLong(idString);

        Manufacturer manufacturer = new Manufacturer().withID(id);
        manufacturerDAO.delete(manufacturer);

        new Manufacturers_page().doGet(request, response);
    }
}
