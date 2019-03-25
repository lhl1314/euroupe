<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/18 0018
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>企业详情</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/admin/company/companyDetail.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
            type="text/javascript"></script>
</head>
<body>
<div style="width: 1000px;margin:-2px auto;">
    <table class="table table-striped table-hover">
        <tr>
            <td colspan="5" height="50px" style="text-align: center;font-size: 30px;font-weight: bold;color: grey">
                企业详情
            </td>
        </tr>
        <tr>
            <td rowspan="4">
                <img src="${company.logo}" height="100px" width="100px"/>
            </td>
        </tr>
        <tr>
            <td width="150px" class="color_font_header">企业名称</td>
            <td width="250px" class="color_font_detail">
                ${company.name}
            </td>
            <td width="100px" class="color_font_header">手机号</td>
            <td class="color_font_detail">
                ${company.mobile}
            </td>
        </tr>
        <tr>
            <td class="color_font_header">网址</td>
            <td class="color_font_detail">
                ${company.website}
            </td>
            <td class="color_font_header">邮件</td>
            <td class="color_font_detail">
                ${company.email}
            </td>
        </tr>
        <tr>
            <td class="color_font_header">国家</td>
            <td class="color_font_detail">
                ${company.country}
            </td>
            <td class="color_font_header">详细地址</td>
            <td class="color_font_detail">
                ${company.address}
            </td>
        </tr>

        <tr>
            <td class="color_font_header">
                企业描述
            </td>
            <td colspan="2" class="color_font_detail">
                ${company.description}
            </td>
            <td class="color_font_header">主要业务</td>
            <td class="color_font_detail">
                猪类食品&nbsp;&nbsp;&nbsp;&nbsp; 进出口猪&nbsp;&nbsp;&nbsp;&nbsp; 鲜肉鲜肉养殖业&nbsp;&nbsp;&nbsp;&nbsp; 进出口猪肉&nbsp;&nbsp;&nbsp;&nbsp;
                丹麦小猪
            </td>
        </tr>
        <tr>
            <td class="color_font_header">
                企业图片
            </td>
            <td colspan="4">
                <c:forEach items="${companyImages}" var="image">
                    <img src="${image}">&nbsp;&nbsp;&nbsp;&nbsp;
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td class="color_font_header">
                产品图片
            </td>
            <td colspan="4">
                <c:forEach items="${productImages}" var="image">
                    <img src="${image}">&nbsp;&nbsp;&nbsp;&nbsp;
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td colspan="5" style="height: 40px;text-align: right">
                <a href="/admin/company/getCompanyByPage?pageId=${pageId}" class="btn btn-info">返回</a>
                <c:if test="${company.isDelete==1}">
                    <a href="javascript:void(0)" class="btn btn-default" disabled="disabled">冻结企业</a>
                    <a href="javascript:void(0)" class="btn btn-info" data-toggle="modal"
                       data-target="#myModal">解冻企业</a>
                </c:if>
                <c:if test="${company.isDelete==0}">
                    <a href="javascript:void(0)" class="btn btn-info" data-toggle="modal"
                       data-target="#myModal">冻结企业</a>
                    <a href="javascript:void(0)" class="btn btn-default" disabled="disabled">解冻企业</a>
                </c:if>
                <!-- 模态框（Modal） -->
                <div class="confirmModal modal fade" id="myModal" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">
                                    冻结企业:
                                    ${fn:substring(company.name,0,5)}...
                                </h4>
                            </div>
                            <div class="modal-body">
                                <div class="modal-body-left">
                                    !
                                </div>
                                <div class="modal-body-right">
                                    <c:if test="${company.isDelete==0}">
                                        是否确定冻结该用企业！此操作会导致用户无法查询到该企业！
                                    </c:if>
                                    <c:if test="${company.isDelete==1}">
                                        是否确定解冻该用企业！此操作会导致用户可以查询到该企业！
                                    </c:if>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default btn-info" data-dismiss="modal">确认返回
                                </button>
                                <button type="button" class="btn btn-primary btn-success"
                                        onclick="freezeOrUnfreezeCompany('${company.id}','${pageId}')">确认提交
                                </button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal -->
                </div>


            </td>
        </tr>
    </table>

</div>
<script type="text/javascript" src="/js/admin/company/companyDetail.js"></script>
</body>
</html>
