<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/27 0027
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>客服会话</title>
    <link rel="stylesheet" href="/css/admin/kefu/kefu.css">
    <link rel="stylesheet" href="/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="/css/admin/kefu/kefu.css" type="text/css"/>
    <script type="text/javascript" src="/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>

<body>
<div class="chat_box">
    <div class="chat_box_left">
        <div class="chat_box_left_header" id="${sessionScope.user.id}">
            <div class="header_left">
                <img src="/img/10.jpg">
            </div>
            <div class="header_right">${sessionScope.user.mobile}</div>
        </div>
        <div class="chat_box_left_reminder">
            欧企查系统客服咨询列表
        </div>
        <ul class="chat_box_left_bottom">

            <c:forEach items="${voList}" var="account">
                <li id="${account.id}">
                    <div class="li_left">
                        <img src="/img/10.jpg"/>
                    </div>
                    <div class="li_right">
							<span class="account">
                                    ${fn:substring(account.mobile,0,5)}...
										<c:if test="${account.noReadCount!=0}">
                                            <i style="color: brown;"
                                               class="messageColor glyphicon glyphicon-envelope"></i>
                                        </c:if>
							</span>

                        <span class="account_accept_message">
                               <c:if test="${account.noReadCount!=0}">
                                   新消息${account.noReadCount}条
                               </c:if>
                            </span>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="chat_box_right">
        <div class="chat_box_right_header">
            <!--			正在与账户<span>用户一</span>的用户进行在线会话-->
        </div>
        <div class="chat_box_right_center">
            <div class="content">
            </div>
        </div>
        <div class="chat_box_right_bottom">
            <textarea id="textarea"></textarea>
            <button class="sendBtn">发送</button>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/admin/kefu/kefu.js"></script>

</body>

</html>