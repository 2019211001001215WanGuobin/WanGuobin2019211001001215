package com.WanGuobin.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection dbConn=null;
    @Override
    public void init() throws ServletException {
        //super.init();
        try {
            Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
            dbConn= DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"),getServletConfig().getServletContext().getInitParameter("username"),getServletConfig().getServletContext().getInitParameter("password"));
            System.out.println(dbConn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //dbConn=(Connection)getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birth=request.getParameter("birth");
        PrintWriter writer=response.getWriter();
//        writer.println("<br>");
//        writer.println("<br>username:"+username);
//        writer.println("<br>password:"+password);
//        writer.println("<br>email:"+mail);
//        writer.println("<br>gender:"+sex);
//        writer.println("<br>birthDate:"+birth);
        String[][] ret=new String[100][6];
       int cnt=0;
        try {
            Statement createDbStatement = dbConn.createStatement();
            String dbRequire1="insert into usertable(username,password,email,gender,birthdate) values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birth+"')";
//            System.out.println(dbRequire1);
            createDbStatement.executeUpdate(dbRequire1);
            System.out.println("成功");
//            String dbRequire="select * from usertable";
//            ResultSet resultDb=createDbStatement.executeQuery(dbRequire);
//            while(resultDb.next()) {
//                ret[cnt][0]=resultDb.getObject(1).toString().trim();
//                ret[cnt][1]=resultDb.getObject(2).toString().trim();
//                ret[cnt][2]=resultDb.getObject(3).toString().trim();
//                ret[cnt][3]=resultDb.getObject(4).toString().trim();
//                ret[cnt][4]=resultDb.getObject(5).toString().trim();
//                ret[cnt++][5]=resultDb.getObject(6).toString().trim();
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
        response.sendRedirect("login.jsp");

    }
}