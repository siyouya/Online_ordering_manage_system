<%@ page import="java.util.ArrayList" %>

<%@ page import="com.etc.entity.Disher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<!--

Grill Template

http://www.templatemo.com/free-website-templates/417-grill

-->
<head>
  <meta charset="utf-8">
  <title>Products - Grill Template</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">

  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/font-awesome.css">
  <link rel="stylesheet" href="css/templatemo_style.css">
  <link rel="stylesheet" href="css/templatemo_misc.css">
  <link rel="stylesheet" href="css/flexslider.css">
  <link rel="stylesheet" href="css/testimonails-slider.css">
  <link rel="stylesheet" href="css/classify.css.css">


  <script src="js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
</head>
<script type="text/javascript">
  var tag="";
  var count=0;
  var total=0;
  function adddish(name,price){
    tag+=name+",";
    count++;
    total+=Number(price);
    document.getElementById('shopcount').innerHTML=count+"件";
    document.getElementById('total').innerHTML="￥"+total;
    document.getElementById('sub').value=tag;


  }
</script>
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
            <i class="fa fa-shopping-cart" ></i>
            (<a  id="shopcount">0</a>) 在你的购物车 (<a  id="total">0</a>)
            <div class="sub"  >
              <form method="post" action="/order">
<%--              <ul class="list-unstyled right-con">--%>
<%--                <li class="list-unstyled">--%>

<%--                  <div class="menu-txt">--%>
<%--                    <h4 data-icon="00">珍珠奶茶</h4>--%>

<%--                    <p class="list2">--%>
<%--                      <b>￥</b><b>2.00</b>--%>
<%--                    </p>--%>
<%--                    <div class="btn">--%>
<%--                      <button class="minus">-</button>--%>
<%--                      <i>0</i>--%>
<%--                      <button class="add">+</button>--%>
<%--                      <i class="price">2.00</i>--%>
<%--                    </div>--%>
<%--                  </div>--%>
<%--                </li>--%>
<%--                --%>
  <input name="tag" type="text" id="sub">
  <input name="op" type="text" value="addorder" hidden>
<%--              </ul>--%><button  class="navbar-btn btn" onclick="">submit</button>
              </form>

            </div>
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
<%--        <div class="col-md-6">--%>
<%--          <div class="main-menu">--%>
<%--            <ul>--%>
<%--              <li><a href="index.jsp">Home</a></li>--%>
<%--              <li><a href="about-us.jsp">关于</a></li>--%>
<%--              <li><a href="products.jsp">菜单</a></li>--%>
<%--              <li><a href="contact-us.jsp">联系我们</a></li>--%>
<%--            </ul>--%>
<%--          </div>--%>
<%--        </div>--%>

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


<div id="heading">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="heading-content">
          <h2>我们的菜单</h2>
          <span>Home / <a href="about-us.html">菜单</a></span>
        </div>
      </div>
    </div>
  </div>
</div>





<div id="products-post">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div id="product-heading">
          <h2>饿了 ?</h2>
          <img src="images/under-heading.png" alt="" >
        </div>
      </div>
    </div>
    <div class="row">
      <div class="filters col-md-12 col-xs-12">
        <ul id="filters" class="clearfix">
          <li><span class="filter" data-filter="all">所有</span></li>
          <li><span class="filter" data-filter=".ginger">推荐</span></li>
          <li><span class="filter" data-filter=".pizza">折扣</span></li>
          <li><span class="filter" data-filter=".pasta">套餐</span></li>
          <li><span class="filter" data-filter=".drink">主食</span></li>
          <li><span class="filter" data-filter=".hamburger">小吃</span></li>
        </ul>
      </div>
    </div>
    <div class="row" id="Container">
<%--      产品开始--%>
      <%
        ArrayList<Disher> list= (ArrayList) session.getAttribute("list");
        for(Disher dish:list){
      %>
      <div class="col-md-3 col-sm-6 mix portfolio-item ">
        <div class="portfolio-wrapper">
          <div class="portfolio-thumb">
            <img src="images/product<%=dish.getDid()%>.jpg" alt="" />
            <div class="hover">
              <div class="hover-iner">
                <a  onclick="adddish('<%=dish.getDishname()%>','<%=dish.getPrice()%>')"><img src="images/open-icon.png" alt="" /></a>
                <span><%=dish.getDishname()%></span>
              </div>
            </div>
          </div>
          <div class="label-text">
            <h3><a href="single-post.html"><%=dish.getDishname()%></a></h3>
            <span class="text-category">￥<%=dish.getPrice()%></span>
          </div>
        </div>
      </div>

  <%--      产品结尾--%>
  <%
    }%>
    </div>
    <div class="pagination">
      <div class="row">
        <div class="col-md-12">
          <ul>
            <li><a href="#">Previous</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">Next</a></li>
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