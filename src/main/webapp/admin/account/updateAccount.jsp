<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/21 0021
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
            type="text/javascript"></script>
    <style>
        body {
            background: gainsboro;
        }
        .content {
            height: 400px;
            width: 600px;
            margin: 100px auto;
            border: 1px solid darkkhaki;
            padding: 20px;
        }
    </style>
</head>
<body>
<div class="content">
    <h2 style="text-align: center;">修改账户密码</h2>
    <form id="ChangAccountForm" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">手机号：</label>
            <div class="col-sm-10">
                <input type="text" name="mobile" class="form-control" id="phone" placeholder="请输入手机号">
            </div>
        </div>
        <div class="form-group">
            <label for="firstpassword" class="col-sm-2 control-label">旧密码：</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="firstpassword" placeholder="请输入旧密码">
            </div>
        </div>
        <div class="form-group">
            <label for="lastpassword" class="col-sm-2 control-label">新密码：</label>
            <div class="col-sm-10">
                <input type="password" name="newPassword" class="form-control" id="lastpassword" placeholder="请输入新密码">
            </div>
        </div>
        <p>温馨提示：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机号务必填写可通信的号码！方便忘记密码的找回！</p>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" id="submitChangAccouont" class="btn btn-default">确认更改</button>
            </div>
        </div>
    </form>

</div>
<button id="clifsa" style="display: none">点我</button>

<script type="text/javascript">
    $("#clifsa").click(function () {

        window.top.location.href="/back/loginOut";
    });
    $("#submitChangAccouont").click(function () {
        var oldPassword=$("#firstpassword").val();
        var mobile=$("#phone").val();
        var newPassword=$("#lastpassword").val();
        if (oldPassword!=""&&mobile!=""&&newPassword!=""){
            $.ajax(
                {
                    type:"post",
                    async:false,
                    url:"/back/adminOnlineChangAccount",
                    data:{
                        mobile:mobile,
                        oldPassword:oldPassword,
                        newPassword:newPassword
                    },success:function (msg) {
                        if (msg==0){
                            alert("该手机号账户已经存在")
                        }
                        if (msg==1){
                            alert("修改成功");
                            window.top.location.href="/back/loginOut";
                        }
                        if (msg==-1){
                            alert("账户登录异常，即将退出登录");
                            window.top.location.href="/back/loginOut";
                        }
                    },
                    dataType:"json"
                }
            );
        }else {
            alert("请将信息填写完全");
        }
    });
</script>
</body>
</html>
