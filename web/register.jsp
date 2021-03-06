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
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>纸叠效果会员登录界面模板</title>
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <link rel="stylesheet" type="text/css" href="css/body.css"/>
</head>
<body>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.fancyspinbox.js"></script>
<script type="text/javascript">
  function show(){
    var profess=document.getElementById("test").value;
    var sui=document.getElementById("shopname");
    var aui=document.getElementById("address");
    if(profess=="store"){
      sui.style.display="";
      document.getElementById("shopname").value="";
    }else if(profess=="rider"){
      aui.style.display="none";
      sui.style.display="none";
    }else if(profess=="customer"){
      sui.style.display="none";
      aui.style.display="";
    }
  }
  function check(){
    if($('span').is('.wrong')){
      alert("请填写正确信息");
      return false;
    }else{
      return true;
    }

  }
</script>

<script>


  $(function () {

    var regex = /^[a-zA-Z0-9\u4e00-\u9fa5]{2,12}$/;
    var pattern = /(?=.*([a-zA-Z].*))(?=.*[0-9].*)[a-zA-Z0-9-*/+.~!@#$%^&*()]{6,12}$/;
    var tpatten = /^1[34578]\d{9}$/;
    var rname= /^[\u4e00-\u9fa5]{2,12}$/;



    $('.repassword').on('blur', function () {
      var pwd = $('.password').val();
      var repwd = $('.repassword').val();
      if (pwd==repwd) {
        $(this).siblings('span').removeClass('wrong');
        $(this).siblings('span').addClass('right');
        $(this).siblings('span').html('');

      } else{
        $(this).siblings('span').addClass('wrong');
        $(this).siblings('span').html('两次输入的密码不一样');
        return false;
      }
    });


    $('.username','.password','.telephone','.realname','.repassword').on('focus',function(){
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
        $(this).siblings('span').html('用户名应为2-10位');
      }else{
        $(this).siblings('span').addClass('wrong');
        $(this).siblings('span').html('用户名不能包含特殊字符');
      }
    });

    $('.password').on('blur', function () {
      var passwordVal = $(this).val();
      if (pattern.test(passwordVal)) {
        $(this).siblings('span').removeClass('wrong');
        $(this).siblings('span').addClass('right');
        $(this).siblings('span').html('');
      }else if(passwordVal.length<6){
        $(this).siblings('span').addClass('wrong');
        $(this).siblings('span').html('密码为6-12位');
      } else{
        $(this).siblings('span').addClass('wrong');
        $(this).siblings('span').html('密码至少包含 数字和英文');
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


    $("#username").blur(function() {

      $.post("/user?op=ajaxCheckName", "username=" + this.value, function(data) {

        if (data == "true") {
          console.log("false");
          $("#show").addClass('wrong');
          $("#show")[0].innerHTML = "该用户名已存在，请重新输入！";
        } else {
          console.log("true");
          $("#show").removeClass('wrong');


          $("#show")[0].innerHTML = "";

        }

      });

    });

  });
</script>

<div class="container">
  <section id="content">
    <form action="/reg/reg" method="post" onsubmit="return check()" >
      <h1>注册</h1>
      <div>

        <select class="my-menu" id="test" name="profession" onchange="show()">
          <option value="customer">顾客</option>
          <option value="store">商家</option>
          <option value="rider">骑手</option>

        </select>
      </div>
      <br />
      <input type="hidden" value="reg" name="op" />
      <div>
        <input type="text"  style="display:none" placeholder="饭店名称" id="shopname" name="shopname" value="null"/>
      </div>
      <div>
        <input type="text" placeholder="用户名" required="" id="username" name="username" class="username" maxlength="12" />
        <br><span></span>
        <div><span id="show" ></span></div>
      </div>
      <div>
        <input type="password" placeholder="密码" required="" id="password" name="password" class="password" maxlength="12"/>
        <br><span></span>
      </div>
      <div>
        <input type="password" placeholder="确认密码" required="" id="repassword" name="repassword" class="repassword" maxlength="12"/>
        <br><span></span>
      </div>
      <div>
        <input type="text" placeholder="真实姓名" required="" id="realname" name="realname" class="realname" maxlength="12" />
        <br><span></span>
      </div>
      <div>
        <input type="text" placeholder="手机号" required="" id="telephone" name="telephone" class="telephone" maxlength="11"/>
        <br><span></span>
      </div>
      <div>
        <input type="text" placeholder="地址"  id="address" name="address" maxlength="36"/>
      </div>

      <div>
        <input type="text" placeholder="验证码" required="" id = "input" class="check" maxlength="4"/>
        <br><span class="yzm"></span>
      </div>
      <div>

        <input type = "button" id="code" />
      </div>
      <div class="">
        <span class="help-block u-errormessage" >&nbsp;</span>			</div>
      <div>
        <!-- <input type="submit" value="Log in" /> -->
        <input type="submit" value="注册" class="btn btn-primary" id="js-btn-login"/>
        <a href="#">忘记密码?</a>
        <!-- <a href="#">Register</a> -->
      </div>
    </form><!-- form -->
    <div class="button">
      <span class="help-block u-errormessage" >&nbsp;</span>
      <a href="login.jsp">登入</a>
    </div> <!-- button -->
  </section><!-- content -->
</div>
<!-- container -->

<script type="text/javascript">
  function change(){
    code=$("#code");
    // 验证码组成库
    var arrays=new Array(
            '1','2','3','4','5','6','7','8','9','0',
            'a','b','c','d','e','f','g','h','i','j',
            'k','l','m','n','o','p','q','r','s','t',
            'u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J',
            'K','L','M','N','O','P','Q','R','S','T',
            'U','V','W','X','Y','Z'
    );
    codes='';// 重新初始化验证码
    for(var i = 0; i<4; i++){
      // 随机获取一个数组的下标
      var r = parseInt(Math.random()*arrays.length);
      codes += arrays[r];
    }
    // 验证码添加到input里
    code.val(codes);
  }
  change();
  code.click(change);


  $(".check").on('blur', function (){
    var inputCode = $("#input").val().toUpperCase(); //取得输入的验证码并转化为大写
    console.log(inputCode);
    if(inputCode.length == 0) { //若输入的验证码长度为0
      $(this).siblings('span').html('请输入验证码'); //则弹出请输入验证码
    }
    else if(inputCode!=codes.toUpperCase()) { //若输入的验证码与产生的验证码不一致时
      $(this).siblings('span').html('验证码输入错误!请重新输入');

      change();//刷新验证码
      $("#input").val("");//清空文本框
    }else { //输入正确时
      console.log("true"); //弹出^-^

    }
  });

  $(".check").on('focus', function (){

    $(this).siblings('span').html(''); //则弹出请输入验证码

  });

</script>
<script>
  $('.my-menu').fancyspinbox();
</script>
<br><br><br><br>
<div style="text-align:center;">
</div>
</body>

</html>

