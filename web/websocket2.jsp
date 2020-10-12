<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html><html lang="en">
<head>
    <meta charset="UTF-8">
    <title>网络聊天室</title>
</head>
<style type="text/css">
    .msg_board {
        width: 322px;
        height: 100px;
        border: solid 1px darkcyan;
        padding: 5px;
        overflow-y: scroll;
    // 文字长度大于div宽度时换行显示
    word-break: break-all;
    }
    /*set srcoll start*/
    ::-webkit-scrollbar
    {
        width: 10px;
        height: 10px;
        background-color: #D6F2FD;
    }
    ::-webkit-scrollbar-track
    {
        -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
        /*border-radius: 5px;*/
        background-color: #D6F2FD;
    }
    ::-webkit-scrollbar-thumb
    {
        height: 20px;
        /*border-radius: 10px;*/
        -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
        background-color: #89D7F7;
    }
    /*set srcoll end*/
</style>
<body>
<label>房间名</label>
<input id="input_roomName" size="10" maxlength="10">
<label>用户名</label>
<input id="username" size="10" maxlength="10">
<input type="button"  value="进入聊天室" onclick="initWebSocket()" />
<input type="button" value="退出聊天室" onclick="closeWs()" /><br>
<div class="msg_board"></div>
<input id="input_msg" size="43" maxlength="40">
<input type="button" value="发送" onclick="send_msg()" />
</body>
<script type="text/javascript">
    var webSocket;

    function send_msg() {
        if (webSocket != null) {
            var input_msg = document.getElementById("input_msg").value.trim();
            if (input_msg == "") {
                return;
            }
            webSocket.send(input_msg);
            // 清除input框里的信息
            document.getElementById("input_msg").value = "";
        } else {
            alert("您已掉线，请重新进入聊天室...");
        }
    };

    function closeWs() {
        webSocket.close();
    };

    function initWebSocket() {
        var roomName = document.getElementById("input_roomName").value;
        // 房间名不能为空
        if (roomName == null || roomName == "") {
            alert("请输入房间名");
            return;
        }
        var username = document.getElementById("username").value.trim();
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
                var msg_board = document.getElementsByClassName("msg_board")[0];
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
</html>