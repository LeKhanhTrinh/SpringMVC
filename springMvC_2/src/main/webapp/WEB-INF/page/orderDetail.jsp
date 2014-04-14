<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hunglv
  Date: 4/14/14
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>OrderDetail</title>
</head>
<body>
<h1> Order Detail: ${orderID}</h1>
<br>
<hr>

<table width="100%">

    <tr>
        <td rowspan="5" style="width:20%">
            <img src = "${customerInfo.avt}" width="100px" height="100px"/>
        </td>
        <td style="width:35%" clospan="3" >${customerInfo.customerName}</td>

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
        <td></td>
    </tr>
    <tr>
        <td>Tel:${customerInfo.conPhone}</td>
        <td>Email:${customerInfo.conEmail}</td>
    </tr>
</table>
<br>
<br>
<br>
<br>
<table width="1200px" style="margin-left: 50px;">
    <tr>
        <td style="width:25%"><b>Product</b></td>
        <td style="width:25%"><b>Description</b></td>
        <td style="width:25%"><b>Quantity Orderred</b></td>
        <td style="width:25%"><b>Price Each</b></td>
    </tr>
    <c:forEach var="value" items="${orderDetailList}">
        <tr>
        <td style="width:25%">${value.product.serialProduct}</td>
        <td style="width:25%">${value.description}</td>
        <td style="width:25%">${value.quantityOrdered}</td>
        <td style="width:25%">$${value.priceEach}</td>
        </tr>
    </c:forEach>
    <tr>
        <td style="width:25%"></td>
        <td style="width:25%"></td>
        <td style="width:25%"><b>Total: </b></td>
        <td style="width:25%"><b>$${totalOrder}</b></td>
    </tr>
</table>
</body>
</html>
