package com.t2010a.hellot2010aagain.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddSessionDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");

        HttpSession session = req.getSession();

        session.setAttribute("name", name);
        session.setAttribute("phone", phone);
        resp.getWriter().println("Add session success.");
    }
}
