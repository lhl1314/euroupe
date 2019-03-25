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
    <title>添加企业</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/admin/company/addCompany.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
            type="text/javascript"></script>
</head>
<body>

<div style="width: 1000px;margin: 0px auto;">
    <table class="table table-striped table-hover">
        <form id="addCompanyForm" action="" method="post" enctype="multipart/form-data">
            <tr>
                <td colspan="5" height="50px" style="text-align: center;font-size: 30px;font-weight: bold;color: grey;">
                    添加企业信息
                </td>
            </tr>
            <tr>
                <td width="200px" class="tr_center">
                    <a href="javascript:void(0)" id="selectLogo">
                        选择logo
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
                    <input type="text" name="name">
                </td>
                <td width="100px" class="color_font_header td_right">
                    手机号
                    <span class="warnClass">*</span>
                </td>
                <td class="color_font_detail">
                    <input type="text" name="mobile">
                </td>
            </tr>
            <tr>
                <!--下面是企业的logo-->
                <td rowspan="2" class="tr_center">
                    <img id="img" src="/img/a.jpg" height="80px" width="80px"/>
                </td>
                <td height="50px" class="color_font_header td_right">
                    网址
                    <span class="warnClass">*</span>
                </td>
                <td class="color_font_detail">
                    <input type="text" name="website">
                </td>
                <td class="color_font_header td_right">
                    邮件
                    <span class="warnClass">*</span>
                </td>
                <td class="color_font_detail">
                    <input type="email" name="email">
                </td>
            </tr>
            <tr>
                <td height="50px" class="color_font_header td_right">
                    国家
                    <span class="warnClass">*</span>
                </td>
                <td class="color_font_detail">
                    <input type="type" name="country">
                </td>
                <td class="color_font_header td_right">
                    详细地址
                    <span class="warnClass">*</span>
                </td>
                <td class="color_font_detail">
                    <textarea name="address" style="resize: none;width: 200px;"></textarea>
                </td>
            </tr>

            <tr>
                <td class="color_font_header tr_center">
                    企业描述
                    <span class="warnClass">*</span>
                </td>
                <td colspan="2" class="color_font_detail">
                    <textarea name="description" style="resize: none;width: 349px;height: 100px;"></textarea>
                </td>
                <td class="color_font_header td_right">
                    主要业务
                    <span class="warnClass">*</span>
                </td>
                <td class="color_font_detail">
                    <textarea name="keyword" style="resize: none;width: 300px;height: 100px;"></textarea>
                </td>
            </tr>

            <tr>
                <td class="color_font_header tr_center">企业类型</td>
                <td colspan="4">
                    <select name="type" style="height: 40px;width: 350px;text-align: center">
                        <option value="2">在欧华企</option>
                        <option value="3">欧洲企业</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td height="40px" class="tr_center">
                    <a href="javascript:void(0)" id="selectCompanyImage">
                        选择企业图片
                        <span class="warnClass">*</span>
                    </a>
                    <input type="file" style="display: none;" id="companyFileId" multiple="multiple" name="companyFiles"
                           onchange="javascript:setImagePreviews(this.id);" accept="image/*"/>
                </td>
                <td rowspan="2" colspan="4" id="companyImagesId">

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
                        选择企业产品图片
                        <span class="warnClass">*</span>
                    </a>
                    <input type="file" style="display: none;" id="productFileId" multiple="multiple" name="productFiles"
                           onchange="javascript:setImagePreviews(this.id);" accept="image/*"/>
                </td>
                <td rowspan="2" colspan="4" id="productImagesId">

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
                    <a href="/admin/company/getCompanyByPage" class="btn btn-lg btn-info">返回</a>
                    <input type="button" id="submitButton" class="btn btn-primary btn-lg" value="提交"/>
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
<script type="text/javascript" src="/js/admin/company/addCompany.js"></script>


</body>
</html>
