<%--
  Created by IntelliJ IDEA.
  User: Silhouette76
  Date: 2021/11/14
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%--<%--%>
<%--    request.setCharacterEncoding("utf-8");--%>
<%--    String bookNo = request.getParameter("bookNo");--%>
<%--    String bookName = request.getParameter("bookName");--%>
<%--    String author = request.getParameter("author");--%>
<%--    String press = request.getParameter("press");--%>
<%--    String pressDate = request.getParameter("pressDate");--%>
<%--    String bookNum = request.getParameter("bookNum");--%>
<%--    String orgPrice = request.getParameter("orgPrice");--%>
<%--    String nowPrice = request.getParameter("nowPrice");--%>
<%--    String bookCover = request.getParameter("bookCover");--%>
<%--    Class.forName("com.mysql.cj.jdbc.Driver");--%>
<%--    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booklib?useSSL=true&serverTimezone=UTC","root", "123456");--%>
<%--    String sql = "insert into book(bookNo,bookName,author,press,pressDate,bookNum,orgPrice,nowPrice,bookCover) values(?,?,?,?,?,?,?,?,?)";--%>
<%--    PreparedStatement pstmt = con.prepareStatement(sql);--%>
<%--    pstmt.setString(1, bookNo);--%>
<%--    pstmt.setString(2, bookName);--%>
<%--    pstmt.setString(3, author);--%>
<%--    pstmt.setString(4, press);--%>
<%--    pstmt.setString(5, pressDate);--%>
<%--    pstmt.setInt(6, Integer.parseInt(bookNum));--%>
<%--    pstmt.setFloat(7, Float.parseFloat(orgPrice));--%>
<%--    pstmt.setFloat(8, Float.parseFloat(nowPrice));--%>
<%--    pstmt.setString(9, bookCover);--%>
<%--    int result = pstmt.executeUpdate();--%>
<%--    pstmt.close();--%>
<%--    con.close();--%>
<%--    if (result==1) {--%>
<%--        response.sendRedirect("bookList.jsp");--%>
<%--    } else {--%>
<%--        out.println("<script>alert('输入信息有误，请再次确认！');history.go(-1);</script>");--%>
<%--    }--%>
<%--%>--%>

<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="book" class="pojo.Book"/>
<jsp:setProperty name="book" property="*" />
<jsp:useBean id="bookDB" class="beans.BookDB" />
<%

    int result = bookDB.addBook(book);
    if (result == 1){
        response.sendRedirect("bookList.jsp");
    }else {
        out.println("<script>alter('输入信息有误,请再次确认！');history.go(-1);</script>");
    }
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>

