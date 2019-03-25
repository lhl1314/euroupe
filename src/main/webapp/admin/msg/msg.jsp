<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/2 0002
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>信息提示</title>
    <link type="text/css" rel="stylesheet" href="/bootstrap-3.3.7-dist/css/bootstrap.css">
    <script type="text/javascript" src="/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <style>
        h2 {
            text-align: center;
            font-size: 42px;
            font-weight: bold;
            color: goldenrod;
            margin: 200px auto;
        }
    </style>

</head>

<body>
<h2>${msg},该页面将在<span id="sp">5</span>秒后跳转</h2>
<script>
    var sp = $("#sp");
    var i = 5;
    window.setInterval(intervalFunction, 1000);

    function intervalFunction() {
        i--;
        sp.html(i);
        if (i == 0) {
            location.href = "${address}";
        }
    }
</script>

</body>
</html>
