<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function validateFormLogin()
        {
            var usename = document.forms["loginForm"]["username"].value;
            var password = document.forms["loginForm"]["password"].value;
            if (usename == null || usename == "")
            {
                alert("Username must be filled out");
                return false;
            }

            if (password == null || password == "")
            {
                alert("Password must be filled out");
                return false;
            }
        }
    </script>
</head>
<body style="text-align: -webkit-center">
<h2>Login</h2>
<form action="login" name="loginForm" onsubmit="return validateFormLogin()" method="POST">
    <table>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login">
        </tr>
    </table>
</form>
</body>
</html>
