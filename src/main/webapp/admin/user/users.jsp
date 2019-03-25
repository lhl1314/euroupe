<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/21 0021
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <meta charset="UTF-8">
    <title>用户信息</title>
    <link rel="stylesheet" type="text/css" href="/css/admin/user/users.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
            type="text/javascript"></script>
</head>
<body>
<table class="table table-striped table-hover">
    <tr>
        <th>账户编号</th>
        <th>手机号</th>
        <th>邮箱</th>
        <th>账户类型</th>
        <th>最新登录时间</th>
        <th>账户状态</th>
        <th>
            <a href="javascript:void(0)" class="btn btn-danger">谨慎操作</a>
        </th>
    </tr>
    <c:forEach items="${page.list}" var="account">
        <tr>
            <td>${account.id}</td>
            <td>${account.mobile}</td>
            <td>${account.email}</td>
            <td>
                <c:if test="${account.type==1}">
                    中国公司
                </c:if>
                <c:if test="${account.type==2}">
                    欧洲公司
                </c:if>
                <c:if test="${account.type==3}">
                    在欧华企
                </c:if>
                <c:if test="${account.type==4}">
                    中国个人
                </c:if>
            </td>
            <td>
                <c:if test="${account.lastLoginTime==null}">
                    暂未登录
                </c:if>
                    ${account.lastLoginTime}
            </td>
            <td>
                <c:if test="${account.isDelete==1}">
                    <span style="color: red;font-weight: bold">已冻结</span>
                </c:if>
                <c:if test="${account.isDelete==0}">
                    <span style="color: grey">未冻结</span>
                </c:if>
            </td>
            <td>
                <a data-toggle="modal" data-target="#myModal${account.id}" class="btn btn-info">
                    <c:if test="${account.isDelete==0}">
                        冻结账户
                    </c:if>
                    <c:if test="${account.isDelete==1}">
                        解冻账户
                    </c:if>
                </a>
                <!-- 模态框（Modal） -->
                <div class="confirmModal modal fade" id="myModal${account.id}" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel${account.id}" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel${account.id}">
                                    <c:if test="${account.isDelete==0}">
                                        冻结账户
                                    </c:if>
                                    <c:if test="${account.isDelete==1}">
                                        解冻账户
                                    </c:if>
                                    <c:if test="${account.mobile.length()>11}">
                                        ${fn:substring(account.mobile,0,11)}...
                                    </c:if>
                                    <c:if test="${account.mobile.length()<=11}">
                                        ${fn:substring(account.mobile,0,11)}
                                    </c:if>
                                </h4>
                            </div>
                            <div class="modal-body">
                                <div class="modal-body-left">
                                    !
                                </div>
                                <div class="modal-body-right">
                                    <c:if test="${account.isDelete==0}">
                                        是否确定冻结该用户！此操作会导致该用户无法登陆本系统！
                                    </c:if>
                                    <c:if test="${account.isDelete==1}">
                                        是否确定解冻该用户！此操作会导致该用户可以重新登录本系统！
                                    </c:if>

                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default btn-info" data-dismiss="modal">确认返回
                                </button>
                                <button type="button" class="btn btn-primary btn-success"
                                        onclick="freezeNormalUser('${account.id}')">确认提交
                                </button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal -->
                </div>

            </td>
        </tr>
    </c:forEach>
</table>
<h3 class="page_h3" align="center">
    <ul class="pagination">
        <c:if test="${requestScope.page.pageIndex!=0}">
            <li>
                <a href="/admin/user/getPageUsers?pageId=${page.pageIndex}" aria-label="Previous">
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
                <li class="active"><a href="/admin/user/getPageUsers?pageId=${i+1}">${i+1}</a></li>
            </c:if>
            <c:if test="${page.pageIndex!=i}">
                <li><a href="/admin/user/getPageUsers?pageId=${i+1}">${i+1}</a></li>
            </c:if>
        </c:forEach>
        <c:if test="${requestScope.page.pageIndex!=requestScope.page.pageTotal}">
            <li>
                <a href="/admin/user/getPageUsers?pageId=${page.pageIndex+2}" aria-label="Next">
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

<script type="text/javascript" src="/js/admin/user/users.js">

</script>
</body>
</html>
