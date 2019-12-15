<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>


    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "checkCodeServlet?time=" + new Date().getTime();

            }

        }
        <%--document.getElementById("登录").onclick = function () {--%>

        <%--    alert(<%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%>--%>

        <%--        <%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error") %>--%>
        <%--    )--%>
        <%--}--%>


    </script>
    <style>


        table {
            margin: 100px auto auto;
        }
        div {
            color: red;
            margin: auto;
            float:bottom;
        }
        input{
            text-aline:left;
        }

    </style>
</head>
<body>

<form action="loginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="checkCodeServlet"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"  value="登录"></td>
        </tr>
    </table>


</form>


<div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%>
</div>
<div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error") %>
</div>

</body>
</html>
