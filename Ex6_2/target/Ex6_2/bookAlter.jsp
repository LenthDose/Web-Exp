<%--
  Created by IntelliJ IDEA.
  User: Silhouette76
  Date: 2021/11/14
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<%@ page import="pojo.Book" %>
<jsp:useBean id="bookDB" class="beans.BookDB" />
<html >
<head>
    <title>修改图书界面</title>
    <link type="text/css" href="css/bookAdd.css" rel="stylesheet" />
</head>
<body>
<%
    String bookNo = request.getParameter("bookNo");
    Book book = bookDB.selectBook(bookNo);
%>
<div class="register">
    <h2 align="center">修改图书</h2>
    <div class="content">

        <form name="frm2" action="doBookAlter.jsp" method="post" >
            <div class="box">
                <label class="i-label">*图书号</label>
                <input type="text" name="bookNo" class="i-text" value="<%=book.getBookNo() %>" readonly="readonly"/>
            </div>
            <div class="box">
                <label class="i-label">*书名</label>
                <input type="text" name="bookName" class="i-text" value="<%=book.getBookName() %>"/>
            </div>
            <div class="box">
                <label class="i-label">作者</label>
                <input type="text" name="author" class="i-text" value="<%=book.getAuthor() %>"/>
            </div>
            <div class="box">
                <label class="i-label">出版社</label>
                <select name="press" size="1" class="i-text" style="height:34px;" value="<%=book.getPress() %>">

                    <option value="清华大学出版社" >清华大学出版社</option>
                    <option value="人民邮电出版社" >人民邮电出版社</option>
                </select>
            </div>
            <div class="box">
                <label class="i-label">出版日期</label>
                <input type="date" name="pressDate" class="i-text" value="<%=book.getPressDate() %>">
            </div>
            <div class="box">
                <label class="i-label">*库存</label>
                <input type="text" name="bookNum" class="i-text" value="<%=book.getBookNum() %>"/>
            </div>
            <div class="box">
                <label class="i-label">*原价</label>
                <input type="text" name="orgPrice" class="i-text" value="<%=book.getOrgPrice() %>"/>
            </div>
            <div class="box">
                <label class="i-label">现价</label>
                <input type="text" name="nowPrice" class="i-text" value="<%=book.getNowPrice() %>"/>
            </div>
            <div class="box">
                <label class="i-label">封面</label>
                <input type="file" name="bookCover" class="i-text" value="<%=book.getBookCover() %>"/>

            </div>
            <div class="btns">
                 <span class="i-text">
                 <input type="submit" value="确 定">&nbsp;&nbsp;&nbsp;&nbsp;
                 <input type="reset" value="清 除">
                 </span>
            </div>
        </form>
    </div>
</div>
</body>
</html>
