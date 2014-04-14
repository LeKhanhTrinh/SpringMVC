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
<<<<<<< HEAD
                <td><input type="checkbox" name="isMain" VALUE="isMain" checked> Main Contact</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" onclick="getValueOfCheckBox(this.form)">
=======
                <td><input type="checkbox" name="isMain" checked> Main Contact</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save">
>>>>>>> 52282f5eee682bec64cd6dcb9bd971645498c60c
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
<<<<<<< HEAD

    function getValueOfCheckBox(frm) {
        var checkedValue = null;
        var message = "isMain:\n\n"
        var inputElements = document.getElementsByTagName('isMain');
        for (var i = 0; frm.isMain.length; ++i) {
            if (frm.isMain[i].checked) {
                message = message + frm.isMain[i].value + "\n";
            }
        }
        alert(message);
    }

=======
>>>>>>> 52282f5eee682bec64cd6dcb9bd971645498c60c
    function closewindow() {
        window.close();
    }
</script>
