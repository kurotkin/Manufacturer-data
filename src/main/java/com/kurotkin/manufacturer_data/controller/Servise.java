package com.kurotkin.manufacturer_data.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servise extends HttpServlet{

    private String mess;

    public void init() throws ServletException {
        mess = "Test";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter p = response.getWriter();
        p.println("<h1>" + mess + "<h1>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendErr(request, response);
    }

    public void sendErr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(403, "Access denied!!!");
    }

    public void destroy() {

    }
}
