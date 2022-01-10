<%--
  Created by IntelliJ IDEA.
  User: Silhouette76
  Date: 2021/11/14
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="book" class="pojo.Book"/>
<jsp:setProperty name="book" property="*" />
<jsp:useBean id="bookDB" class="beans.BookDB" />
<%
    int result = bookDB.updateBook(book);
    if (result==1) {
        response.sendRedirect("bookList.jsp");
    } else {
        out.println("<script>alert('输入信息有误，请再次确认！');history.go(-1);</script>");
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
</body>