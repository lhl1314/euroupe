<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        BODY {
            MARGIN: 0px;
            BACKGROUND-COLOR: #ffffff
        }

        BODY {
            FONT-SIZE: 12px;
            COLOR: #000000
        }

        TD {
            FONT-SIZE: 12px;
            COLOR: #000000
        }

        TH {
            FONT-SIZE: 12px;
            COLOR: #000000
        }
        @font-face{
            font-family: myFirstFont;
            src: url('/fonts/maozedong.ttf'), url('/fonts/maozedong.ttf');
            /* IE9 */
        }
    </style>
    <link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
            type="text/javascript"></script>
    <script src="/js/bootstrap.min.js"
            type="text/javascript"></script>
</HEAD>
<body>
<table width="100%" height="70%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td>
            <img width="100%" src="${pageContext.request.contextPath}/images/top_01.jpg">
        </td>
        <td width="100%"  style="text-align: center; font-family:myFirstFont; font-size: 35px;font-weight: bold;border: 0px" background="${pageContext.request.contextPath}/images/bt_02.jpg;">
            欧企查后台管理系统
        </td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td height="30" valign="bottom"
            background="${pageContext.request.contextPath}/images/mis_01.jpg">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="85%" align="left">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <font color="#000000">
                            <script language="JavaScript">
                                <!--
                                tmpDate = new Date();
                                date = tmpDate.getDate();
                                month = tmpDate.getMonth() + 1;
                                year = tmpDate.getFullYear();
                                document.write(year);
                                document.write("年");
                                document.write(month);
                                document.write("月");
                                document.write(date);
                                document.write("日 ");


                                myArray = new Array(6);
                                myArray[0] = "星期日"
                                myArray[1] = "星期一"
                                myArray[2] = "星期二"
                                myArray[3] = "星期三"
                                myArray[4] = "星期四"
                                myArray[5] = "星期五"
                                myArray[6] = "星期六"
                                weekday = tmpDate.getDay();
                                if (weekday == 0 | weekday == 6) {
                                    document.write(myArray[weekday])
                                }
                                else {
                                    document.write(myArray[weekday])
                                }
                                ;
                                // -->
                            </script>
                        </font>
                    </td>
                    <td width="15%">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="16"
                                    background="${pageContext.request.contextPath}/images/mis_05b.jpg">
                                    <img
                                            src="${pageContext.request.contextPath}/images/mis_05a.jpg"
                                            width="6" height="18">
                                </td>
                                <td width="155" valign="bottom"
                                    background="${pageContext.request.contextPath}/images/mis_05b.jpg">
                                    管理员：
                                    ${fn:substring(sessionScope.user.mobile, 0, 6)}...&nbsp;
                                    <a href="${pageContext.request.contextPath}/back/loginOut"
                                       target="_top">注销</a>
                                    <a href="${pageContext.request.contextPath}/back/toUpdatePassword"  target="mainFrame">修改账户</a>
                                    <!-- 按钮触发模态框 -->
                                </td>
                                <td width="10" align="right"
                                    background="${pageContext.request.contextPath}/images/mis_05b.jpg">
                                    <img src="${pageContext.request.contextPath}/images/mis_05c.jpg" width="6"
                                         height="18">
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td align="right" width="5%">
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</HTML>
