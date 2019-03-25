/**
 * 关闭警示模态框
 */
function closeModal(id,pageId) {
    $('#myModal'+id).modal('toggle');
    location.href="/admin/news/getNewsDetail?id="+id+"&&pageId="+pageId;//重新请求该页面信息，使得该页面信息得到改变
}
/**
 * 冻结或者解冻该新闻
 */
function freezeOrUnfreezeNews(id,pageId) {
    $.ajax(
        {
            type:"post",
            async:false,
            url:"/admin/news/freezeOrUnfreezeNews",
            data:{
                id:id
            },
            success:function (id) {
                setTimeout('closeModal('+id+','+pageId+')',1000);
            },
            datatype:"json"
        }
    )
}
