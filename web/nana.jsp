<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: psj
  Date: 2021-05-23
  Time: 오후 11:56
  To change this template use File | Settings | File Templates.
--%>
<%

    String cnt_ = request.getParameter("cnt");

    int cnt = 100;
    if (cnt_ != null && !cnt_.equals("")) {
        cnt = Integer.parseInt(cnt_);
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%for (int i = 0; i < cnt; i++) {%>
안녕 Servlet!!<br>
<%}%>
</body>
</html>
