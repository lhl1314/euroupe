<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/19 0019
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>帮助中心</title>
    <meta charset="UTF-8">

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
        .confirmModal .modal-dialog{
            width: 800px;
            margin: 0px auto;
        }
        .confirmModal .modal-body{
            width: 100%;
            height: 560px;
            overflow: auto;
        }
        #questionAndAnswerTable{

        }
        .center_left{
            text-align: center;
        }
        .modal-title{
            text-align: center;
            font-size: 25px;
            font-weight: bold;
        }
        .control_right{
            cursor: pointer;
        }
        .header_help_center{
            text-align: center;
        }

        .help_question_answer{
            font-size: 16px;
            font-weight: bold;
            color: grey;
        }
        .help_question_answer_content{
            font-size: 14px;
            color:dimgray;
        }
    </style>
</head>
<body>


<table class="table table-striped table-hover">
    <tr>
        <th class="header_help_center">编号</th>
        <th>标题</th>
        <th>创建时间</th>
        <th class="header_help_center">
            <span class="btn btn-info">操作</span>
            <a href="javascript:void(0)" class="btn btn-danger" data-toggle="modal" data-target="#myModal">添加</a>
            <!-- 模态框（Modal） -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabeladdTitle" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form class="form-horizontal" role="form" action="/admin/help/addHelpHeaderContent">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabeladdTitle">添加帮助模块</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="helpCenterHeaderTitle" class="col-sm-2 control-label">标题：</label>
                                <div class="col-sm-10">
                                    <textarea name="helpCenterHeaderName" required style="resize: none;" id="helpCenterHeaderTitle" class="form-control"></textarea>
                                </div>
                            </div>

                                <div class="form-group">
                                    <label for="firstQuestion" class="col-sm-2 control-label">问题：</label>
                                    <div class="col-sm-10">
                                        <textarea name="question" required style="resize: none;" id="firstQuestion" class="form-control"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="firstAnswer" class="col-sm-2 control-label">答案：</label>
                                    <div class="col-sm-10">
                                        <textarea name="answer" required style="resize: none;" id="firstAnswer" class="form-control"></textarea>
                                    </div>
                                </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <input type="submit" class="btn btn-primary"></input>
                        </div>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
        </th>
    </tr>
    <c:forEach var="helpCenterHeader" items="${page.list}">
        <tr id="${helpCenterHeader.id}">
            <td class="header_help_center">${helpCenterHeader.id}</td>
            <td>${helpCenterHeader.helpCenterHeaderName}</td>
            <td>${helpCenterHeader.createTime}</td>
            <td class="header_help_center">
                <a data-toggle="modal" class="btn btn-info" data-target="#myModal${helpCenterHeader.id}">详情</a>
                <a class="btn btn-warning" onclick="deleteHelpCenterHeader('${helpCenterHeader.id}')">删除</a>
                <!-- 模态框（Modal） -->
                <div class="confirmModal modal fade" id="myModal${helpCenterHeader.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">${helpCenterHeader.helpCenterHeaderName}</h4>
                            </div>
                            <div class="modal-body">
                                <table id="questionAndAnswerTable" class="table table-striped table-hover">
                                    <tr>
                                        <th class="center_left">标题：</th>
                                        <th colspan="2">${helpCenterHeader.helpCenterHeaderName}</th>
                                    </tr>
                                    <tr>
                                        <td class="center_left help_question_answer">问题：</td>
                                        <td><textarea class="help_question_answer_content" id="question" style="height: 30px; width: 100%;resize: none;"></textarea></td>
                                        <td rowspan="2" onclick="addHelpContent('${helpCenterHeader.id}')" class="center_left control_right btn-primary">
                                            添加
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="center_left help_question_answer">答案：</td>
                                        <td>
                                            <textarea class="help_question_answer_content" id="answer" style="height: 60px;width: 100%;resize: none;"></textarea>
                                        </td>
                                    </tr>
                                    <c:forEach var="helpCenter" items="${helpCenterHeader.helpCenterVos}">
                                        <tr class="${helpCenter.id}">
                                            <td class="center_left help_question_answer" width="10%">问题：</td>
                                            <td class="help_question_answer_content" width="90%" colspan="2">${helpCenter.question}</td>
                                        </tr>
                                        <tr class="${helpCenter.id}">
                                            <td class="center_left help_question_answer">答案：</td>
                                            <td class="help_question_answer_content">${helpCenter.answer}</td>
                                            <td width="10%" onclick="deleteHelpContent('${helpCenter.id}')" class="center_left btn-warning control_right">删除</td>
                                        </tr>
                                    </c:forEach>
                                </table>


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
                <a href="/admin/help/getAllHelpByPage?pageId=${page.pageIndex}" aria-label="Previous">
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
                <li class="active"><a href="/admin/help/getAllHelpByPagepageId=${i+1}">${i+1}</a></li>
            </c:if>
            <c:if test="${page.pageIndex!=i}">
                <li><a href="/admin/help/getAllHelpByPage?pageId=${i+1}">${i+1}</a></li>
            </c:if>
        </c:forEach>
        <c:if test="${requestScope.page.pageIndex!=requestScope.page.pageTotal}">
            <li>
                <a href="/admin/help/getAllHelpByPage?pageId=${page.pageIndex+2}" aria-label="Next">
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
     * 添加帮助问题的问题和答案
     */
    function addHelpContent(helpTitleId) {
        var question=$("#question").val();
        var answer=$("#answer").val();
        if (question==""||answer==""){
            alert("请将需要添加帮助的问题和答案填写完全");
        }else {
            $.ajax(
                {
                    url:"/admin/help/addHelpCenter",
                    data:{
                        helpTitleId:helpTitleId,
                        question:question,
                        answer:answer
                    },
                    success:function (helpCenterId) {
                        var  s="<tr class="+helpCenterId+">\n"+
                            "<td class=\"center_left\" width=\"10%\">问题：</td>\n" +
                            "<td width=\"90%\" colspan=\"2\">"+question+"</td>\n" +
                            "</tr>\n" +
                            "<tr class="+helpCenterId+">\n" +
                            "<td class=\"center_left\">答案：</td>\n" +
                            "<td>"+answer+"</td>\n" +
                            "<td class='center_left btn-warning control_right' width=\"10%\" onclick='deleteHelpContent("+helpCenterId+")'>删除</td>"+
                        "</tr>";
                        $("#questionAndAnswerTable").append(s);
                        $("#questionAndAnswerTable textarea").val("");
                        $('.modal-body').scrollTop($('.modal-body')[0].scrollHeight);
                    }
                }
            );

        };
    };

    /**
     * 删除一个帮助问题和答案
     * @param id
     */
    function deleteHelpContent(id) {
        if (confirm("该操作会导致此问题答案被删除！不可撤销。")){
          $.ajax(
              {
                  type: "post",
                  async: false,
                  url:"/admin/help/deleteHelpContent",
                  data:{
                      id:id
                  },
                  success:function (id) {
                     $("."+id).remove();
                  },
                  dataType:"json"
              }
          );
        };
    };

    /**
     * 删除一个帮助模块
     * @param id
     */
    function deleteHelpCenterHeader(id) {
        if (confirm("此操作不可撤销！确定吗?")){
            $.ajax(
                {
                    type:"post",
                    async:false,
                    url:"/admin/help/deleteHelpCenterHeader",
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
    }



</script>

</body>
</html>
