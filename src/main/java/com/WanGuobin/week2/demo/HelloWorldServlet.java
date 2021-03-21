package com.WanGuobin.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Name:Wan Guobin");
        writer.println("ID:2019211001001215");
        writer.println("Time:2021/3/14");

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
