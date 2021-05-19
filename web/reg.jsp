<%--
  Created by IntelliJ IDEA.
  User: psj
  Date: 2021-05-19
  Time: 오후 6:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="notice-reg" method="post">
        <div>
            <label>제목:</label><input name="title" type="text" >
        </div>
        <div>
            <label>내용:</label>
            <textarea name="content"></textarea>
        </div>
        <div>
            <input type="submit" value="등록"/>
        </div>
    </form>
</div>

</body>
</html>
