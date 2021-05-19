package com.newlecture.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hi")
public class Nana extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        response.setContentType("text/html; charset=UTF-8");
    
        PrintWriter out = response.getWriter();
    
        String cnt_ = request.getParameter("cnt");
    
        int cnt = 100;
        if (cnt_ != null && !cnt_.equals("")) {
            cnt = Integer.parseInt(cnt_);
        }
        for (int i = 0; i < cnt; i++) {
            out.println((i+1)+": 안녕 Hello Servlet!!<br />");
        }
    }
}
