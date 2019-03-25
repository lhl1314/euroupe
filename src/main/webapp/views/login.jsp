<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>后台LOGIN 后台LOGIN 后台LOGIN!</h1>

<form action="/back/login" method="post">
    <input type="text" name="name" id="name"/>
    <input type="text" name="password" id="password">
    <input type="submit">
</form>


<form action="/api/company/list">
    <input type="text" name="page" id="page"/>
    <input type="text" name="rows" id="rows">
    <input type="submit">
</form>
</body>
</html>
