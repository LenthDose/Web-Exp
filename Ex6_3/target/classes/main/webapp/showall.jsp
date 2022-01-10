<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %><%--
  Created by IntelliJ IDEA.
  User: Silhouette76
  Date: 2021/11/14
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册名单</title>
</head>
<body>
<h2 align="center">注册名单</h2>
<%
    String username = request.getParameter("username");
    if (username == null) {
        username = "";
    }
%>
<div align="center">
    <form method="get" action="search.jsp">
        按用户名查询：<input name="username" value=<%= username %>> <input
            type="submit" value="查询">
    </form>
</div>
<table align="center" border="1" width="50%" >
    <tr><th>用户名</th><th>密码</th><th>确认密码</th><th>性别</th><th>出生日期</th><th>邮箱</th><th>职业</th><th>个人爱好</th><th>个人说明</th></tr>
    <%
        Class.forName("com.mysql.cj.jdbc.Driver");
        String mysqlURL="jdbc:mysql://localhost:3306/booklib?useSSL=true&characterEncoding=UTF-8";
        Connection con= DriverManager.getConnection(mysqlURL,"root","123456");
//        request.setCharacterEncoding("UTF-8");
        String sql="select * from user";
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
//            int id=rs.getInt(1);
    %>
    <tr><td><%=rs.getString("userName") %></td>
        <td><%=rs.getString("userPwd") %></td>
        <%--        <td><%=rs.getString("password1") %></td>--%>
        <td><%=rs.getString("sex") %></td>
        <td><%=rs.getString("birthday") %></td>
        <td><%=rs.getString("mail") %></td>
        <td><%=rs.getString("address") %></td>
        <td><%=rs.getString("work") %></td>
        <td><%=rs.getString("likes") %></td>
        <td><%=rs.getString("intro") %></td>
    </tr>
    <%
        }
        rs.close();
        stmt.close();
        con.close();
    %>

</table>

</body>
</html>
