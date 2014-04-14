<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title></title>
</head>
<body>
<h2>Customer: ${customerName}</h2>
<br>
<hr>

<table width="100%">

    <tr>
        <td rowspan="5" style="width:20%">
            <img src="${customerInfo.avt}" width="100px" height="100px"/>
        </td>
        <td style="width:35%" clospan="3">${customerInfo.customerName}</td>

    </tr>
    <tr>
        <td colspan="3">${customerInfo.address}</td>

    </tr>
    <tr>
        <td>Tel: ${customerInfo.cusPhone}</td>
        <td>Fax: ${customerInfo.cusFax}</td>
    </tr>
    <tr>
        <td>${customerInfo.contactName}</td>
        <td>
            <button onclick="return popitup('/goAddContact?customer=${customerInfo.customerNumber}')">Add Contact
            </button>
        </td>
    </tr>
    <tr>
        <td>Tel:${customerInfo.conPhone}</td>
        <td>Email:${customerInfo.conEmail}</td>
    </tr>
</table>


<button onclick="callEquipmentPage()"> Equipment</button>
<button onclick="callOrderPage();"> Order</button>
<br>
<iframe width="80%" height="50%" id="iframeContent" src="/equipment?customer=${customerInfo.customerNumber}"></iframe>

</body>
</html>
<script>
    function callEquipmentPage() {
        document.getElementById("iframeContent").src = "/equipment?customer=${customerInfo.customerNumber}";
    }

    function callOrderPage() {
        document.getElementById("iframeContent").src = "/order?customer=${customerInfo.customerNumber}";
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
