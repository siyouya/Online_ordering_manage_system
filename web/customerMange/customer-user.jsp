<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page import="com.etc.entity.Store" %>
<%@ page import="java.util.List" %>
<%@ page import="com.etc.entity.Customer" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + path + "/";

%>

<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>个人中心</title>
  <meta name="description" content="这是一个 user 页面">
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
  <script src="/customerMange/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
  <script>

    function check(){
      if($('span').is('.wrong')){
        alert("请填写正确信息");
        return false;
      }else{
        return true;
      }

    }

    $(function () {

      var regex = /^[a-zA-Z0-9\u4e00-\u9fa5]{2,12}$/;

      var tpatten = /^1[34578]\d{9}$/;
      var rname= /^[\u4e00-\u9fa5]{2,12}$/;



      // var text;  // 全局变量用于保存文本框的内容
      // $("input:text").focus(function() {
      //     text = $(this).val();
      //     $(this).val("");
      // });
      // $("input:text").blur(function() {
      //     $(this).val()!="" || $(this).val(text);
      // });


      $('.username','.telephone','.realname').on('focus',function(){

        $(this).siblings('span').removeClass('right');
        $(this).siblings('span').removeClass('wrong');



      });




      $('.username').on('blur', function () {
        var usernameVal = $(this).val();
        if (regex.test(usernameVal)) {
          $(this).siblings('span').removeClass('wrong');
          $(this).siblings('span').addClass('right');
          $(this).siblings('span').html('');
        } else if(usernameVal.length<4){
          $(this).siblings('span').addClass('wrong');
          $(this).siblings('span').html('用户名应为4-10位');

        }else{
          $(this).siblings('span').addClass('wrong');
          $(this).siblings('span').html('用户名不能包含特殊字符');
        }
      });



      $('.telephone').on('blur', function () {
        var telephoneVal = $(this).val();
        if (tpatten.test(telephoneVal)) {
          $(this).siblings('span').removeClass('wrong');
          $(this).siblings('span').addClass('right');
          $(this).siblings('span').html('');
        } else{
          $(this).siblings('span').addClass('wrong');
          $(this).siblings('span').html('请输入有效的手机号');
        }
      });

      $('.realname').on('blur', function () {
        var rnameVal = $(this).val();
        if (rname.test(rnameVal)) {
          $(this).siblings('span').removeClass('wrong');
          $(this).siblings('span').addClass('right');
          $(this).siblings('span').html('');
        } else{
          $(this).siblings('span').addClass('wrong');
          $(this).siblings('span').html('请输入真实姓名');
        }
      });


      <%--$("#username").blur(function() {--%>

      <%--  $.post("/user?op=ajaxCheckName", "username=" + this.value, function(data) {--%>

      <%--    if ($("#username").val()==${user}) {--%>
      <%--      console.log("${user}");--%>
      <%--    }else if (data == "true") {--%>
      <%--        console.log("false");--%>
      <%--      $("#show").addClass('wrong');--%>
      <%--       $("#show")[0].innerHTML = "该用户名已存在，请重新输入！";--%>
      <%--    } else {--%>
      <%--      console.log("true");--%>
      <%--      $("#show").removeClass('wrong');--%>


      <%--      $("#show")[0].innerHTML = "";--%>

      <%--    }--%>

      <%--  });--%>

      <%--});--%>

    });
  </script>
  <style type="text/css">
    span {
      color: #aaa;
      font-size: 10px;



    }

    .right {
      color: green;


    }

    .wrong {
      color: red;

    }
  </style>


</head>
<body>









<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong>${user}</strong> <small>的个人中心</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar">
    <ul class="am-list admin-sidebar-list">
      <li><a href="customer-index.jsp"><span class="am-icon-home"></span> 首页</a></li>
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 页面模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="/user?op=query" class="am-cf"><span class="am-icon-check"></span>个人资料<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="/user?op=modify"><span class="am-icon-puzzle-piece"></span>修改密码</a></li>
        </ul>
      </li>
      <li><a href="/order?op=selbycustomer"><span class="am-icon-table"></span>订单查询</a></li>
      <li><a href="/homepage/index.jsp"><span class="am-icon-table"></span>返回主页</a></li>
      <li><a href="/login.jsp"><span class="am-icon-sign-out"></span> 注销</a></li>
    </ul>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-bookmark"></span> 公告</p>
        <p>时光静好，与君语；细水流年，与君同。—— Amaze UI</p>
      </div>
    </div>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-tag"></span> wiki</p>
        <p>Welcome to the Amaze UI wiki!</p>
      </div>
    </div>
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人资料</strong> / <small>Personal information</small></div>
    </div>

    <hr/>

    <div class="am-g">

      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        <div class="am-panel am-panel-default">
          <div class="am-panel-bd">
            <div class="am-g">
              <div class="am-u-md-4">
                <img class="am-img-circle am-img-thumbnail" src="http://amui.qiniudn.com/bw-2014-06-19.jpg?imageView/1/w/1000/h/1000/q/80" alt=""/>
              </div>
              <div class="am-u-md-8">
                <p>你可以使用<a href="#">gravatar.com</a>提供的头像或者使用本地上传头像。 </p>
                <form class="am-form">
                  <div class="am-form-group">
                    <input type="file" id="user-pic">
                    <p class="am-form-help">请选择要上传的文件...</p>
                    <button type="button" class="am-btn am-btn-primary am-btn-xs">保存</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

        <div class="am-panel am-panel-default">
          <div class="am-panel-bd">
            <div class="user-info">
              <p>等级信息</p>
              <div class="am-progress am-progress-sm">
                <div class="am-progress-bar" style="width: 60%"></div>
              </div>
              <p class="user-info-order">当前等级：<strong>LV8</strong> 活跃天数：<strong>587</strong> 距离下一级别：<strong>160</strong></p>
            </div>
            <div class="user-info">
              <p>信用信息</p>
              <div class="am-progress am-progress-sm">
                <div class="am-progress-bar am-progress-bar-success" style="width: 80%"></div>
              </div>
              <p class="user-info-order">信用等级：正常当前 信用积分：<strong>80</strong></p>
            </div>
          </div>
        </div>

      </div>

      <c:if test="${!empty message}">
        <%--            <h1>${message}</h1>--%>
        <script type="text/javascript">
          alert("${message}");
        </script>

        <%session.setAttribute("message",""); %>


      </c:if>

      <% List<Customer> list= (List<Customer>) session.getAttribute("list");
        for(Customer customer:list){

      %>


      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <form class="am-form am-form-horizontal" action="/user" method="get" onsubmit="return check()" >
          <div class="am-form-group">
            <label  class="am-u-sm-3 am-form-label">名称</label>
            <div class="am-u-sm-9">
              <input type="text" id="username" placeholder="名称/Name" name="username" class="username" maxlength="10" readonly="true"  value="<%=customer.getUsername() %>">
              <span ></span>
              <div><span id="show" ></span></div>

            </div>
          </div>

          <div class="am-form-group">
            <label  class="am-u-sm-3 am-form-label">真实姓名</label>
            <div class="am-u-sm-9">
              <input type="text" id="realname" placeholder="请输入真实姓名" name="realname" class="realname" maxlength="10" value="<%=customer.getRealname() %>">
              <br><span></span>
            </div>
          </div>

          <div class="am-form-group">
            <label class="am-u-sm-3 am-form-label">电话 / Telephone</label>
            <div class="am-u-sm-9">
              <input type="tel" id="telephone" placeholder="输入你的电话号码 / Telephone" name="telephone"  class="telephone" value="<%=customer.getTelepone()%>">
              <br><span></span>
            </div>
          </div>

          <div class="am-form-group">
            <label class="am-u-sm-3 am-form-label">地址</label>
            <div class="am-u-sm-9">
              <input type="text" id="address" placeholder="输入你的地址" name="address" class="address" value="<%=customer.getAddress()%>">
              <br><span></span>
            </div>
          </div>


          <% }%>
          <div class="am-form-group">
            <div class="am-u-sm-9 am-u-sm-push-3">
              <!-- <button type="button" class="am-btn am-btn-primary">保存修改</button> -->
              <input type="hidden" class="am-btn am-btn-primary" name="op" value="update" />
              <input type="submit" class="am-btn am-btn-primary" value="保存修改" />
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
  <!-- content end -->

</div>

<footer>
  <hr>
  <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="assets/js/app.js"></script>
</body>
</html>