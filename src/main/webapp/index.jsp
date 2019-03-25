<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

<body>
<jsp:forward page="/back/toHome"/>
<h2>Hello World!</h2>

<form action="api/userinfo/login">
    <input type="text" name="name" id="name"/>
    <input type="text" name="password" id="password">
    <input type="submit">
</form>


<form action="api/company/list">
    <input type="text" name="page" id="page"/>
    <input type="text" name="rows" id="rows">
    <input type="submit">
</form>
</body>
</html>
