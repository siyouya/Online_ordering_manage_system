<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
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
  <title>登录</title>
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <link rel="stylesheet" type="text/css" href="css/body.css"/>
  <script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
  <script src="js/jquery.fancyspinbox.js"></script>
</head>



<script>










</script>
<body>

<c:if test="${not empty  msg}">
  <script type="text/javascript">
    alert("${msg}");
  </script>
</c:if>

<div class="container">
  <section id="content">
    <form action="/login/login" method="post" onsubmit="return check()">
      <h1>登录</h1>
      <div>
        <select class="my-menu" id="test" name="profession" >
          <option value="customer">顾客</option>
          <option value="store">商家</option>
          <option value="rider">骑手</option>
        </select>
      </div><br/>
      <div>
        <input type="text" placeholder="用户名" required="" id="username" name="username" />
      </div>
      <div>
        <input type="password" placeholder="密码" required="" id="password" name="password" />
      </div>
      <div class="">
        <span class="help-block u-errormessage" >&nbsp;</span>			</div>
      <div>
        <!-- <input type="submit" value="Log in" /> -->
        <input type="submit" value="登录" class="btn btn-primary" id="js-btn-login"/>
        <a href="#">忘记密码?</a>
        <!-- <a href="#">Register</a> -->
      </div>
    </form><!-- form -->
    <div class="button">
      <span class="help-block u-errormessage" >&nbsp;</span>
      <a href="register.jsp">注册</a>
    </div> <!-- button -->
  </section><!-- content -->
</div>
<!-- container -->


<br><br><br><br>
<div style="text-align:center;">
</div>

<script>
  $('.my-menu').fancyspinbox();
</script>

</body>
</html>
