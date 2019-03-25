<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/26 0026
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>新闻信息</title>
    <link rel="stylesheet" type="text/css" href="/css/admin/news/news.css">
    <link rel="stylesheet" type="text/css" href="/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <script type="text/javascript" src="/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body>
<table class="table table-striped table-hover">
    <tr>
        <th>编号</th>
        <th>新闻标题</th>
        <th>新闻作者</th>
        <th>新闻Logo</th>
        <th>新闻分类</th>
        <th>发布时间</th>
        <th>
            <a href="javascript:void(0)" class="btn btn-danger">操作</a>
            <a href="/admin/news/toAddNews" class="btn btn-info">添加新闻</a>
        </th>
    </tr>
    <c:forEach items="${page.list}" var="news">
        <tr id="${news.id}">
            <td>${news.id}</td>
            <td>${news.newsTile}</td>
            <td>${news.newsAuthor}</td>
            <td>
                <img src="${news.newLogo}" height="60px" width="60px">
            </td>
            <td>${news.newsCategory}</td>
            <td>${news.publishTime}</td>
            <td>
                <a href="/admin/news/getNewsDetail?id=${news.id}&&pageId=${page.pageIndex+1}"
                   class="btn btn-info">查看详情</a>
                <a class="btn btn-info" data-toggle="modal" data-target="#myModal${news.id}">删除</a>
                <!-- 模态框（Modal） -->
                <div class="confirmModal modal fade" id="myModal${news.id}" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel${news.id}" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel${news.id}">
                                    删除：
                                    <c:if test="${news.newsTile.length()>11}">
                                        ${fn:substring(news.newsTile,0,11)}...
                                    </c:if>
                                    <c:if test="${news.newsTile.length()<=11}">
                                        ${fn:substring(news.newsTile,0,11)}
                                    </c:if>
                                </h4>
                            </div>
                            <div class="modal-body">
                                <div class="modal-body-left">
                                    !
                                </div>
                                <div class="modal-body-right">
                                    是否确定删除该则新闻，删除后则不会恢复查询到该则新闻！
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default btn-info" data-dismiss="modal">确认返回
                                </button>
                                <button type="button" class="btn btn-primary btn-success"
                                        onclick="deleteNews('${news.id}')">确认删除
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
<h3 align="center" class="page_h3">
    <ul class="pagination">
        <c:if test="${requestScope.page.pageIndex!=0}">
            <li>
                <a href="/admin/news/getNews?pageId=${page.pageIndex}" aria-label="Previous">
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
                <li class="active"><a href="/admin/news/getNews?pageId=${i+1}">${i+1}</a></li>
            </c:if>
            <c:if test="${page.pageIndex!=i}">
                <li><a href="/admin/news/getNews?pageId=${i+1}">${i+1}</a></li>
            </c:if>
        </c:forEach>
        <c:if test="${requestScope.page.pageIndex!=requestScope.page.pageTotal}">
            <li>
                <a href="/admin/news/getNews?pageId=${page.pageIndex+2}" aria-label="Next">
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

<script type="text/javascript" src="/js/admin/news/news.js"></script>

</body>
</html>
