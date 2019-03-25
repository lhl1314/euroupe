/**
 * 冻结用户的操作
 * */
function freezeNormalUser(id) {
    $.ajax(
        {
            type:"post",
            async:false,
            url:"/admin/user/freezeOrUnfreezeNormalUser",
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
            dataTye:"json"
        }
    );
}

/**
 * 关闭警示模态框
 */
function closeModal(id) {
    $('#myModal'+id).modal('toggle');
}