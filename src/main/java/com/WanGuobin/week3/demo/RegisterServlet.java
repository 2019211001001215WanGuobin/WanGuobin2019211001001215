package com.WanGuobin.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    Connection con = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String sql = "select * from usertable";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Username =request.getParameter("Username");
        String Password =request.getParameter("Password");
        String Email =request.getParameter("Email");
        String gender =request.getParameter("gender");
        String birthDate =request.getParameter("birthDate");


        PrintWriter writer = response.getWriter();
        writer.println("<br>Username :"+Username);
        writer.println("<br>Password :"+Password);
        writer.println("<br>Email :"+Email);
        writer.println("<br>gender :"+gender);
        writer.println("<br>birthDate :"+birthDate);
        writer.close();
    }
    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
