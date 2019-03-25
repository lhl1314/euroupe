<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/20 0020
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>企业申请认证</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
            type="text/javascript"></script>


    <style>
        th,
        td {
            vertical-align: middle !important;
            border: 1px solid gainsboro;
        }

        .modal_title_authorzation {
            text-align: center;
            font-size: 25px;
            font-weight: bold;
            color: grey;
        }

        .detail_td_left {
            padding-left: 15px;
            color: gray;
            font-weight: bold;
            font-size: 18px;
        }

        .detail_td_right {
            text-align: center;
            color: gray;
            font-size: 16px;
        }

        .detail_td_img img {
            height: 100px;
            width: 100px;
        }

        .header_before_detail th {
            text-align: center;
        }

        .header_before_detail_td {
            text-align: center;
        }
        .modal{
            margin-top: -30px;
        }
    </style>
</head>
<body>
<table class="table table-striped table-hover">
    <tr class="header_before_detail">
        <th>编号</th>
        <th>公司名</th>
        <th>认证时间</th>
        <th>是否认证</th>
        <th>
            操作
        </th>
    </tr>
    <c:forEach items="${page.list}" var="authentication">
        <tr id="${authentication.id}">
            <td class="header_before_detail_td">${authentication.id}</td>
            <td class="header_before_detail_td">${authentication.companyName}</td>
            <td class="header_before_detail_td">${authentication.createTime}</td>
            <td class="header_before_detail_td">
                <c:if test="${authentication.alsoAuthentication==0}">
                    未认证
                </c:if>
                <c:if test="${authentication.alsoAuthentication==1}">
                    已认证
                </c:if>
            </td>
            <td class="header_before_detail_td">
                <a href="javascript:void(0)" class="btn btn-info" data-toggle="modal" data-target="#myModal${authentication.id}">认证详情</a>
                <a onclick="delete_authentication('${authentication.id}')" class="btn btn-danger">删除</a>

                <!-- 模态框（Modal） -->
                <div class="modal fade" id="myModal${authentication.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-body">

                                <div style="width: 500px;margin: 0px auto;">
                                    <table class="table table-striped table-hover">
                                        <tr>
                                            <td class="modal_title_authorzation" colspan="4">企业认证详情</td>
                                        </tr>
                                        <tr>
                                            <td class="detail_td_left">公司名称：</td>
                                            <td class="detail_td_right">${authentication.companyName}</td>
                                            <td class="detail_td_left">公司邮件：</td>
                                            <td class="detail_td_right">${authentication.companyVO.email}</td>
                                        </tr>
                                        <tr>
                                            <td class="detail_td_left">认证方式：</td>
                                            <td class="detail_td_right">${authentication.documentType}</td>
                                            <td class="detail_td_left">是否认证：</td>
                                            <td class="detail_td_right" style="color: red">
                                                <c:if test="${authentication.alsoAuthentication==0}">
                                                    未认证
                                                </c:if>
                                                <c:if test="${authentication.alsoAuthentication==1}">
                                                    已认证
                                                </c:if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="detail_td_left">正面照片：</td>
                                            <td colspan="3" class="detail_td_img">
                                                <img src="${authentication.fullFacePhoto}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="4" class="detail_td_left">证明材料</td>
                                        </tr>
                                        <tr>
                                            <td class="detail_td_left">个人名片：</td>
                                            <td class="detail_td_img">
                                                <img src="${authentication.personalBusinessCart}"/>
                                            </td>
                                            <td class="detail_td_left">营业执照：</td>
                                            <td class="detail_td_img">
                                                <img src="${authentication.businessLicense}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="detail_td_left">其他材料：</td>
                                            <td class="detail_td_img" colspan="3">
                                                <img src="${authentication.otherMaterial}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="text-align: right" colspan="4">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                <button type="button" class="btn btn-primary" onclick="changeAlsoAuthentication('${authentication.id}')">
                                                    <c:if test="${authentication.alsoAuthentication==0}">
                                                        提交认证
                                                    </c:if>
                                                    <c:if test="${authentication.alsoAuthentication==1}">
                                                        更改认证
                                                    </c:if>
                                                </button>
                                            </td>
                                        </tr>
                                    </table>
                                </div>


                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>

            </td>
        </tr>
    </c:forEach>

</table>

<h3 class="page_h3" align="center">
    <ul class="pagination">
        <c:if test="${requestScope.page.pageIndex!=0}">
            <li>
                <a href="/admin/companyAuthentication/getCompanyAuthenticationByPage?pageId=${page.pageIndex}" aria-label="Previous">
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
                <li class="active"><a href="/admin/companyAuthentication/getCompanyAuthenticationByPage?pageId=${i+1}">${i+1}</a></li>
            </c:if>
            <c:if test="${page.pageIndex!=i}">
                <li><a href="/admin/companyAuthentication/getCompanyAuthenticationByPage?pageId=${i+1}">${i+1}</a></li>
            </c:if>
        </c:forEach>
        <c:if test="${requestScope.page.pageIndex!=requestScope.page.pageTotal}">
            <li>
                <a href="/admin/companyAuthentication/getCompanyAuthenticationByPage?pageId=${page.pageIndex+2}" aria-label="Next">
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


<script type="text/javascript">
    /**
     * 删除一个认证
     * @param id
     */
    function delete_authentication(id) {
        $.ajax(
            {
                type:"post",
                async:false,
                url:"/admin/companyAuthentication/deleteAuthentication",
                data:{
                    id:id
                },
                success:function (id) {
                    $("#"+id).remove();
                },
                dataType:"json"
            }
        )
    }

    /**
     * 改变一个认证的状态：未认证--已认证
     * @param id
     */
    function changeAlsoAuthentication(id) {
        var href=$(".page_h3 .active a").attr("href");
        $.ajax(
            {
                type:"post",
                async:false,
                url:"/admin/companyAuthentication/updateAuthentication",
                data:{
                    id:id
                },
                success:function () {
                    location.href=href;
                },
                dataType:"json"
            }
        )
    }
</script>
</body>
</html>
