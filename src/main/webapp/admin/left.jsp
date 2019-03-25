<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>菜单</title>
    <link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
    <link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css"/>
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td height="12"></td>
    </tr>
</table>
<table width="100%" border="0">
    <tr>
        <td>
            <div class="dtree">

                <a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>

                <script type="text/javascript"
                        src="${pageContext.request.contextPath}/js/dtree.js"></script>
                <script type="text/javascript">

                    d = new dTree('d');
                    d.add('01', -1, '系统菜单树');
                    <shiro:hasAnyRoles name="admin,普通管理员">
                    d.add('0101', '01', '用户管理', '', '', 'mainFrame');
                    d.add('010101', '0101', '普通用户',
                        '${pageContext.request.contextPath}/admin/user/getPageUsers?', '', 'mainFrame');
                    d.add('0102', '01', '分类管理', '', '', 'mainFrame');
                    d.add('010201', '0102', '分类管理',
                        '${pageContext.request.contextPath}/admin/category/findCategories.do', '',
                        'mainFrame');
                    d.add('0103', '01', '企业管理', '', '', 'mainFrame');
                    d.add('010301', '0103', '企业管理',
                        '${pageContext.request.contextPath}/admin/company/getCompanyByPage', '',
                        'mainFrame');
                    d.add('010302', '0103', '添加企业',
                        '${pageContext.request.contextPath}/admin/company/toAddCompanyUpload', '',
                        'mainFrame');
                    d.add('010303', '0103', '认证管理',
                        '${pageContext.request.contextPath}/admin/companyAuthentication/getCompanyAuthenticationByPage', '',
                        'mainFrame');
                    </shiro:hasAnyRoles>
                    d.add('0104', '01', '新闻管理');
                    d.add('010401', '0104', '新闻管理',
                        '${pageContext.request.contextPath}/admin/news/getNews', '', 'mainFrame');
                    d.add('010402', '0104', '添加新闻',
                        '${pageContext.request.contextPath}/admin/news/toAddNews', '', 'mainFrame');

                    <shiro:hasAnyRoles name="admin,普通管理员">
                    d.add('0105', '01', '订单管理');
                    d.add('010501', '0105', '订单管理',
                        '${pageContext.request.contextPath}/admin/order/findOrders.do', '', 'mainFrame');

                    </shiro:hasAnyRoles>


                    <shiro:hasRole name="admin">
                    d.add('0106', '01', '权限管理');
                    d.add('010601', '0106', '账户管理',
                        '${pageContext.request.contextPath}/back/getAccountByPage', '', 'mainFrame');
                    </shiro:hasRole>
                    d.add('0107', '01', '客服管理');
                    d.add('010701', '0107', '客服管理',
                        '${pageContext.request.contextPath}/admin/dialogue/adminReplyDialogue', '', 'mainFrame');
                    d.add('0108', '01', '帮助中心');
                    d.add('010801', '0108', '帮助内容',
                        '${pageContext.request.contextPath}/admin/help/getAllHelpByPage', '', 'mainFrame');
                    d.add('0109', '01', '用户建议');
                    d.add('010901', '0109', '建议内容',
                        '${pageContext.request.contextPath}/admin/advice/findAdviceByPage', '', 'mainFrame');
                    document.write(d);
                </script>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
