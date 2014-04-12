<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Customer: ${customerName}</h2>
<br>
<hr>

<table width="100%">

    <tr>
        <td rowspan="5" style="width:20%">
            <img src = "data:image/jpeg;base64,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" width="100px" height="100px"/>
        </td>
        <td style="width:35%" clospan="3" >QSoft Vietnam corp</td>

    </tr>
    <tr>
        <td colspan="3">62 Tran Thai Tong Street, Cau Giay Dist</td>

    </tr>
    <tr>
        <td>Tel:</td>
        <td>Fax:</td>
    </tr>
    <tr>
        <td>Nguyen Toan Cau</td>
        <td><button onclick="return popitup('/addContact')">Add Contact</button></td>
    </tr>
    <tr>
        <td>Tel:</td>
        <td>Email:</td>
    </tr>
</table>



<button onclick="callEquipmentPage()"> Equipment </button> <button onclick="callOrderPage();"> Order </button><br>
<iframe width="80%" height="50%" id = "iframeContent"></iframe>
</body>
</html>
<script>
    function callEquipmentPage(){
        document.getElementById("iframeContent").src = "/equipment";
    }

    function callOrderPage(){
        document.getElementById("iframeContent").src = "/order";
    }
    function popitup(url) {
        var newurl = url;
        newwindow = window.open(newurl, 'name',
                'height=280,width=270, left=700, top=150');
        if (window.focus) {
            newwindow.focus()
        }
        return false;
    }
</script>

</body>
</html>
