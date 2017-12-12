package com.kurotkin.manufacturer_data.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servise extends HttpServlet{

    private String mess;

    public void init(){
        mess = "Test";
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        PrintWriter p = res.getWriter();
        p.println("<h1>" + mess + "<h1>");
    }
}
