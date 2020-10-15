<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Amaze后台管理系统模板HTML 404页面 - cssmoban </title>
  <meta name="description" content="这是一个404页面">
  <meta name="keywords" content="404">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="/storeMange/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="/storeMange/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="/storeMange/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="/storeMange/assets/css/admin.css">
  <link rel="stylesheet" type="text/css" href="/storeMange/css/qq.css"/>

</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong>Amaze后台管理模板</strong> <small></small>
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
      <li><a href="/storeMange/admin-index.jsp"><span class="am-icon-home"></span> 首页</a></li>
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 页面模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="/store?op=query" class="am-cf"><span class="am-icon-check"></span> 个人资料<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="/store?op=modifypas"><span class="am-icon-puzzle-piece"></span> 修改密码</a></li>
          <li><a href="../storeMange/admin-gallery.jsp"><span class="am-icon-th"></span> 相册页面<span class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>
          <li><a href="../storeMange/admin-404.jsp"><span class="am-icon-bug"></span> 404</a></li>
        </ul>
      </li>
      <li><a href="/dish?op=select"><span class="am-icon-table"></span>菜单</a></li>
      <li><a href="/order?op=selbyshop"><span class="am-icon-pencil-square-o"></span> 订单</a></li>
      <li><a href="/creatweb"><span class="am-icon-pencil-square-o"></span>在线聊天</a></li>
      <li><a href="/login.html"><span class="am-icon-sign-out"></span> 注销</a></li>
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
  <div class="qqBox">
    <div class="BoxHead">
      <div class="headImg">
        <img src="img/6.jpg"/>
      </div>
      <div class="internetName">恒宝</div>
    </div>
    <div class="context">
      <div class="conLeft">
        <ul>
          <li>
            <div class="liLeft"><img src="img/20170926103645_04.jpg"/></div>
            <div class="liRight">
              <span class="intername">前端交流群</span>
              <span class="infor">厉害了</span>
            </div>
          </li>
          <li class="bg">
            <div class="liLeft"><img src="img/20170926103645_19.jpg"/></div>
            <div class="liRight">
              <span  class="intername">赵鹏</span>
              <span class="infor">[流泪]</span>
            </div>
          </li>
          <li>
            <div class="liLeft"><img src="img/20170926103645_27.jpg"/></div>
            <div class="liRight">
              <span  class="intername">web交流群</span>
              <span class="infor">666</span>
            </div>
          </li>

        </ul>
      </div>
      <div class="conRight">
        <div class="Righthead">
          <div class="headName">赵鹏</div>
          <div class="headConfig">
            <ul>
              <li><img src="/storeMange/img/20170926103645_06.jpg"/></li>
              <li><img src="/storeMange/img/20170926103645_08.jpg"/></li>
              <li><img src="/storeMange/img/20170926103645_10.jpg"/></li>
              <li><img src="/storeMange/img/20170926103645_12.jpg"/></li>
            </ul>
          </div>
        </div>
        <div class="RightCont">
          <ul class="newsList">

          </ul>
        </div>
        <div class="RightFoot">
          <div class="emjon">
            <ul>
              <li><img src="/storeMange/img/em_02.jpg"/></li>
              <li><img src="/storeMange/img/em_05.jpg"/></li>
              <li><img src="/storeMange/img/em_07.jpg"/></li>
              <li><img src="/storeMange/img/em_12.jpg"/></li>
              <li><img src="/storeMange/img/em_14.jpg"/></li>
              <li><img src="/storeMange/img/em_16.jpg"/></li>
              <li><img src="/storeMange/img/em_20.jpg"/></li>
              <li><img src="/storeMange/img/em_23.jpg"/></li>
              <li><img src="/storeMange/img/em_25.jpg"/></li>
              <li><img src="/storeMange/img/em_30.jpg"/></li>
              <li><img src="/storeMange/img/em_31.jpg"/></li>
              <li><img src="/storeMange/img/em_33.jpg"/></li>
              <li><img src="/storeMange/img/em_37.jpg"/></li>
              <li><img src="/storeMange/img/em_38.jpg"/></li>
              <li><img src="/storeMange/img/em_40.jpg"/></li>
              <li><img src="/storeMange/img/em_45.jpg"/></li>
              <li><img src="/storeMange/img/em_47.jpg"/></li>
              <li><img src="/storeMange/img/em_48.jpg"/></li>
              <li><img src="/storeMange/img/em_52.jpg"/></li>
              <li><img src="/storeMange/img/em_54.jpg"/></li>
              <li><img src="/storeMange/img/em_55.jpg"/></li>
            </ul>
          </div>
          <div class="footTop">
            <ul>
              <li><img src="/storeMange/img/20170926103645_31.jpg"/></li>
              <li class="ExP"><img src="/storeMange/img/20170926103645_33.jpg"/></li>
              <li><img src="/storeMange/img/20170926103645_35.jpg"/></li>
              <li><img src="/storeMange/img/20170926103645_37.jpg"/></li>
              <li><img src="/storeMange/img/20170926103645_39.jpg"/></li>
              <li><img src="/storeMange/img/20170926103645_41.jpg" alt="" /></li>
              <li><img src="/storeMange/img/20170926103645_43.jpg"/></li>
              <li><img src="/storeMangex/img/20170926103645_45.jpg"/></li>
            </ul>
          </div>
          <div class="inputBox">
            <textarea id="dope" style="width: 99%;height: 75px; border: none;outline: none;" name="" rows="" cols=""></textarea>
            <button class="sendBtn" >发送(s)</button>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script type="text/javascript" src="/storeMange/js/jquery.min.js"></script>
  <script type="text/javascript" src="/storeMange/js/chats.js"></script>
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
<script type="text/javascript">
  var webSocket;

  function send_msg() {

    if (webSocket != null) {
      var dope = document.getElementById("dope").value.trim();
      if (dope == "") {
        return;
      }
      webSocket.send(dope);
      // 清除input框里的信息
      document.getElementById("dope").value = "";
    } else {
      alert("您已掉线，请重新进入聊天室...");
    }
  };

  function closeWs() {
    webSocket.close();
  };

 window.onload= function initWebSocket() {
    // var roomName = document.getElementById("input_roomName").value;
    //订单号作为房间号测试先用1
    var roomName=<%=request.getAttribute("oid")%>;
    // 房间名不能为空
    if (roomName == null || roomName == "") {
      alert("请输入房间名");
      return;
    }
    //var username = document.getElementById("username").value.trim();
    var username='<%=request.getAttribute("ridername")%>';//有3个骑手顾客商家先测试1
    if (username == "" || username==null) {
      alert("用户名不能为空")
      return;
    }
    if ("WebSocket" in window) {
//            alert("您的浏览器支持 WebSocket!");
      if (webSocket == null) {
        var url = "ws://localhost:8080/webSocket/chat/" + roomName+"/"+username;
        // 打开一个 web socket
        webSocket = new WebSocket(url);
      } else {
        alert("您已进入聊天室...");
      }

      webSocket.onopen = function () {
        alert("已进入聊天室，畅聊吧...");
      };

      webSocket.onmessage = function (evt) {
        var msg_board = document.getElementsByClassName("newsList")[0];
        var received_msg = evt.data;
        var old_msg = msg_board.innerHTML;
        msg_board.innerHTML = old_msg + received_msg + "<br>";
        // 让滚动块往下移动
        msg_board.scrollTop = msg_board.scrollTop + 40;

      };

      webSocket.onclose = function () {
        // 关闭 websocket，清空信息板
        alert("连接已关闭...");
        webSocket = null;
        document.getElementsByClassName("msg_board")[0].innerHTML = "";
      };
    }
    else {
      // 浏览器不支持 WebSocket
      alert("您的浏览器不支持 WebSocket!");
    }
  }
</script>
</body>
</html>
