package com.WanGuobin.week5.demo;

import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public Connection dbConn;
    public void init() {
        try { Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
            dbConn = DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"), getServletConfig().getServletContext().getInitParameter("Username"), getServletConfig().getServletContext().getInitParameter("Password"));
        } catch (Exception e) {
            System.out.println(e); } }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password= request.getParameter("password");
        System.out.println(name + password);
        PrintWriter writer = response.getWriter();
        try {
            if( dbConn != null){


                String sql = "SELECT * FROM usertable WHERE name=? AND password=?;";
                PreparedStatement ps = dbConn.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    writer.println("Login Success!!!");
                    writer.println("Welcome "+name+".");
                }else{
                    writer.print("Please Enter Again");
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }}}