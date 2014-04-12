<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Customer: ${customerName}</h2>
<br>
<br>
<hr>

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
</script>

</body>
</html>
