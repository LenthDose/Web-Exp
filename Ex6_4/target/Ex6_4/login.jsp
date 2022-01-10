<%--
  Created by IntelliJ IDEA.
  User: Silhouette76
  Date: 2021/11/14
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>登录</title>
    <link type="text/css" href="login.css" rel="stylesheet" />
    <script type="text/javascript">
        function change() {
            document.getElementById("validate").src =
                "ValidateServlet?random=" + Math.random();
        }
    </script>
</head>
<body>
<div class="login">
    <h2>用户登录</h2>
    <div class="content">
        <form name="frm1" action="doLogin.jsp" method="post">
            <div class="frm">
                用户名： <input type="text" name="username" class="txtuser" />
            </div>
            <div class="frm">
                密 码： <input type="password" name="password" class="txtpwd" />
            </div>
            <div class="frm">
                验证码： <input type="text" name="userVCode" class="textVcode" />
                <span>
              <img src="ValidateServlet" id="validate" onclick="change()" />
              <a href="javascript:change()">看不清，换一张</a>
            </span>
            </div>
            <div class="btns">
                <input type="submit" name="login" class="btnlogin" value="" />
                <input
                        type="button"
                        name="register"
                        class="btnregister"
                        onclick="window.open('register.html')"
                />
            </div>
        </form>
    </div>
</div>
</body>
</html>
