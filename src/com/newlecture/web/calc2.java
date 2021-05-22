package com.newlecture.web;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.websocket.Session;
import java.io.IOException;

@WebServlet("/calc2")
public class calc2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext session = request.getSession().getServletContext();
        Cookie[] cookies = request.getCookies();
        
        response.setContentType("text/html; charset=UTF-8");
        
        String v_ = request.getParameter("v");
        String op = request.getParameter("operator");
        
        int v = 0; //사용자가 값을 입력하지 않고 op를 누를시에는 값을 0으로 칩니다.
        
        if (!v_.equals("")) v = Integer.parseInt(v_);//v_가 공백이 아니라면 v_를  int로 변환합니다.
        
        if (op.equals("=")) { //= 이면 밸류값을 불러옵니다.
//            int x = (Integer) session.getAttribute("value");
            int x = 0;
            
            
            for (Cookie c : cookies) {
                if (c.getName().equals("value")) {
                    x = Integer.parseInt(c.getValue());
                    break;
                }
            }
            
            int y = v;
//            String operator = (String) session.getAttribute("op");
            
            String operator = "";
            for (Cookie c : cookies) {
                if (c.getName().equals("op")) {
                    operator = c.getValue();
                    break;
                }
            }
            int result = 0;
            
            if (operator.equals("+")) { //이후 계산합니다.
                result = x + y;
            } else {
                result = x - y;
            }
            response.getWriter().printf("result is %d\n", result);
        } else {
//            session.setAttribute("value", v);//맵과 같음. 네임 밸류형식
//            session.setAttribute("op", op);//맵과 같음. 네임 밸류형식
            Cookie valueCookie = new Cookie("value", String.valueOf(v));
            Cookie opCookie = new Cookie("op", op);
            valueCookie.setPath("/calc2");
            valueCookie.setMaxAge(24*60*60); //1시간 *24 >>쿠키의 만료날짜.
            opCookie.setPath("/calc2"); //브라우저가 닫히면 쿠키가 사라집니다.
            response.addCookie(valueCookie);
            response.addCookie(opCookie);
            
            response.sendRedirect("calc2.html");
        }
        //세션과 어플리케이션 차이
        //다른 브라우저로 사용하면 다른 사용자로 인식합니다.
        //어플리케이션의 경우 다른 사용자로 인식하지 않습니다.
        //같은 브라우저로 사용시에 ...>> 같은 세션으로 인식합니다.
        
    }
    
    
}

