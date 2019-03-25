<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/11 0011
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>欧企查系统登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          type="text/css"/>
    <link rel="stylesheet" href="/css/adminLogin.css" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
            type="text/javascript"></script>
    <script src="/js/bootstrap.min.js"
            type="text/javascript"></script>
    <style>
        /*定义动画*/
        @-webkit-keyframes spin { /*兼容性写法。spin是关键帧的动画名称*/
            from { /*动画起始状态*/
                -webkit-transform: rotate(0deg);
            }
            to { /*动画结束状态*/
                -webkit-transform: rotate(360deg);
            }
        }
        @keyframes spin {
            from {
                transform: rotate(0deg);
            }
            to {
                transform: rotate(360deg);
            }
        }
        /*定义动画*/
        @-webkit-keyframes spin1 { /*兼容性写法。spin是关键帧的动画名称*/
            from { /*动画起始状态*/
                -webkit-transform: rotate(360deg);
            }
            to { /*动画结束状态*/
                -webkit-transform: rotate(0deg);
            }
        }
        @keyframes spin1 {
            from {
                transform: rotate(360deg);
            }
            to {
                transform: rotate(0deg);
            }
        }
        .login form{
            position: relative;
        }
        #codeImage{
            position: absolute;
            /*bottom: 65px;*/
            bottom:93px;
            right: 0px;
        }
        @font-face{
            font-family: myFirstFont;
            src: url('/fonts/maozedong.ttf'), url('/fonts/maozedong.ttf');
            /* IE9 */
        }
        .login{
            height: 430px;
        }
        .close_left{
            position: absolute;
            left: 30px;
            top: 14px;
            -webkit-animation: spin 1s linear infinite;/*鼠标hover时，i图标旋转,infinite表示动画无限循环*/
            animation: spin 5s linear infinite;
        }
        .close_right{
            position: absolute;
            right: 30px;
            top: 14px;
            -webkit-animation: spin1 1s linear infinite;/*鼠标hover时，i图标旋转,infinite表示动画无限循环*/
            animation: spin1 5s linear infinite;
        }



        .fogetPassword .modal-dialog {
            width: 400px;
            height: 400px;
            margin-top: -5px;
        }

        .fogetPassword .modal-body {
            background: blanchedalmond;
        }

        #sendAfather {
            position: relative;
        }

        #sendAfather a {
            position: absolute;
            right: 40px;
            top: 18px;
        }
    </style>
</head>
<body>
<div class="login_box">
    <div class="login_l_img"><img src="/img/login-img.png" /></div>
    <div class="login">
        <%--<div class="login_logo"><a href="#"><img src="/img/login_logo.png" /></a></div>--%>
        <div class="login_logo close_left"><a href="#"><img src="/img/login_logo.png" /></a></div>
        <div class="login_logo close_right"><a href="#"><img src="/img/login_logo.png" /></a></div>
        <div class="login_name">
            <p style="font-family:myFirstFont;font-weight: bold;font-size: 20px">欧企查系统</p>
        </div>
        <form action="" method="post">
            <input name="name" type="text"  value="用户名" onfocus="this.value='';this.style.color='black'" onblur="if(this.value==''){this.value='用户名'}">
            <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';" >密码</span>
            <input name="password" type="password" id="password" style="display:none;" onfocus="this.value='';this.style.color='black'" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
            <input type="text" name="verify" id="verifyCode" value="验证码" onfocus="this.value='',this.style.color='black'" onblur="if(this.value==''){this.value='验证码'}">
            <img type="image" src="/login/authCode" height="48px" id="codeImage" onclick="chageCode()"
                 title="图片看不清？点击重新得到验证码" style="cursor:pointer;"/>

            <p style="text-align: right">
                <a href="javascript:void(0)" data-toggle="modal" data-target="#myModal">忘记密码?</a>
            </p>
            <input style="width:100%;font-weight: bold;color: goldenrod;font-size: 20px;" value="登录" id="adminLogin" type="button">


        </form>
    </div>

    <div class="fogetPassword">
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" style="text-align: center;font-weight: bold;" id="myModalLabel">忘记密码</h4>
                    </div>
                    <div class="modal-body">

                        <form class="form-horizontal" role="form">
                            <div id="sendAfather" class="form-group">
                                <label for="phone" class="col-sm-4 control-label">手机号</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" id="phone" placeholder="请输入手机号">
                                </div>
                                <a href="javascript:void(0)" onclick="sendVerifyCode()">发送验证码</a>
                            </div>
                            <div class="form-group">
                                <label for="flgetverifyCode" class="col-sm-4 control-label">验证码</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" id="flgetverifyCode" placeholder="请输入验证码">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="fgetPassword" class="col-sm-4 control-label">密码</label>
                                <div class="col-sm-5">
                                    <input type="password" class="form-control" id="fgetPassword" placeholder="请输入密码">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-4 col-sm-6">
                                    <button type="button" id="refund" data-dismiss="modal" class="btn btn-default">返回</button>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <button type="button" id="forgetPasswordChang" class="btn btn-default">确定</button>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal -->
        </div>

    </div>
    <div class="copyright">温州欧企查网络科技有限公司 版权所有© 技术支持电话：000-00000000</div>
</div>

<script>
    /**
     * 更换验证码
    * */
    function chageCode() {
        $("#codeImage").attr("src", "/login/authCode?abc="
            + Math.random());//链接后添加Math.random，确保每次产生新的验证码，避免缓存问题。
    };
    /**
     * 管理员登录
     * */
    $("#adminLogin").click(function () {
        var name=$(".login form input[name='name']").val();
        var adminPassword=$(".login form input[name='password']").val();
        var verifyCode=$(".login form input[name='verify']").val();
        $.ajax(
            {
                url:"/back/login",
                data:{
                    name:name,
                    password:adminPassword,
                    verifyCode:verifyCode
                },
                success:function (msg) {
                    if (msg==1){
                        //用户成功登录
                        location.href="/back/toHome"
                    }
                    if (msg==0){
                        //账号或者密码错误
                        var s="账号或者密码错误";
                        $(".login form input[name='password']").val(s);
                        $(".login form input[name='name']").val(s);
                        $(".login form input[name='password']").css("color","red");
                        $(".login form input[name='name']").css("color","red");
                    }
                    if(msg==-1){
                        //验证码错误
                        var s="验证码错误";
                        $(".login form input[name='verify']").val(s);
                        $(".login form input[name='verify']").css("color","red");
                    }
                }
            }
        )
    });

    /**
     * 触发更换验证码
     */
    $("#verifyCode").focus(function () {
        $("#verifyCode").val("");
        $("#verifyCode").css("color", "black");
        //更换验证码
        chageCode();
    });


    /**
     * 发送验证码
     */
    function sendVerifyCode() {
        var phone=$("#phone").val();
        if (phone!=""){
            $.ajax(
                {
                    type:"post",
                    async:false,
                    url:"/back/adminSendPassword",
                    data:{
                        phone:phone
                    },
                    success:function (msg) {
                        alert(msg);
                    },
                    dataType:"json"
                }
            );
        } else {
            alert("请输入手机号")
        }
    }

    /**
     * 忘记密码确认修改账户密码
     */
    $("#forgetPasswordChang").click(function () {
        var phone=$("#phone").val();
        var verifyCode=$("#flgetverifyCode").val();
        var password=$("#fgetPassword").val();

        if (phone!=""&&verifyCode!=""&&password!=""){
            $.ajax(
                {
                    type:"post",
                    async:false,
                    url:"/back/forgetPasswordUpdate",
                    data:{
                        phone:phone,
                        verifyCode:verifyCode,
                        password:password
                    },
                    success:function (msg) {
                        if (msg==1){
                            alert("账户找回成功")
                        } else {
                            alert("服务器正忙，请稍后再试！")
                        }
                    },
                    dataType:"json"
                }
            );
        } else {
            alert("请将信息填写完全")
        }

    });
</script>
</body>
</html>
