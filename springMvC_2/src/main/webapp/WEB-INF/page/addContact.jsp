<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/11/14
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Contact</title>
</head>
<body>
    <h1>Add Contact</h1>
<form method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="nameContact"></td>
        </tr>

        <tr>
            <td>Tel</td>
            <td> <input type="text" name="phoneContact"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="mailContact"></td>
        </tr>
        <tr>
            <td>Job title </td>
            <td><input type="text" name="mailContact"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="checkbox" name="isMain" checked> Main Contact</td>
        </tr>
        <tr>
            <td></td>
            <td><button>Save</button> <button onclick="closewindow()">Cancel</button></td>
        </tr>
    </table>
</form>
</body>
</html>

<script>
    function closewindow(){
        window.close();
    }
</script>
