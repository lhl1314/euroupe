<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/20 0020
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户建议</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
            type="text/javascript"></script>


    <style>
        th, td {
            text-align: center;
            vertical-align: middle !important;
            border: 1px solid gainsboro;
        }

        .advice_content_left {
            font-size: 18px;
            color: grey;
            font-weight: bold;
        }

        .advice_content_right {
            font-size: 16px;
            color: grey;
            font-weight: bold;
        }
    </style>
</head>
<body>
<table class="table table-striped table-hover">
    <tr>
        <th>编号</th>
        <th>
            手机号/邮箱
        </th>
        <th>
            建议时间
        </th>
        <th>
            操作
        </th>
    </tr>
    <c:forEach var="advice" items="${page.list}">
        <tr id="${advice.id}">
            <td>${advice.id}</td>
            <td>
                <c:if test="${advice.accountVO.type==1}">
                    ${advice.accountVO.mobile}
                </c:if>
                <c:if test="${advice.accountVO.type!=1}">
                    ${advice.accountVO.email}
                </c:if>
            </td>
            <td>${advice.adviceTime}</td>
            <td>
                <a data-toggle="modal" data-target="#myModal" class="btn btn-info">
                    详情
                </a>
                <!-- 模态框（Modal） -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;
                                </button>
                                <h4 class="modal-title"
                                    style="font-size: 25px;color: dimgray;font-weight: bold;text-align: center;"
                                    id="myModalLabel">
                                    用户建议
                                </h4>
                            </div>
                            <div class="modal-body">

                                <div style="width: 80%;margin: 0px auto;">
                                    <div class="container" style="width: 100%">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <span class="advice_content_left">账户：</span>
                                                <span class="advice_content_right">
                                                    <c:if test="${advice.accountVO.type==1}">
                                                        ${advice.accountVO.mobile}
                                                    </c:if>
                                                   <c:if test="${advice.accountVO.type!=1}">
                                                    ${advice.accountVO.email}
                                                   </c:if>
                                            </span>
                                            </div>
                                            <div class="col-sm-6">
                                                <span class="advice_content_left">所属公司：</span>

                                                <span class="advice_content_right">
                                                    <c:if test="${advice.accountVO.type==1}">
                                                                      ${advice.accountVO.person.company.name}
                                                    </c:if>
                                                    <c:if test="${advice.accountVO.type!=1}">
                                                    ${advice.accountVO.company.name}
                                                    </c:if>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <hr/>
                                    <div style="width: 100%;text-align: center;color: grey;">
                                        <textarea name="" rows="" cols="" style="width: 80%;resize: none;min-height: 150px;">&nbsp;&nbsp;${advice.adviceContent}</textarea>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal -->
                </div>
                <a class="btn btn-warning" href="javascript:void(0)" onclick="deleteAdvice('${advice.id}')">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h3 class="page_h3" align="center">
    <ul class="pagination">
        <c:if test="${requestScope.page.pageIndex!=0}">
            <li>
                <a href="/admin/advice/findAdviceByPage?pageId=${page.pageIndex}" aria-label="Previous">
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
                <li class="active"><a href="/admin/advice/findAdviceByPage?pageId=${i+1}">${i+1}</a></li>
            </c:if>
            <c:if test="${page.pageIndex!=i}">
                <li><a href="/admin/advice/findAdviceByPage?pageId=${i+1}">${i+1}</a></li>
            </c:if>
        </c:forEach>
        <c:if test="${requestScope.page.pageIndex!=requestScope.page.pageTotal}">
            <li>
                <a href="/admin/advice/findAdviceByPage?pageId=${page.pageIndex+2}" aria-label="Next">
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


<script>
    /**
     * 删除建议
     * @param id
     */
    function deleteAdvice(id) {
        $.ajax(
            {
                type: "post",
                async: false,
                url: "/admin/advice/deleteAdvice",
                data: {
                    id: id
                },
                success: function (id) {
                    $("#" + id).remove();
                },
                dataType: "json"
            }
        )
    }
</script>
</body>
</html>
