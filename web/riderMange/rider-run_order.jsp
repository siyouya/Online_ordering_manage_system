<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.etc.entity.OrderRider" %>
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
  <title>Amaze后台管理系统模板HTML 表格页面 - cssmoban</title>
  <meta name="description" content="这是一个 table 页面">
  <meta name="keywords" content="table">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="/storeMange/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="/storeMange/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="/storeMange/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="/storeMange/assets/css/admin.css">
  <!-- 新 Bootstrap4 核心 CSS 文件 -->
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">


</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong>Amaze</strong> <small>后台管理模板</small>
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
<script type="text/javascript">
  function recorder(id) {

    if (confirm("确认完成订单")) {
      document.getElementById('op').value = "com_order";
      document.getElementById('roid').value = id;
      var form1 = document.getElementById('oid');

      form1.action = "/order";
      form1.submit();
    }
  }

  function chat(id) {

    if (confirm("联系")) {
      document.getElementById('op').value = "rider_create_chat";
      document.getElementById('roid').value = id;
      var form2 = document.getElementById('oid');
      form2.action = "/creatweb";
      form2.submit();
    }
  }

</script>
<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar">
    <ul class="am-list admin-sidebar-list">
      <li><a href="rider-index.jsp"><span class="am-icon-home"></span> 首页</a></li>
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 页面模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="/rider?op=query" class="am-cf"><span class="am-icon-check"></span> 个人资料<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="/rider?op=modifypas"><span class="am-icon-puzzle-piece"></span>修改密码</a></li>
        </ul>
      </li>
      <li><a href="/order?op=recorder"><span class="am-icon-table"></span> 接单</a></li>
      <li><a href="/order?op=run_order"><span class="am-icon-pencil-square-o"></span> 跑单</a></li>
      <li><a href="/login.jsp"><span class="am-icon-sign-out"></span> 注销</a></li>
    </ul>
    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-bookmark"></span> 公告</p>
        <p>时光静好，与君语；细水流年，与君同。—— Amaze</p>
      </div>
    </div>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-tag"></span> wiki</p>
        <p>Welcome to the Amaze</p>
      </div>
    </div>
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">菜品列表</strong> / <small>Menu</small></div>
    </div>

    <div class="am-g">
      <div class="am-u-md-6 am-cf">
        <div class="am-fl am-cf">
          <div class="am-btn-toolbar am-fl">
            <div class="am-btn-group am-btn-group-xs">
              <button type="button" class="am-btn am-btn-default"  data-toggle="modal" data-target="#myModal"><span class="am-icon-plus"></span> 新增</button>

              <button type="button" class="am-btn am-btn-default" onclick="mutildel()"><span class="am-icon-trash-o"></span> 删除</button>
            </div>


          </div>
        </div>
      </div>
      <div class="am-u-md-3 am-cf">
        <div class="am-fr">
          <div class="am-input-group am-input-group-sm">
            <input type="text" class="am-form-field">
            <span class="am-input-group-btn">
                  <button class="am-btn am-btn-default" type="button">搜索</button>
                </span>
          </div>
        </div>
      </div>
    </div>

    <div class="am-g">
      <div class="am-u-sm-12">
        <form class="am-form" id="oid" >
          <input type="text"  class="am-hide" id="roid" name="roid">
          <input type="text"  class="am-hide" id="editid">
          <input type="text"  class="am-hide" id="did">
          <input type="text"  class="am-hide" id="op" name="op">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
            <tr>
              <th class="table-check">
              <th class="table-title">订单编号</th>
              <th class="table-title">商家店名</th>
              <th class="table-title">商家地址</th>
              <th class="table-text">用户地址</th>
              <th class="table-date">用户电话</th>
              <th class="table-set">操作</th>
            </tr>
            </thead>
            <tbody>


             <c:forEach items="${list}" var="orderRider">
             <tr id="tr${orderRider.oid}">
              <td><input type="checkbox" class="checkb" id="id" value="${orderRider.oid}"/></td>
              <td>${orderRider.oid}</td>
              <td>${orderRider.sid.shopname}</td>
              <td>${orderRider.sid.address}</td>
              <td>${orderRider.cid.address}</td>
              <td>${orderRider.sid.telephone}</td>
              <td>
                <div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">

                    <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger" onclick="recorder(${orderRider.oid})"><span class="am-icon-trash-o"></span>完成</button>
                    <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger" onclick="chat(${orderRider.oid})"><span class="am-icon-trash-o"></span>联系</button>
                  </div>

                </div>
              </td>
            </tr>
             </c:forEach>


            </tbody>
          </table>
          <div class="am-cf">
            共 15 条记录
            <div class="am-fr">
              <ul class="am-pagination">
                <li class="am-disabled"><a href="#">«</a></li>
                <li class="am-active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">»</a></li>
              </ul>
            </div>
          </div>
          <hr />
          <p>注：.....</p>
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
<script src="../assets/js/polyfill/rem.min.js"></script>
<script src="../assets/js/polyfill/respond.min.js"></script>
<script src="../assets/js/amazeui.legacy.js"></script>

<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="../css/assets/js/jquery.min.js"></script>
<script src="../css/assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="../css/assets/js/app.js"></script>
</body>
</html>