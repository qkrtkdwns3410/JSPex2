package com.newlecture.web;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ExportException;

@WebServlet("/calc3")
public class calc3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        
        String value = request.getParameter("value");
        String operator = request.getParameter("operator");
        String dot = request.getParameter("dot");
        
        String exp = "";
        
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("op")) {
                    exp = c.getValue();
                    break;
                }
            }
        }
        if (operator != null && operator.equals("=")) {
        
        } else {
            exp += (value == null) ? "" : value;
            exp += (operator == null) ? "" : operator;
            exp += (dot == null) ? "" : dot;
    
        }
        
        
        Cookie expCookie = new Cookie("exp", exp);
        
        response.addCookie(expCookie);
        response.sendRedirect("calcpage");
        
        
    }
}

