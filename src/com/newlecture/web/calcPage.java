package com.newlecture.web;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calcPage")
public class calcPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("<!DOCTYPE html>");
        
;<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
                input {
            width: 50px;
            height: 50px;
        }
        .output {
            height: 50px;
            background: beige;
            font-size: 24px;
            font-weight: bold;
            text-align: right;
            padding: 0
        }
    </style>
</head>
<body>
<form action="calc3" method="post">
    <table>
        <tr>
            <td class="output" colspan="4"></td>
        </tr>
        <tr>
            <td><input type="submit" name="operator" value="CE"/></td>
            <td><input type="submit" name="operator" value="C"/></td>
            <td><input type="submit" name="operator" value="BS"/></td>
            <td><input type="submit" name="operator" value="÷"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="value" value="7"/></td>
            <td><input type="submit" name="value" value="8"/></td>
            <td><input type="submit" name="value" value="9"/></td>
            <td><input type="submit" name="operator" value="×"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="value" value="4"/></td>
            <td><input type="submit" name="value" value="5"/></td>
            <td><input type="submit" name="value" value="6"/></td>
            <td><input type="submit" name="operator" value="-"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="value" value="1"/></td>
            <td><input type="submit" name="value" value="2"/></td>
            <td><input type="submit" name="value" value="3"/></td>
            <td><input type="submit" name="operator" value="+"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="value" value="0"/></td>
            <td><input type="submit" name="dot" value="."/></td>
            <td><input type="submit" name="operator" value="="/></td>
        </tr>
    </table>
    <div>
                결과:0
                </div>

</form>
</body>
</html>


}

