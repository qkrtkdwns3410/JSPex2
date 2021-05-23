<%--
  Created by IntelliJ IDEA.
  User: psj
  Date: 2021-05-24
  Time: 오전 12:42
  To change this template use File | Settings | File Templates.
--%>
<%
    int num = 0;
    String num_ = request.getParameter("n");
    if (num_ != null && !num_.equals("")) {
        num = Integer.parseInt(num_);
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java"

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% if (num % 2 != 0) {%>
홀수입니다.

<%
} else {
%>
짝수입니다.
<%} %>

</body>
</html>
