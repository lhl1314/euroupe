<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/27 0027
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新闻详情</title>
    <link rel="stylesheet" type="text/css" href="/css/admin/news/newsDetail.css">
    <link rel="stylesheet" type="text/css" href="/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <script type="text/javascript" src="/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>

<body>
<div class="news_content">
    <h1>
        新闻详情
    </h1>
    <table class="table  table-hover">
        <tr>
            <td class="td_right">新闻标题</td>
            <td class="td_center">
                ${newsVo.newsTile}
            </td>
            <td class="td_right">新闻分类</td>
            <td width="160px" class="td_center">
                ${newsVo.newsCategory}
            </td>
        </tr>
        <tr>
            <td class="td_right">编写作者</td>
            <td class="td_center">
                ${newsVo.newsAuthor}
            </td>
            <td class="td_right">
                新闻Logo
            </td>
            <td>
                <div class="newLogo">
                    <img src="${newsVo.newLogo}" id="img" height="80px" width="80px"/>
                </div>
            </td>
        </tr>
    </table>
    <div id="editor">
        ${newsVo.newsContent}
    </div>
    <div id="editor_bottom">
        <a href="/admin/news/getNews?pageId=${pageId}" class="btn btn-primary">返回</a>
        <c:if test="${newsVo.isDelete==1}">
            <a href="javascript:void(0)" class="btn btn-default" disabled="disabled">冻结新闻</a>
            <a href="javascript:void(0)" data-toggle="modal" data-target="#myModal" class="btn btn-info">解冻新闻</a>
        </c:if>
        <c:if test="${newsVo.isDelete==0}">
            <a href="javascript:void(0)" data-toggle="modal" data-target="#myModal" class="btn btn-info">冻结新闻</a>
            <a href="javascript:void(0)" class="btn btn-default" disabled="disabled">解冻新闻</a>
        </c:if>
        <!-- 模态框（Modal） -->
        <div class="confirmModal modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">
                            冻结新闻
                        </h4>
                    </div>
                    <div class="modal-body">
                        <div class="modal-body-left">
                            !
                        </div>
                        <div class="modal-body-right">
                            <c:if test="${newsVo.isDelete==0}">
                                是否确定冻结该用企业！此操作会导致用户无法查询到该企业！
                            </c:if>
                            <c:if test="${newsVo.isDelete==1}">
                                是否确定解冻该用企业！此操作会导致用户可以查询到该企业！
                            </c:if>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default btn-info" data-dismiss="modal">确认返回</button>
                        <button type="button" class="btn btn-primary btn-success"
                                onclick="freezeOrUnfreezeNews('${newsVo.id}','${pageId}')">确认提交
                        </button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal -->
        </div>


    </div>
</div>
<script type="text/javascript" src="/js/admin/news/newsDetail.js"></script>
</body>

</html>