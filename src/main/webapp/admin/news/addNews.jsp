<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/26 0026
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>添加新闻</title>
    <link rel="stylesheet" type="text/css" href="/css/admin/news/addNews.css">
    <link rel="stylesheet" type="text/css" href="/wangEditor-3.1.1/release/wangEditor.min.css"/>
    <link rel="stylesheet" type="text/css" href="/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <script type="text/javascript" src="/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>

<body>
<div class="news_content">
    <h1>
        添加新闻动态
    </h1>
    <form id="formNews" action="#" method="post" enctype="multipart/form-data">
        <table class="table  table-hover">
            <tr>
                <td class="td_right">
                    新闻标题
                    <span class="warnClass">*</span>
                </td>
                <td>
                    <input type="text" name="title" class="form-control"/>
                </td>
                <td class="td_right">
                    新闻分类
                    <span class="warnClass">*</span>
                </td>
                <td width="160px">
                    <input type="text" name="category" class="form-control"/>
                </td>
            </tr>
            <tr>
                <td class="td_right">
                    编写作者
                    <span class="warnClass">*</span>
                </td>
                <td>
                    <input type="text" name="author" class="form-control"/>
                </td>
                <td class="td_right">
                    <a href="javascript:void(0)" id="selectNewsLogo">选择新闻Logo</a>
                    <span class="warnClass">*</span>
                    <input type="file" style="display: none" name="file" id="upimg" accept="image/*"
                           onchange="upLoad()"/>
                </td>
                <td>
                    <div class="newLogo">
                        <img src="../img/10.jpg" id="img" height="80px" width="80px"/>
                    </div>
                </td>
            </tr>
        </table>
        <textarea id="getEditorContent" style="display: none" name="content"></textarea>
        <div id="editor">

        </div>
        <div id="editor_bottom">
            <input type="button" id="submitNew" value="提交系统"/>
        </div>
    </form>
</div>

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
                请将<span style="color: firebrick;">
								必填
							</span>信息<span style="color: gold;">填写完全</span>，否则将<span
                    style="color: firebrick;">无法录入</span>系统！
            </div>

        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<script type="text/javascript" src="/wangEditor-3.1.1/release/wangEditor.js"></script>
<script type="text/javascript" src="/js/admin/news/addNews.js"></script>
</body>

</html>