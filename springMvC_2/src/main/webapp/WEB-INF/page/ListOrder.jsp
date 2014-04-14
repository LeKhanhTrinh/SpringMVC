<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/11/14
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>List Order</title>
</head>
<body>
<h1>List Order</h1>
<table width="90%" style="margin-left: 50px;">
    <tr>
        <td style="width:20%">Order Number</td>
        <td style="width:20%">Contact</td>
        <td style="width:20%">Total Amount</td>
        <td style="width:20%">Creation Date</td>
        <td style="width:20%">Update Date</td>
    </tr>
    <c:forEach var="listValue" items="${pagingObject.objects}">
        <tr>
            <td style="width:20%">
                <a href="#" onclick="orderDetail(this)" id ="${listValue.orderNumber}">
                    <c:out value="${listValue.orderNumber}"/>
                </a>
            </td>
            <td style="width:20%"><c:out value="${listValue.contactName}"/></td>
            <td style="width:20%"><c:out value="${listValue.totalAmount}"/></td>
            <td style="width:20%"><c:out value="${listValue.creationDate}"/></td>
            <td style="width:20%"><c:out value="${listValue.updateDate}"/></td>
        </tr>
    </c:forEach>
</table>



<div class="paging" style="margin-left: 200px">
    <c:if test="${pagingObject.currentPage != 1}">
        <a href="#" onclick="back();">Prev</a> &nbsp; &nbsp; &nbsp;
    </c:if>

    <c:if test="${pagingObject.totalPage < 10}">
        <c:forEach begin="1" end="${pagingObject.totalPage}" var="i">
            <c:if test="${i!=pagingObject.currentPage}">
                &nbsp; &nbsp;  <a href="#" id="${i}" onclick="gotoPage(this)"><c:out value="${i}"/></a> &nbsp; &nbsp;
            </c:if>
            <c:if test="${i==pagingObject.currentPage}">
                <b><c:out value="${i}"/></b>
            </c:if>
        </c:forEach>
    </c:if>

    <c:if test="${pagingObject.totalPage > 10}">
        <c:if test="${pagingObject.currentPage > 5}">
            <c:forEach begin="${pagingObject.currentPage-4}" end="${pagingObject.currentPage+5}" var="i">
                <c:if test="${i!=pagingObject.currentPage}">
                    &nbsp; &nbsp;   <a href="#" id="${i}" onclick="gotoPage(this)"><c:out value="${i}"/></a>&nbsp; &nbsp;
                </c:if>
                <c:if test="${i==pagingObject.currentPage}">
                    <b><c:out value="currentPage"/></b>
                </c:if>
            </c:forEach>
        </c:if>
    </c:if>
    <c:if test="${pagingObject.currentPage < pagingObject.totalPage}">
        &nbsp;&nbsp;&nbsp; <a href="#" onclick="next()">Next</a>
    </c:if>
</div>

<form name="orderList" action="/orderList">
    <input hidden="customerId" value="${customerId}" id="customerId">
    <input hidden="currentPage" name="currentPage" id="currentPage" value="${pagingObject.currentPage}">
</form>
</body>
</html>


<script>
    function gotoPage(object){
        var lnk = object.getAttribute('id');
        var elem = document.getElementById("currentPage");
        elem.value = lnk;
        document.orderList.submit();
    }

    function back(){
        var elem = document.getElementById("currentPage");
        var values = elem.value;
        if(values > 1){
            elem.value = values-1;
            document.orderList.submit();
        }
    }

    function next(){
        var elem = document.getElementById("currentPage");
        var values = elem.value;
        var intResults = parseInt(values, 10);
        elem.value = intResults + 1;
        document.orderList.submit();
    }

    function orderDetail(object){
        var orderId = object.getAttribute('id');
        var customerId = document.getElementById("customerId").value;
        var url =  "/orderDetail?orderId=" + orderId + "&&customerId="+ customerId;
        window.top.location.href = url;

    }
</script>

<style>
    .paging{
        top: 270px;
        left: 300px;
        position: absolute;
    }
</style>

</body>
</html>
