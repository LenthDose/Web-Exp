<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Silhouette76
  Date: 2021/11/14
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登录失败</title>
    <meta http-equiv="refresh" content="10;url=login.jsp">
</head>
<body>
<div>对不起，
    <%=session.getAttribute("username")%>
</div>
请您确认用户名和密码！
</body>