<%--
  Created by IntelliJ IDEA.
  User: Silhouette76
  Date: 2021/11/14
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
         import="java.sql.*"%>
<%--<%--%>
<%--  request.setCharacterEncoding("utf-8");--%>
<%--  String username=request.getParameter("username");--%>

<%--  String password=request.getParameter("password");--%>

<%--  String[] sex=request.getParameterValues("sex");--%>
<%--  String sex1="";--%>
<%--  if(sex!=null){--%>
<%--    for(int i=0;i<sex.length;i++) {--%>
<%--      sex1 = sex[i];--%>
<%--    }--%>
<%--  }--%>
<%--  String birthday=request.getParameter("birthday");--%>
<%--  String email=request.getParameter("email");--%>
<%--  String selProvince=request.getParameter("selProvince");--%>
<%--  String selCity=request.getParameter("selCity");--%>
<%--  String profession=request.getParameter("profession");--%>
<%--  String[] hobbies=request.getParameterValues("hobbies");--%>
<%--  String strlike="";--%>
<%--  if(hobbies!=null){--%>
<%--    for(int i=0;i<hobbies.length;i++){--%>
<%--      strlike=strlike+","+hobbies[i].toString()+" ";--%>
<%--    }--%>
<%--  }--%>
<%--  if(!strlike.equals("")){--%>
<%--    strlike=strlike.substring(1,strlike.trim().length());--%>
<%--  }--%>
<%--  String de=request.getParameter("introduction");--%>
<%--  Class.forName("com.mysql.cj.jdbc.Driver");--%>
<%--  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booklib?useSSL=true&serverTimezone=UTC", "root","123456");--%>
<%--  String sql = "insert into user values(?,?,?,?,?,?,?,?,?)";--%>
<%--  PreparedStatement pstmt = con.prepareStatement(sql);--%>
<%--  pstmt.setString(1, username);--%>
<%--  pstmt.setString(2, password);--%>
<%--  pstmt.setString(3, sex1);--%>
<%--  pstmt.setString(4, birthday);--%>
<%--  pstmt.setString(5, email);--%>
<%--  pstmt.setString(6, selProvince+selCity);--%>
<%--  pstmt.setString(7, profession);--%>
<%--  pstmt.setString(8, strlike);--%>
<%--  pstmt.setString(9, de);--%>
<%--  int result = pstmt.executeUpdate();--%>
<%--  pstmt.close();--%>
<%--  con.close();--%>
<%--  if (result == 1) {--%>
<%--    response.setHeader("Refresh", "1;url=showall.jsp");--%>
<%--  }else--%>
<%--  {--%>
<%--    out.println("<script>alert('???????????????????????????????????????');history.go(-1);</script>");--%>
<%--  }--%>

<%--  session.setAttribute("username",username);--%>
<%--  session.setAttribute("password",password);--%>
<%--  session.setAttribute("sex",sex1);--%>
<%--  session.setAttribute("birthday",birthday);--%>
<%--  session.setAttribute("email",email);--%>
<%--  session.setAttribute("selProvince",selProvince);--%>
<%--  session.setAttribute("selCity",selCity);--%>
<%--  session.setAttribute("profession",profession);--%>
<%--  session.setAttribute("hobbies",strlike);--%>
<%--  session.setAttribute("introduction",de);--%>


<%--%>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>????????????????????????</title>--%>
<%--    <style type="text/css">--%>
<%--        div{--%>
<%--            width: 418px;--%>
<%--            height: 240px;--%>
<%--            margin: 0px auto;--%>
<%--            overflow: hidden;--%>
<%--            padding-top: 10px;--%>
<%--            padding-left: 20px;--%>
<%--            border: solid 1px #000;--%>
<%--            margin: 0px auto;--%>
<%--        }--%>
<%--        </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div>--%>
<%--    ????????????<%= (String)session.getAttribute("username")%>--%>
<%--    <br>--%>
<%--    ?????????<%= (String)session.getAttribute("password")%>--%>
<%--    <br>--%>
<%--    ?????????<%= (String)session.getAttribute("sex")%>--%>
<%--    <br>--%>
<%--    ???????????????<%= (String)session.getAttribute("birthday")%>--%>
<%--    <br>--%>
<%--    ?????????<%= (String)session.getAttribute("email")%>--%>
<%--    <br>--%>
<%--    ???????????????<%= (String)session.getAttribute("selProvince")%>--%>
<%--    <%= (String)session.getAttribute("selCity")%>--%>
<%--    <br>--%>
<%--    ?????????<%= (String)session.getAttribute("profession")%>--%>
<%--    <br>--%>
<%--    ???????????????<%= (String)session.getAttribute("hobbies")%>--%>
<%--    <br>--%>
<%--    ???????????????<%= (String)session.getAttribute("introduction")%>--%>
<%--    <br>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

<%
  request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="myRegister" class="pojo.User" />
<jsp:setProperty name="myRegister" property="*" />

<body>
<h2>?????????????????????</h2>
<hr>
<jsp:getProperty name="myRegister" property="username" />
<br>
<jsp:getProperty name="myRegister" property="userpwd"/>
<br>
<jsp:getProperty name="myRegister" property="sex"/>
<br>
<jsp:getProperty name="myRegister" property="birthday"/>
<br>
<jsp:getProperty name="myRegister" property="mail"/>
<br>
<jsp:getProperty name="myRegister" property="work"/>
<br>

<%
  String[] like = request.getParameterValues("like");
  if (like != null){
    for (String s : like) {
      out.println(s);
    }
  }
%>

<br>
<jsp:getProperty name="myRegister" property="intro"/>
<br>
</body>