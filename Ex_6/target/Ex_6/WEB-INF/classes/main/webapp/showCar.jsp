<%--
  Created by IntelliJ IDEA.
  User: Silhouette76
  Date: 2021/11/19
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,pojo.Book"%>
<jsp:useBean id="myCar" class="util.ShopCar" scope="session" />
<%
  HashMap<String, Book> bookCar = myCar.getBuylist();
%>
<head>
  <title>叮当图书网-查看购物车</title>
  <link type="text/css" href="./css/myCar.css" rel="stylesheet"/>

</head>
<body>
    <div id="content">
      <form action="DoCarServlet" method="post" name="myform">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="title" width="60">
              <input id="allCheckBox" type="checkbox" onclick="selectAll()"/>全选
            </td>
            <td class="title" colspan="2">书籍名称</td>
            <td class="title" width="80">单价(元)</td>
            <td class="title" width="80">数量</td>
            <td class="title" width="100">小计(元)</td>
            <td class="title" width="60">操作</td>
          </tr>
            <% if (bookCar == null || bookCar.size() == 0) { %>
          <tr height="100"> <td colspan="7" align="center">没有商品可显示！</td>
          </tr>
<%
    } else {
      Book book;
      for (HashMap.Entry<String, Book> entry : bookCar.entrySet()){ book=(Book)entry.getValue();
%>
          <tr>
            <td class="cart_td_1">
              <input name="carCheckBox" type="checkbox" value=
                    "<%=entry.getKey()%>" onclick="selectSingle()" />
            </td>
            <td class="cart_td_2"> <img src="images/<%=book.getBookCover()%>" alt=
                "<%=book.getBookCover()%>"/>
            </td>
            <td class="cart_td_3">
                <a href="#"><%=book.getBookName()%></a>
            </td>
            <td class="cart_td_4"><%=book.getNowPrice()%></td>
            <td class="cart_td_5">
              <a href="DoCarServlet?action=minus&bookNo=<%=entry.getKey()%>"><img src="images/minus.jpg" class="hand" /></a>
              <input name="num" value= "<%=book.getBuyNum()%>" class="num_input" readonly="readonly" />
              <a href="DoCarServlet?action=add&bookNo=<%=entry.getKey()%>"><img src="images/add.jpg" class="hand" /></a>
            </td>
            <td class="cart_td_6" ></td>
            <td class="cart_td_7">
              <a href="DoCarServlet?action=removeone&bookNo=<%=entry.getKey()%>">删除</a>
            </td>
        </tr>
          <%  }
            }
          %>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td bgcolor=white>
              <input type="submit" name="action" class="bn" value="批量删除" />
            </td>
            <td class="shopend"><br />商品总价（不含运费）：
              <label id="total" class="yellow"></label> 
              <br /><br />
              <input type="submit" name="action" class="bn" value="立刻购买" />
           </tr>
        </table>
      </form>
    </div>
</body>
