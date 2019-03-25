<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/14 0014
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加账户</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/admin/account/addAccount.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
            type="text/javascript"></script>
</head>
<body>
<div class="addAcount">
    <h3 align="center" style="color: goldenrod;font-weight: bold;">分配账户职能权限</h3>
    <div class="container">
        <form id="addAccountForm" action="#" class="form-horizontal">
            <div class="row">
                <div class="col-sm-2">手机号：</div>
                <div class="col-sm-4">
                    <input type="text" required="required" class="form-control" id="changMobile" name="mobile"/>
                </div>
                <div class="col-sm-2">密码：</div>
                <div class="col-sm-4">
                    <input type="text" require="required" class="form-control" id="addPassword" name="password"/>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">账户类型：</div>
                <div class="col-sm-4">
                    <select name="type" class="form-control">
                        <option value="1">中国公司</option>
                        <option value="2">欧洲公司</option>
                        <option value="3">在欧华企</option>
                        <option value="4">中国个人</option>
                    </select>
                </div>
                <div class="col-sm-2">邮箱：</div>
                <div class="col-sm-4">
                    <input type="email" require="required" class="form-control" name="email"/>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">查看角色：</div>
                <div class="col-sm-4">
                    <select name="role" class="role form-control">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.id}" id="${role.id}">
                                    ${role.roleName}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-sm-2">选择角色：</div>
                <div class="col-sm-4 checkboxRole">
                    <c:forEach items="${roles}" var="role">
                        <label class="checkbox-inline">
                            <input type="checkbox" name="roles" value="${role.id}"> ${role.roleName}
                        </label>
                    </c:forEach>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-offset-8 col-sm-4">
                    <input type="button"
                           style="background: burlywood;color: whitesmoke;font-weight: bold;font-size: 16px"
                           id="submitAddAccount" value="提交" class="form-control">
                </div>
            </div>
        </form>
    </div>
</div>


<table class="permissionTable table table-striped table-hover">
    <tr class="roleHead">
        <th>管理员账户</th>
        <th>管理员角色职称</th>
        <th>管理员权限</th>
    </tr>
    <tr>
        <td>超级管理员</td>
        <td>/user/delete</td>
    </tr>
</table>
<script type="text/javascript" src="/js/admin/account/addAccount.js"></script>
</body>
</html>
