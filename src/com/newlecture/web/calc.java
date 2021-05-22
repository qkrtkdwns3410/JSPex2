package com.newlecture.web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calc")
public class calc extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        response.setContentType("text/html; charset=UTF-8");
        
        
        String x_ = request.getParameter("x");
        String y_ = request.getParameter("y");
        String op = request.getParameter("operator");
        
        int x = 0;//빈 문자열이 올 경우에 대비하여  0으로 초기화합니다.
        int y = 0;
        
        if(!x_.equals("")) x = Integer.parseInt(x_);
        if(!y_.equals("")) y = Integer.parseInt(y_);
    
        int result = 0;
    
        if (op.equals("덧셈")) {
            result = x + y;
        } else {
            result = x - y;
        }
        
        response.getWriter().printf("result is %d\n", result);
        
    }
}
