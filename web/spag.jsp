<%--
  Created by IntelliJ IDEA.
  User: psj
  Date: 2021-05-24
  Time: 오전 12:42
  To change this template use File | Settings | File Templates.
--%>
<%

%>

<%@ page contentType="text/html;charset=UTF-8" language="java"

%>

<!------------------------------------------------------------------>

<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("result", "hello"); //페이지 객체
%>
<body>
${requestScope.result}입니다.<br>
${names[0]}입니다.<br>
${notice.title}<br>
${result}<br>
${param.n ge 3}<br>
${empty param.n? '값이 비어있습니다.':param.n}<br>
${header.accept}
</body>
</html>
</%--
Created by IntelliJ IDEA.
User: psj
Date: 2021-05-24
Time: 오전 12:42
To change this template use File | Settings | File Templates.
--%>
<%

%>

<%@ page contentType="text/html;charset=UTF-8" language="java"

%>

<!------------------------------------------------------------------>

<html>
<head>
    <title>Title</title>
</head>
    <%
    pageContext.setAttribute("result", "hello"); //페이지 객체
%>
<body>
${requestScope.result}입니다.<br>
${names[0]}입니다.<br>
${notice.title}<br>
${result}<br>
${param.n ge 3}<br>
${empty param.n? '값이 비어있습니다.':param.n}>