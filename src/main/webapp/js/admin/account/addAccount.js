/**
 * Js控制form表单的提交
 * */
$("#submitAddAccount").click(function () {
    var mobile=$("#changMobile").val();
    var password=$("#addAccountForm input[type='password']").val();
    var email=$("#addAccountForm input[type='email']").val();
    if (mobile!=""&&password!=""&&email!=""){
        var objs = document.getElementsByName("roles");
        var checkedCount=0;
        for (var i=0;i<objs.length;i++){
            if (objs[i].checked){
                checkedCount++;
            }
        }
        if (checkedCount<=0){
            alert("必须选中一个角色！")
        } else {
            /**
             * 提交前先验证该账户是否存在
             */
            $.ajax(
                {
                    type:"post",
                    async:false,
                    url:"/back/checkAccountIfAlso",
                    data:{
                        mobile:mobile
                    },success:function (msg) {
                        if (msg==1){
                            alert("该账户已经存在");
                        }else {
                            $("#addAccountForm").attr('action','/back/addAccount');
                            $("#addAccountForm").submit();
                        }
                    },
                    dataType:"json"
                }
            );
        }
    }else {
        alert("请将必填字段填写完整！")
    }

});


var s=$(".role").val();
$("#changMobile").change(function () {
    var mobile=$(".addAcount input[name='mobile']").val();
    $(".trMobile").html(mobile);
});
/**
 * 随着角色的转换而转化权限的显示
 */
$(".role").change(function () {
    var roleId=$(".role").val();
    getPermissionByRole(roleId);
});

getPermissionByRole(s);

/**
 * 根据角色的ID获取权限
 * @param roleId
 */
function getPermissionByRole(roleId) {
    $(".roleHead").siblings().remove();
    var mobile=$(".addAcount input[name='mobile']").val();

    if (mobile==""){
        mobile="暂无";
    }
    console.log("手机号"+mobile)
    $.ajax(
        {
            url: "/back/getPermissionByRole",
            type: "post",
            async: false,
            data: {
                roleId: roleId
            },
            success: function (msg) {
                console.log(msg);
                var roleName = msg.roleName;
                var list=msg.rolePermissions;
                for (var i=0;i<list.length;i++){
                    var permissionName=list[i].permission.permissionName;
                    if (i==0){
                        var tr ="<tr>" +
                            "<td class='trMobile' rowspan="+list.length+">"+mobile+"</td>" +
                            "<td rowspan="+list.length+">"+roleName+"</td>" +
                            "<td>"+permissionName+"</td>" +
                            "</tr>";
                        $(".permissionTable").append(tr);
                    }else {
                        var tr ="<tr>" +
                            "<td>"+permissionName+"</td>" +
                            "</tr>";
                        $(".permissionTable").append(tr);
                    }
                }
            }
        }
    );
};