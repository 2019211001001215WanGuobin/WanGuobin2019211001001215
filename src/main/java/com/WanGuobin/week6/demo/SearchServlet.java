package com.WanGuobin.week6.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String txt = URLEncoder.encode(request.getParameter("txt"),"utf-8");

        String search = request.getParameter("search");
        System.out.println(search);
        if(txt.equals("") || txt == null){
            response.sendRedirect("index.jsp");
        }else{
            if(search.equals("baidu")){
                response.sendRedirect("https://www.baidu.com/s?wd=" + txt);
            }else if(search.equals("bing")){
                response.sendRedirect("https://cn.bing.com/search?q=" + txt);
            }else if(search.equals("google")){
                response.sendRedirect("https://www.google.cn/search?q=" +txt);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
