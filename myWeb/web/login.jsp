<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    window.onload= function () {
        document.getElementById("img").onclick = function () {
            this.src = "/demo06_response_checkCode?time="+new Date().getTime();
        }
    }

</script>
<body>
    <form  action="/demo03_case" method="post">
        用户名：<input name="userName" type="text" /><br>
        密码：<input name="password" type="password" /><br>
        验证码：<input name="checkCode" type="text" /><br>
        <img id="img" src="/demo06_response_checkCode"><br>
        <input type="submit" />
    </form>
<div><%=request.getAttribute("user_message") == null ? "" : request.getAttribute("user_message")%></div>
<div><%=request.getAttribute("error_message") == null ? "" : request.getAttribute("error_message")%></div>
</body>
</html>
