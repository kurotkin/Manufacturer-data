package com.kurotkin.manufacturer_data.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Post extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendErr(request, response);
    }

    public void sendErr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(403, "Access denied!!! \n Доступа нет!!!");
    }

}
