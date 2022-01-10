<%--
  Created by IntelliJ IDEA.
  User: Silhouette76
  Date: 2021/11/14
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="pojo.User" />
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<div>欢迎
    <%
        session.getAttribute("username");
    %>
</div>
使用本系统！<br>
</body>
</html>
