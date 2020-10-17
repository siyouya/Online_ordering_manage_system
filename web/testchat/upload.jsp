<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/10/16
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form method="post" action="#" enctype="multipart/form-data" id="upload_img">
    <input type="file" name="uploadFile" id="imgUp" onclick="preImg(this.id,'imgPre');" />
    <input type="submit"  value="上传图片" />
</form>
</body>
<script type="javascript">
    function getFileUrl(sourceId) {
        var url;
        if (navigator.userAgent.indexOf("MSIE") >= 1) { // IE
            url = document.getElementById(sourceId).value;
        } else if (navigator.userAgent.indexOf("Firefox") > 0) { // Firefox
            url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
        } else if (navigator.userAgent.indexOf("Chrome") > 0) { // Chrome
            url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
        }
        url = document.getElementById(sourceId).value;
        alert(url);
        return url;
    }
    function preImg(sourceId, targetId) {
        var url = getFileUrl(sourceId);

        var imgPre = document.getElementById(targetId);
        imgPre.src = url;
        //setTimeout(document.getElementById('upimag').submit(),1000);
        document.getElementById('upload_img').submit();
        window.location.reload();
    }
</script>
</html>

