package com.WanGuobin.controller;

import com.WanGuobin.dao.UserDao;
import com.WanGuobin.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        UserDao userDao=new UserDao();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        request.setCharacterEncoding("utf-8");
        int id= Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String gender=request.getParameter("gender");
        String email=request.getParameter("email");
        java.sql.Date date= Date.valueOf(request.getParameter("birth"));

        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setGender(gender);
        user.setEmail(email);
        user.setBirthdate(date);
        try {
            userDao.updateUser(con,user);
            user=userDao.findById(con,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HttpSession session=request.getSession();
        session.setAttribute("user",user);
        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
//        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
    }
}
