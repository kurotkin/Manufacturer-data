package com.kurotkin.manufacturer_data.controller;

import com.kurotkin.manufacturer_data.dao.hibernate.HProductDAO;
import com.kurotkin.manufacturer_data.model.Manufacturer;
import com.kurotkin.manufacturer_data.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Products_page extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        final PrintWriter p = response.getWriter();
        p.println("<!DOCTYPE html>" + "<html><head><title>" + "Products" + "</title></head><body>");
        p.println("<center>");
        p.println("<h1>" + "Products" + "</h1>");

        p.println("<p><a href=\"/\">Main</a></p>");
        p.println("<p><a href=\"/manufacturers\">Manufacturers</a></p>");
        p.println("<p><a href=\"/products\">Products</a></p>");

        HProductDAO productDAO = new HProductDAO();
        List<Product> products = productDAO.getAll();

        String str = "";
        str += "<table cellpadding=\"7\" border=\"1\">\n";

        str += "<tr>\n";
        str += "<td>" + "ID" + "</td>\n";
        str += "<td>" + "Name" + "</td>\n";
        str += "<td>" + "Price" + "</td>\n";
        str += "<td>" + "Manufacturer" + "</td>\n";
        str += "</tr>\n";

        for(int i = 0; i < products.size(); i++){
            str += "<tr>\n";
            str += "<td>" + products.get(i).getId() + "</td>\n";
            str += "<td>" + products.get(i).getName() + "</td>\n";
            str += "<td>" + products.get(i).getPrice() + "</td>\n";
            Manufacturer manufacturer = products.get(i).getManufacturer();
            String manufacturerName;
            if(manufacturer == null){
                manufacturerName = "";
            } else {
                manufacturerName =  manufacturer.getName();
            }
            str += "<td>" + manufacturerName + "</td>\n";
            str += "</tr>\n";
        }

        p.println(str);
        p.println("</center>");
        p.println("</body></html>");
    }

}
