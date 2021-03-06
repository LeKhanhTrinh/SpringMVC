<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <%@ page isELIgnored="false" %>
    <title>Add Contact</title>
</head>
<body>
<h1>Add Contact</h1>
<c:if test="${confirm != 1}">
    <form method="post" action="/addContact">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="nameContact"></td>
            </tr>

            <tr>
                <td>Tel</td>
                <td><input type="text" name="phoneContact"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="mailContact"></td>
            </tr>
            <tr>
                <td>Job title</td>
                <td><input type="text" name="jobTitle"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="checkbox" id="checkbox" name="isMain" checked> Main Contact</td>
                <input type="hidden" id="hidCheck" name="isMain">
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" onclick="getValueOfCheckBox()">
                    <button onclick="closewindow()">Cancel</button>
                </td>
            </tr>
        </table>
        <input type="hidden" name="customerId" id="customerId" value="${customerId}">
    </form>
</c:if>

<c:if test="${confirm == 1}">
    <a href="/goAddContact?customer=${customerId}">Add more</a> <br>
    <button onclick="closewindow()">Cancel</button>
    </td>
</c:if>
</body>
</html>

<script>
    function getValueOfCheckBox() {
        var checkedValue = false;
        var message = "isMain:\n\n"
        var inputElements = document.getElementById("checkbox");

        if (inputElements.checked == true){
            checkedValue = true;
        }

        if (checkedValue == false){
            document.getElementById("hidCheck").value = false;
        }
        message = message + checkedValue;
        alert(message);
    }
    function closewindow() {
        window.close();
    }
</script>
