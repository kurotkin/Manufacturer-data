package com.kurotkin.manufacturer_data.controller;

import com.kurotkin.manufacturer_data.dao.hibernate.HManufacturerDAO;
import com.kurotkin.manufacturer_data.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Manufacturers_page extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        final PrintWriter p = response.getWriter();
        p.println("<!DOCTYPE html>" + "<html><head><title>" + "Manufacturers" + "</title></head><body>");
        p.println("<center>");
        p.println("<h1>" + "Manufacturers" + "</h1>");

        p.println("<h2>" + "Menu:" + "</h2>");
        p.println("<p><a href=\"/\">Main</a></p>");
        p.println("<p><a href=\"/manufacturers\">Manufacturers</a></p>");
        p.println("<p><a href=\"/products\">Products</a></p>");

        p.println("<h2>" + "Add new:" + "</h2>");
        p.println("<form action=\"ManufacturerAddNew\" method=\"POST\">");
        p.println("Name: <input type=\"text\" name=\"name\">");
        p.println("<input type=\"submit\" value=\"Add\"/>");
        p.println("</form>");

        p.println("<h2>" + "Current:" + "</h2>");
        HManufacturerDAO manufacturerDAO = new HManufacturerDAO();
        List<Manufacturer> manufacturers = manufacturerDAO.getAll();

        String str = "";
        str += "<table cellpadding=\"7\" border=\"1\">\n";

        str += "<tr>\n";
        str += "<td>" + "ID" + "</td>\n";
        str += "<td>" + "Name" + "</td>\n";
        str += "<td>" + "Delete" + "</td>\n";
        str += "</tr>\n";

        for(int i = 0; i < manufacturers.size(); i++){
            str += "<tr>\n";
            str += "<td>" + manufacturers.get(i).getId() + "</td>\n";
            str += "<td>" + manufacturers.get(i).getName() + "</td>\n";
            str += "<td>" +
                    "<form action=\"ManufacturerDelete\" method=\"POST\">\n" +
                    "<button name=\"del\" value=\"" + manufacturers.get(i).getId() + "\">Delete</button>\n" +
                    "</form>\n" +
                    "</td>\n";
            str += "</tr>\n";
        }
        p.println(str);

        p.println("</center>");
        p.println("</body></html>");
    }

}
