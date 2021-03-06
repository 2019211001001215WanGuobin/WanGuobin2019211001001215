package com.WanGuobin.controller;

import com.WanGuobin.dao.ProductDao;
import com.WanGuobin.model.Category;
import com.WanGuobin.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductDetailsServlet", value = "/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=request.getParameter("id") != null?Integer.parseInt(request.getParameter("id")):0;
        System.out.println("id=="+id);
        ProductDao productDao=new ProductDao();
        if(id == 0){
            return;
        }
        List<Category> categoryList=Category.findAllCategory(con);
        request.setAttribute("categoryList",categoryList);

        try {
            Product product=productDao.findById(id,con);
            request.setAttribute("p",product);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        String path="WEB-INF/views/productDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
