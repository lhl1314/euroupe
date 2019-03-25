/**
 * 关闭警示模态框
 */
function closeModal(id,pageId) {
    $('#myModal'+id).modal('toggle');
    location.href="/admin/company/getCompanyDetail?id="+id+"&&pageId="+pageId;//重新请求该页面信息，使得该页面信息得到改变
}
/**
 * 冻结或者解冻该企业
 */
function freezeOrUnfreezeCompany(id,pageId){
    $.ajax(
        {
            type:"post",
            async:false,
            url:"/admin/company/freezeOrUnfreezeCompany",
            data:{
                id:id
            },
            success:function (msg) {
                setTimeout('closeModal('+id+','+pageId+')',1000);
                /**
                 * 此处应该frame子页面刷新，在此偷个懒
                 * 再次请求该页面
                 * */
            },
            dataType: "json"
        }
    )
};