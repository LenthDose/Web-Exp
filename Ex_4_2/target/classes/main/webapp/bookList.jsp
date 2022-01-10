<%--
  Created by IntelliJ IDEA.
  User: Silhouette76
  Date: 2021/11/14
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="pojo.Book" %>
<%@ page import="java.util.Map" %>
<jsp:useBean id="bookDB" class="beans.BookDB" />
<%
    HashMap<String, Book> books = bookDB.selectBook();
%>
<head>
  <title>叮当图书网</title>
  <link type="text/css" href="bookList.css" rel="stylesheet" />
</head>

<body>
<%
    if (books == null || books.size() == 0){
%>
    <div>没有商品可显示！</div>
<%
    }
    else {
%>
    <div>
        <ul>
            <%
                Book book;
                for (Map.Entry<String,Book>entry:books.entrySet()){
                    book = entry.getValue();
            %>
            <li>
                <a class="pic" href="" target="_blank">
                    <img src="images\<%=book.getBookCover() %>" />
                </a>
                <div class="desc">
                    <p>
                        <a href="" target="_blank"> <%=book.getBookName() %></a>
                    </p>
                    <p>
                        <span>现价：&yen;<%=book.getNowPrice() %></span>
                        <span
                            class="price">&nbsp;&nbsp;定价：
                            <span>&yen;<%=book.getOrgPrice() %></span>
                        </span>
                    </p>
                    <p>
                        <span class="star"></span>
                        <a href="" target="_blank">
                            <%=book.getComments() %>条评论
                        </a>
                    </p>
                    <p>
                        <span>
                            <a href=""><%=book.getAuthor() %></a>&nbsp;著
                        </span>
                        <span> /<%=book.getPressDate() %></span>
                        <span> /<a href=""><%=book.getPress() %></a></span>
                    </p>
                    <p class="detail"></p>
                    <div>
                        <p>
                            <a class="bn" href="doCar.jsp?action=buy&bookNo=<%=book.getBookNo() %>">加入购物车</a>
                            <a class="bn" href="bookAlter.jsp?action=alter&bookNo=<%=book.getBookNo() %>">修改</a>
                        </p>
                    </div>
                </div></li>
            <%
                }
            %>
        </ul>
    </div>
<%
    }
%>
</body>