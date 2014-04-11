<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>Welcome</title>
</head>
<body>
<div style="text-align: -webkit-center">


    <h2 style="color: royalblue;"> Hi ${username}. Welcome to your page! </h2>
    <h3> <a href="logout">Logout</a> </h3>
</div>
<h1>Customer</h1>
<hr>
<div style="float:right; clear: both;">
    <form>
        <input type="text" name="criteriaSearch"><input type="button" value="Search">
    </form>
</div>




<!--create table information customers -->
<table width="95%" style="margin-left: 50px;">
    <tr>
        <td style="width:15%">&nbsp</td>
        <td style="width:20%">Customer name</td>
        <td style="width:20%">Contact name</td>
        <td style="width:20%">Email</td>
        <td style="width:15%">Total equipment</td>
        <td style="width:10%">Latest Order</td>

    </tr>
    <tr>
        <td colspan="6"><hr/></td>
    </tr>

    <ul>
        <c:forEach var="listValue" items="${pagingObject.objects}">
            <tr>
                <td style="width:15%">
                    <img src = "" width="50px" height="100px"/>
                </td>
                <td style="width:20%"><a href="/customerDetail"><c:out value="${listValue.customerName}"/></a></td>
                <td style="width:20%"><c:out value="${listValue.contactName}"/></td>
                <td style="width:20%"><c:out value="${listValue.emailCustomer}"/></td>
                <td style="width:10%">20</td>
                <td style="width:15%">WOCB</td>
            </tr>
        </c:forEach>
    </ul>

</table>
<div class="paging">
    <button onclick="back();">Pre</button>
    <c:out value="${pagingObject.currentPage}"/> / <c:out value="${pagingObject.totalPage}"/>
    <button onclick="next()">Next</button>
</div>

</body>
</html>

<style>
    .paging{
        float:left;
        margin-right:150px;
        margin-top:30px;
        margin-bottom:10px;
    }
</style>
