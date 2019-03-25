/**
 * 冻结账户或者解冻账户的操作
 * */
function freezeOrUnFreezeAccount(id) {
    $.ajax(
        {
            type:"post",
            async:false,
            url:"/back/freezeOrUnfreezeAdminUser",
            data:{
                id:id
            },
            success:function (id) {
                setTimeout('closeModal('+id+')',1000);
                /**
                 * 此处应该frame子页面刷新，在此偷个懒
                 * 再次请求该页面
                 * */
                var a=$(".page_h3 .active").children("a");
                location.href=a[0];
            },
            error:function () {
                alert("系统繁忙，请稍后请求......");
            },
            dataType:"json"
        }
    );
}
/**
 * 关闭警示模态框
 */
function closeModal(id) {
    $('#myModalConfirm'+id).modal('toggle');
}
/**
 * 删除角色
 * @param accountRoleId
 */
function deleteRole(accountRoleId) {
    $.ajax(
        {
            type: "post",
            async: false,
            url: "/back/deleteAdminAccount",
            data: {
                accountRoleId: accountRoleId
            },
            success: function (id) {
                $(".accountRole"+id).remove();
            },
            dataType: "json"
        }
    );

};


/**
 * 删除权限
 * @param accountRoleId
 * @param rolePermissionId
 */
function deletePermission(accountRoleId,rolePermissionId){
    $(".rolePermission"+rolePermissionId).remove();
    var tds=$(".accountRoleRows"+accountRoleId).attr("rowspan");
    $(".accountRoleRows"+accountRoleId).attr("rowspan",tds-1);
};