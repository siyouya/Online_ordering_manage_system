<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/10/10
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <table>
    <form action="/login" method="post">
      用户名:
      <input type="text" name="username">
      <select name="typename">
        <option value="customer">顾客</option>
        <option value="store">商家</option>
        <option typeof="rider">骑手</option>
      </select><br/>
      密码：
      <input type="password" name="password">
      <br/>
      <input type="submit" value="提交">
    </form>
  </table>
  <a href="register.jsp">注册</a>


  </body>
</html>
