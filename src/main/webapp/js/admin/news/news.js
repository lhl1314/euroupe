/**
 * 关闭警示模态框
 */
function closeModal(id) {
    $('#myModal'+id).modal('toggle');
    $("#"+id).remove();
}
/**
 * 删除新闻
 * @param id
 */
function deleteNews(id) {
    $.ajax(
        {
            type:"post",
            async:false,
            url:"/admin/news/deleteNews",
            data:{
                id:id
            },
            success:function (id) {
                setTimeout('closeModal('+id+')',1000);
                var a=$(".page_h3 .active").children("a");
                location.href=a[0];
            },
            dataType:"json"
        }
    )
}