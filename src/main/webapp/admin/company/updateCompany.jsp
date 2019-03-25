<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/16 0016
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改企业</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/admin/company/updateCompany.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
            type="text/javascript"></script>
</head>
<body>
<div style="width: 1000px;margin: 0px auto;">
    <table id="updateCompanyTable" class="table table-striped table-hover">
        <form id="updateCompanyForm" name="fileAndFilesAndObject" action="" method="post" enctype="multipart/form-data">
            <tr>
                <td colspan="5" height="50px" style="text-align: center;font-size: 30px;font-weight: bold;color: grey;">
                    添加企业信息
                </td>
            </tr>
            <tr>
                <td width="200px" class="tr_center">
                    <a href="javascript:void(0)" id="selectLogo">
                        更换logo
                        <span class="warnClass">*</span>
                    </a>
                    <input type="file" style="display: none;" id="upOneImage" name="file" accept="image/*"
                           onchange="upLoad()"/>
                </td>
                <td width="150px" class="color_font_header td_right">
                    企业名称
                    <span class="warnClass">*</span>
                </td>
                <td width="250px" class="color_font_detail">
                    <input type="text" name="id" value="${company.id}" style="display: none;">
                    <input type="text" name="name" value="${company.name}">
                </td>
                <td width="100px" class="color_font_header td_right">
                    手机号
                    <span class="warnClass">*</span>
                </td>
                <td class="color_font_detail">
                    <input type="text" name="mobile" value="${company.mobile}">
                </td>
            </tr>
            <tr>
                <!--下面是企业的logo-->
                <td rowspan="2" class="tr_center">
                    <c:if test="${company.logo==null}">
                        <img id="img" src="/img/a.jpg" height="80px" width="80px"/>
                    </c:if>
                    <c:if test="${company.logo!=null}">
                        <img id="img" src="${company.logo}" height="80px" width="80px"/>
                    </c:if>

                </td>
                <td height="50px" class="color_font_header td_right">
                    网址
                    <span class="warnClass">*</span>
                </td>
                <td class="color_font_detail">
                    <input type="text" name="website" value="${company.website}">
                </td>
                <td class="color_font_header td_right">
                    邮件
                    <span class="warnClass">*</span>
                </td>
                <td class="color_font_detail">
                    <input type="email" name="email" value="${company.email}">
                </td>
            </tr>
            <tr>
                <td height="50px" class="color_font_header td_right">
                    国家
                    <span class="warnClass">*</span>
                </td>
                <td class="color_font_detail">
                    <input type="type" name="country" value="${company.country}">
                </td>
                <td class="color_font_header td_right">
                    详细地址
                    <span class="warnClass">*</span>
                </td>
                <td class="color_font_detail">
                    <textarea name="address" style="resize: none;width: 200px;">${company.address}</textarea>
                </td>
            </tr>

            <tr>
                <td class="color_font_header tr_center">
                    企业描述
                    <span class="warnClass">*</span>
                </td>
                <td colspan="2" class="color_font_detail">
                    <textarea name="description"
                              style="resize: none;width: 349px;height: 100px;">${company.description}</textarea>
                </td>
                <td class="color_font_header td_right">
                    主要业务
                    <span class="warnClass">*</span>
                </td>
                <td class="color_font_detail">
                    猪类食品&nbsp;&nbsp;&nbsp;&nbsp; 进出口猪&nbsp;&nbsp;&nbsp;&nbsp; 鲜肉鲜肉养殖业&nbsp;&nbsp;&nbsp;&nbsp; 进出口猪肉&nbsp;&nbsp;&nbsp;&nbsp;
                    丹麦小猪
                </td>
            </tr>
            <tr>
                <td height="40px" class="tr_center">
                    <a href="javascript:void(0)" id="selectCompanyImage">
                        添加企业图片
                        <span class="warnClass">*</span>
                    </a>
                    <input type="file" style="display: none;" id="companyFileId" multiple="multiple" name="companyFiles"
                           onchange="javascript:setImagePreviews(this.id);" accept="image/*"/>
                </td>
                <td rowspan="2" colspan="4" id="companyImagesId">
                    <c:forEach items="${companyImages}" var="image">
                        <c:if test="${image!=null&&image!=''}">
                            <div style='float:left;margin:12px;' class="oldCompanyImages deleteOldImage">
                                <img class="oldImage" src="${image}"/>
                                <span class="glyphicon glyphicon-remove"></span>
                            </div>
                        </c:if>
                        <c:if test="${image==null||image==''}">
                            <div id="companyExplanation" style="color: grey">
                                该企业暂无企业图片，敬请添加！
                            </div>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td class="color_font_header tr_center">
                    企业图片
                    <span class="warnClass">*</span>
                </td>
            </tr>

            <tr>
                <td height="40px" class="tr_center">
                    <a href="javascript:void(0)" id="selectProductImage">
                        添加企业产品图片
                        <span class="warnClass">*</span>
                    </a>
                    <input type="file" style="display: none;" id="productFileId" multiple="multiple" name="productFiles"
                           onchange="javascript:setImagePreviews(this.id);" accept="image/*"/>
                </td>
                <td rowspan="2" colspan="4" id="productImagesId">
                    <c:forEach items="${productImages}" var="image">
                        <c:if test="${image!=null&&image!=''}">
                            <div style='float:left;margin:12px;' class="oldProductImages deleteOldImage">
                                <img class="oldImage" src="${image}"/>
                                <span class="glyphicon glyphicon-remove"></span>
                            </div>
                        </c:if>
                        <c:if test="${image==null||image==''}">
                            <div id="productExplanation" style="color: grey">
                                该企业暂无产品品图片，敬请添加！
                            </div>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td class="color_font_header tr_center">
                    产品图片
                    <span class="warnClass">*</span>
                </td>
            </tr>
            <tr>
                <td colspan="5" style="height: 40px;text-align: right;">
                    <a href="/admin/company/getCompanyByPage?pageId=${pageId}" class="btn btn-lg btn-info">返回</a>
                    <input type="button" id="submitButton" class="btn btn-primary btn-lg" value="提交更改"/>
                </td>
            </tr>
        </form>
    </table>
</div>

<!-- 模态框（Modal） -->
<div class="warnModal modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">
                    !警告!
                </h4>
            </div>
            <div class="modal-body">
                请将企业<span style="color: firebrick;">
								必填
							</span>信息<span style="color: gold;">填写完全</span>，否则将<span
                    style="color: firebrick;">无法录入</span>系统！
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<script type="text/javascript" src="/js/admin/company/updateCompany.js">

</script>


</body>
</html>
