package com.kurotkin.manufacturer_data.controller.Products;

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

public class ProductsPage extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        final PrintWriter p = response.getWriter();
        p.println("<!DOCTYPE html>" + "<html><head><title>" + "Products" + "</title></head><body>");
        p.println("<center>");
        p.println("<h1>" + "Products" + "</h1>");
        p.println("<hr>");

        p.println("<h2>" + "Menu:" + "</h2>");
        p.println("<p><a href=\"/\">Main</a></p>");
        p.println("<p><a href=\"/manufacturers\">Manufacturers</a></p>");
        p.println("<p><a href=\"/products\">Products</a></p>");
        p.println("<br>");
        p.println("<hr>");


        p.println("<h2>" + "Add new:" + "</h2>");
        p.println("<form action=\"ProductsAddNew\" method=\"POST\">");
        p.println("Product name: <input type=\"text\" name=\"name\"> <br>");
        p.println("Product price: <input type=\"text\" name=\"price\"> <br>");
        p.println("Manufacturer: <input type=\"text\" name=\"manufacturer\"> <br>");
        p.println("<input type=\"submit\" value=\"Add\"/>");
        p.println("</form>");
        p.println("<br>");
        p.println("<hr>");

        p.println("<h2>" + "Products table:" + "</h2>");
        HProductDAO productDAO = new HProductDAO();
        List<Product> products = productDAO.getAll();

        String str = "";
        str += "<table cellpadding=\"7\" border=\"1\">\n";

        str += "<tr>\n";
        str += "<td>" + "ID" + "</td>\n";
        str += "<td>" + "Name" + "</td>\n";
        str += "<td>" + "Price" + "</td>\n";
        str += "<td>" + "Manufacturer" + "</td>\n";
        str += "<td>" + "Delete" + "</td>\n";
        str += "<td>" + "Rename" + "</td>\n";
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
            str += "<td>" +
                    "<form action=\"ProductsDelete\" method=\"POST\">\n" +
                    "<button name=\"del\" value=\"" + products.get(i).getId() + "\">Delete</button>\n" +
                    "</form>\n" +
                    "</td>\n";
            str += "<td>" +
                    "<form action=\"ProductsRename\" method=\"POST\">\n" +
                    "<input type=\"text\" name=\"newname\">\n" +
                    "<button name=\"rename\" value=\"" + products.get(i).getId() + "\">Rename</button>\n" +
                    "</form>\n" +
                    "</td>\n";
            str += "</tr>\n";
        }

        p.println(str);
        p.println("</center>");
        p.println("</body></html>");
    }

}
