package com.WanGuobin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("I am in AuthFilter-->doFilter()- before servlet(request come here)");
        chain.doFilter(request, response);
        System.out.println("I am in AuthFilter-->doFilter()- after servlet(response come here)");
    }

}
