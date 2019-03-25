<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/14 0014
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>分页账户</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/admin/account/pageAccount.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
            type="text/javascript"></script>
</head>
<body>
<table class="accountTable table table-striped table-hover">
    <tr>
        <th>账户编号</th>
        <th>手机号</th>
        <th>邮箱</th>
        <th>账户类型</th>
        <th>最新登录时间</th>
        <th>账户状态</th>
        <th>
            权限
        </th>
        <th>
            <a href="javascript:void(0)" class="btn btn-danger">操作</a>
            <a href="/back/toAddAccount" class="btn btn-primary">添加管理员</a>
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
                    <span style="color: goldenrod;font-weight: bold;">已冻结</span>
                </c:if>
                <c:if test="${account.isDelete==0}">
                    <span style="color: grey">未冻结</span>
                </c:if>
            </td>
            <td>
                <a href="javascript:void(0)" class="btn btn-info" data-toggle="modal"
                   data-target="#myModal${account.id}">查看权限</a>
                <!-- 模态框（Modal） -->
                <div class="permissionModal modal fade" id="myModal${account.id}" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel${account.id}" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel${account.id}">
                                    账号：${account.mobile}的管理员所具有的权限如下
                                </h4>
                            </div>
                            <div class="modal-body">
                                <table class="table table-striped table-hover">

                                    <tr>
                                        <th>账户角色</th>
                                        <th>角色操作</th>
                                        <th>账户权限</th>
                                        <th>权限操作</th>
                                    </tr>
                                    <c:forEach items="${account.newAccountRoleVoList}" var="accountRole">
                                        <tr class="accountRole${accountRole.id}">
                                            <td class="accountRoleRows${accountRole.id}"
                                                rowspan="${accountRole.role.rolePermissions.size()+1}">
                                                    ${accountRole.role.roleName}
                                            </td>
                                            <td class="accountRoleRows${accountRole.id}"
                                                rowspan="${accountRole.role.rolePermissions.size()+1}">
                                                <a href="javascript:void(0)" class="btn btn-info"
                                                   onclick="deleteRole('${accountRole.id}')">删除角色</a>
                                            </td>
                                        </tr>
                                        <c:forEach items="${accountRole.role.rolePermissions}" var="per">
                                            <tr class="accountRole${accountRole.id} rolePermission${per.id}">
                                                <td>
                                                        ${per.permission.permissionName}
                                                </td>
                                                <td>
                                                    <a href="javascript:void(0)" class="btn btn-info"
                                                       disabled="disabled">删除权限</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:forEach>

                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal">提交更改</button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>
            </td>
            <td>
                <a href="javascript:void(0)" data-toggle="modal" data-target="#myModalConfirm${account.id}"
                   class="btn btn-info">
                    <c:if test="${account.isDelete==1}">
                        解冻账户
                    </c:if>
                    <c:if test="${account.isDelete==0}">
                        冻结账户
                    </c:if>
                </a>
                <!-- 模态框（Modal） -->
                <div class="confirmModal modal fade" id="myModalConfirm${account.id}" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabelConfirm${account.id}" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;
                                </button>
                                <h4 class="modal-title" id="myModalLabelConfirm${account.id}">
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
                                        是否确定冻结该管理员！此操作会导致该账户无法登陆本系统！
                                    </c:if>
                                    <c:if test="${account.isDelete==1}">
                                        是否确定解冻该管理员！此操作会导致该账户可以重新登录本系统！
                                    </c:if>

                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default btn-info" data-dismiss="modal">确认返回
                                </button>
                                <button type="button" class="btn btn-primary btn-success"
                                        onclick="freezeOrUnFreezeAccount('${account.id}')">确认提交
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
                <a href="/back/getAccountByPage?pageId=${page.pageIndex}" aria-label="Previous">
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
                <li class="active"><a href="/back/getAccountByPage?pageId=${i+1}">${i+1}</a></li>
            </c:if>
            <c:if test="${page.pageIndex!=i}">
                <li><a href="/back/getAccountByPage?pageId=${i+1}">${i+1}</a></li>
            </c:if>
        </c:forEach>
        <c:if test="${requestScope.page.pageIndex!=requestScope.page.pageTotal}">
            <li>
                <a href="/back/getAccountByPage?pageId=${page.pageIndex+2}" aria-label="Next">
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
<script type="text/javascript" src="/js/admin/account/pageAccount.js"></script>
</body>
</html>
