<%--
  Created by IntelliJ IDEA.
  User: Silhouette76
  Date: 2021/11/19
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%> <%@ page import="java.util.*"%> <%@ page import="pojo.Book"%>
<%
        request.setCharacterEncoding("UTF-8");
        HashMap<String, Book> bookCar = (HashMap<String, Book>)
            session.getAttribute("bookCar");
        if (bookCar == null) {
            bookCar = new HashMap<String, Book>();
    }
        HashMap<String, Book> books = (HashMap<String, Book>) session.getAttribute("books");
        String action = request.getParameter("action"); if (action == null)
        action = "";

    switch (action) {
        case "buy": {
            String bookNo = request.getParameter("bookNo");
            Book temp = (Book) bookCar.get(bookNo);
            if (temp == null) {
                temp = (Book) books.get(bookNo);
                temp.setBuyNum(1);
                bookCar.put(bookNo, temp);
            } else {
                temp.setBuyNum(temp.getBuyNum() + 1);
                bookCar.put(bookNo, temp);
            }
            session.setAttribute("bookCar", bookCar);
            response.sendRedirect("bookList.jsp");
            break;
        }
        case "removeone": {
            String bookNo = request.getParameter("bookNo");
            bookCar.remove(bookNo);
            session.setAttribute("bookCar", bookCar);
            response.sendRedirect("showCar.jsp");
            break;
        }
        case "批量删除":
            String[] bookNos = request.getParameterValues("carCheckBox");
            //…… response.sendRedirect("showCar.jsp");
            break;
        default:
            response.sendRedirect("showCar.jsp");
            break;
    }
    %>