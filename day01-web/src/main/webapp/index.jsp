<%@page contentType="text/html;" pageEncoding="utf-8" %>
<html>
<style>
    label {
        display: block;
        margin: 5px;
    }
</style>
<body>
<h2>Hello World!</h2>

<form action="userRegister" method="post">
    <label>
        用户名：<input name="username"></label>
    <label>
        密码：<input name="password" type="password">
    </label>
    <label>
        确认密码：<input name="password" type="password">
    </label>
    <button type="submit">注册</button>
    <button type="submit">登录</button>
</form>

</body>
</html>
