<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>LOGIN LOGIN LOGIN!</h2>

<form action="api/userinfo/login" method="post">
    <input type="text" name="name" id="name"/>
    <input type="text" name="password" id="password">
    <input type="submit">
</form>


<form action="api/company/list">
    <input type="text" name="page" id="page"/>
    <input type="text" name="rows" id="rows">
    <input type="submit">
</form>

<%--注册</br>--%>
<%--<form action="api/userinfo/register" method="post">--%>
    <%--<input type="text" name="mobile" id="mobile"/>--%>
    <%--<input type="text" name="password" id="password">--%>
    <%--<input type="text" name="type" id="type">--%>
    <%--<input type="submit">--%>
<%--</form>--%>
</body>
</html>
