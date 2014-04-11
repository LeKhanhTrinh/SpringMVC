<%--
  Created by IntelliJ IDEA.
  User: hunglv
  Date: 4/11/14
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Customer</h2>
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
