<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/15 0015
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>企业信息</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
            type="text/javascript"></script>

    <style>
        .table th, td {
            text-align: center;
            vertical-align: middle !important;
        }
    </style>
</head>
<body>
<table class="table table-striped table-hover">
    <tr>
        <th>企业编号</th>
        <th>企业名称</th>
        <th>联系方式</th>
        <th>企业状态</th>
        <th>
            <a href="javascript:void(0)" class="btn btn-danger">公司操作</a>
            <a href="/admin/company/toAddCompanyUpload" class="btn btn-primary">添加企业</a>
        </th>
    </tr>
    <c:forEach items="${page.list}" var="company">
        <tr>
            <td>${company.id}</td>
            <td>${company.name}</td>
            <td>${company.mobile}</td>
            <td>
                <c:if test="${company.isDelete==1}">
                    已冻结
                </c:if>
                <c:if test="${company.isDelete==0}">
                    已激活
                </c:if>
            </td>
            <td>
                <a href="/admin/company/toUpdateCompanyDetail?id=${company.id}&&pageId=${page.pageIndex+1}" class="btn btn-info">修改信息</a>
                <a href="/admin/company/getCompanyDetail?id=${company.id}&&pageId=${page.pageIndex+1}"
                   class="btn btn-info">企业详情</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h3 align="center">
    <ul class="pagination">
        <c:if test="${requestScope.page.pageIndex!=0}">
            <li>
                <a href="/admin/company/getCompanyByPage?pageId=${page.pageIndex}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${requestScope.page.pageIndex==0}">
            <li class="previous disabled">
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>

        <c:forEach begin="${page.start}" end="${page.end}" var="i" step="1">
            <c:if test="${page.pageIndex==i}">
                <li class="active"><a href="/admin/company/getCompanyByPage?pageId=${i+1}">${i+1}</a></li>
            </c:if>
            <c:if test="${page.pageIndex!=i}">
                <li><a href="/admin/company/getCompanyByPage?pageId=${i+1}">${i+1}</a></li>
            </c:if>
        </c:forEach>
        <c:if test="${requestScope.page.pageIndex!=requestScope.page.pageTotal}">
            <li>
                <a href="/admin/company/getCompanyByPage?pageId=${page.pageIndex+2}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${requestScope.page.pageIndex==requestScope.page.pageTotal}">
            <li class="previous disabled">
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</h3>
</body>
</html>
