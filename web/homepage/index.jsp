<%@ page import="java.util.ArrayList" %>
<%@ page import="com.etc.entity.Store" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/10/10
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html class="no-js">
<!--

Grill Template

http://www.templatemo.com/free-website-templates/417-grill

-->
<head>
  <meta charset="utf-8">
  <title>校园点餐系统</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">

  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <link rel="stylesheet" href="/homepage/css/bootstrap.css">
  <link rel="stylesheet" href="/homepage/css/font-awesome.css">
  <link rel="stylesheet" href="/homepage/css/templatemo_style.css">
  <link rel="stylesheet" href="/homepage/css/templatemo_misc.css">
  <link rel="stylesheet" href="/homepage/css/flexslider.css">
  <link rel="stylesheet" href="/homepage/css/testimonails-slider.css">

  <script src="js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
</head>
<body>
<!--[if lt IE 7]>
<p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
<![endif]-->

<header>
  <div id="top-header">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <div class="home-account">
            <a href="#">Home</a>
            <a href="#">我的账户</a>
          </div>
        </div>
        <div class="col-md-6">
          <div class="cart-info">
            <i class="fa fa-shopping-cart"></i>
            (<a href="#">5 件</a>) 在你的购物车 (<a href="#">$45.80</a>)
          </div>
        </div>
      </div>
    </div>
  </div>
  <div id="main-header">
    <div class="container">
      <div class="row">
        <div class="col-md-3">
          <div class="logo">
            <a href="#"><img src="images/logo.png" title="Grill Template" alt="Grill Website Template" ></a>
          </div>
        </div>
        <div class="col-md-6">
          <div class="main-menu">
            <ul>
              <li><a href="index.jsp">Home</a></li>
              <li><a href="about-us.jsp">关于</a></li>
              <li><a href="products.jsp">菜单</a></li>
              <li><a href="contact-us.jsp">联系我们</a></li>
            </ul>
          </div>
        </div>
        <div class="col-md-3">
          <div class="search-box">
            <form name="search_form" method="get" class="search_form">
              <input id="search" type="text" />
              <input type="submit" id="search-button" />
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</header>


<div id="slider">
  <div class="flexslider">
    <ul class="slides">
      <li>
        <div class="slider-caption">
          <h1>美味午餐</h1>
          <p>因为你不会，所以你才会！
            <br><br>我起飞了.</p>
          <a href="/homepage/products.jsp">开始点餐</a>
        </div>
        <img src="/homepage/images/slide1.jpg" alt="" />
      </li>
      <li>
        <div class="slider-caption">
          <h1>冰淇淋菜单</h1>
          <p>Nulla id iaculis ligula. Vivamus mattis quam eget urna tincidunt consequat. Nullam
            <br><br>consectetur tempor neque vitae iaculis. Aliquam erat volutpat.</p>
          <a href="single-post.jsp">查看更多</a>
        </div>
        <img src="/homepage/images/slide2.jpg" alt="" />
      </li>
      <li>
        <div class="slider-caption">
          <h1>大保健</h1>
          <p>Maecenas fermentum est ut elementum vulputate. Ut vel consequat urna. Ut aliquet
            <br><br>ornare massa, quis dapibus quam condimentum id.</p>
          <a href="single-post.jsp">开始阅读</a>
        </div>
        <img src="/homepage/images/slide3.jpg" alt="" />
      </li>
    </ul>
  </div>
</div>
<div class="adcenter"><script src=""></script></div>

<div id="services">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="heading-section">

          <img src="/homepage/images/under-heading.png" alt="" >
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-3 col-sm-6">
        <div class="service-item">
          <div class="icon">
            <i class="fa fa-pencil"></i>
          </div>
          <h4>点餐</h4>
          <p>Sed egestas tincidunt mollis. Suspendisse rhoncus vitae enim et faucibus. Ut dignissim nec arcu nec hendrerit. Sed arcu  sagittis vel diam in, malesuada malesuada risus. Aenean a sem leoneski.</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="service-item">
          <div class="icon">
            <i class="fa fa-bullhorn"></i>
          </div>
          <h4>促销活动</h4>
          <p>Sed egestas tincidunt mollis. Suspendisse rhoncus vitae enim et faucibus. Ut dignissim nec arcu nec hendrerit. Sed arcu  sagittis vel diam in, malesuada malesuada risus. Aenean a sem leoneski.</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="service-item">
          <div class="icon">
            <i class="fa fa-bell"></i>
          </div>
          <h4>优质服务</h4>
          <p>Sed egestas tincidunt mollis. Suspendisse rhoncus vitae enim et faucibus. Ut dignissim nec arcu nec hendrerit. Sed arcu  sagittis vel diam in, malesuada malesuada risus. Aenean a sem leoneski.</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="service-item">
          <div class="icon">
            <i class="fa fa-heart"></i>
          </div>
          <h4>包你满意</h4>
          <p>Sed egestas tincidunt mollis. Suspendisse rhoncus vitae enim et faucibus. Ut dignissim nec arcu nec hendrerit. Sed arcu  sagittis vel diam in, malesuada malesuada risus. Aenean a sem leoneski.</p>
        </div>
      </div>
    </div>
  </div>
</div>





<div id="latest-blog">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="heading-section">
          <h2>最新log</h2>
          <img src="/homepage/images/under-heading.png" alt="" >
        </div>
      </div>
    </div>
    <div class="row">
<%--      商店开始--%>
      <%
        ArrayList<Store> list= (ArrayList<Store>) session.getAttribute("stores");
        for(Store store:list){
      %>
      <div class="col-md-4 col-sm-6">
        <div class="blog-post">
          <div class="blog-thumb">
            <img src="/homepage/images/blogpost<%=store.getSid()%>.jpg" alt="" />
          </div>
          <div class="blog-content">
            <div class="content-show">
              <h4><a href="/dish?op=begindish&sid=<%=store.getSid()%>"><%=store.getShopname()%></a></h4>
              <span><%=store.getRealname()%></span>
            </div>
            <div class="content-hide">
              <p>Sed egestas tincidunt mollis. Suspendisse rhoncus vitae enim et faucibus. Ut dignissim nec arcu nec hendrerit. Sed arcu odio, sagittis vel diam in, malesuada malesuada risus. Aenean a sem leo. Nam ultricies dolor et mi tempor, non pulvinar felis sollicitudin.</p>
            </div>
          </div>
        </div>
      </div>
  <%
    }
  %>
<%--      商店结尾--%>
    </div>
  </div>
</div>


<div id="testimonails">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="heading-section">
          <h2>人们怎么说</h2>
          <img src="/homepage/images/under-heading.png" alt="" >
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-8 col-md-offset-2">
        <div class="testimonails-slider">
          <ul class="slides">
            <li>
              <div class="testimonails-content">
                <p>Sed egestas tincidunt mollis. Suspendisse rhoncus vitae enim et faucibus. Ut dignissim nec arcu nec hendrerit sed arcu odio, sagittis vel diam in, malesuada malesuada risus. Aenean a sem leo. Nam ultricies dolor et mi tempor, non pulvinar felis sollicitudin.</p>
                <h6>Jennifer - <a href="#">Chief Designer</a></h6>
              </div>
            </li>
            <li>
              <div class="testimonails-content">
                <p>Sed egestas tincidunt mollis. Suspendisse rhoncus vitae enim et faucibus. Ut dignissim nec arcu nec hendrerit sed arcu odio, sagittis vel diam in, malesuada malesuada risus. Aenean a sem leo. Nam ultricies dolor et mi tempor, non pulvinar felis sollicitudin.</p>
                <h6>Laureen - <a href="#">Marketing Executive</a></h6>
              </div>
            </li>
            <li>
              <div class="testimonails-content">
                <p>Sed egestas tincidunt mollis. Suspendisse rhoncus vitae enim et faucibus. Ut dignissim nec arcu nec hendrerit sed arcu odio, sagittis vel diam in, malesuada malesuada risus. Aenean a sem leo. Nam ultricies dolor et mi tempor, non pulvinar felis sollicitudin.</p>
                <h6>Tanya - <a href="#">Creative Director</a></h6>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>

<footer>
  <div class="container">
    <div class="top-footer">
      <div class="row">
        <div class="col-md-9">
          <div class="subscribe-form">
            <span>请与我们联系</span>
            <form method="get" class="subscribeForm">
              <input id="subscribe" type="text" />
              <input type="submit" id="submitButton" />
            </form>
          </div>
        </div>
        <div class="col-md-3">
          <div class="social-bottom">
            <span>跟着我们:</span>
            <ul>
              <li><a href="#" class="fa fa-facebook"></a></li>
              <li><a href="#" class="fa fa-twitter"></a></li>
              <li><a href="#" class="fa fa-rss"></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>



  </div>
</footer>


<script src="js/vendor/jquery-1.11.0.min.js"></script>
<script src="js/vendor/jquery.gmap3.min.js"></script>
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>

</body>
</html>