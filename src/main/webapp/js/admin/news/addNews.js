$("#selectNewsLogo").click(function () {
    $("#upimg").click();
});
var E = window.wangEditor;
var editor = new E('#editor')
// 自定义菜单配置
/***
 * 不需要的可以删除
 */
editor.customConfig.menus = [
    'head', // 标题
    'bold', // 粗体
    'fontSize', // 字号
    'fontName', // 字体
    'italic', // 斜体
    'underline', // 下划线
    'strikeThrough', // 删除线
    'foreColor', // 文字颜色
    'backColor', // 背景颜色
    'link', // 插入链接
    'list', // 列表
    'justify', // 对齐方式
    'quote', // 引用
    'emoticon', // 表情
    'image', // 插入图片
    'table', // 表格
    'video', // 插入视频
    'code', // 插入代码
    'undo', // 撤销
    'redo' // 重复
]
editor.customConfig.onchange = function(html) {
    // html 即变化之后的内容
    $("#getEditorContent").html("");
    $("#getEditorContent").html(html);
}
//			editor.customConfig.showLinkImg = false // 隐藏“网络图片”tab
editor.customConfig.uploadImgShowBase64 = true; //开启本地图片上传
editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024
editor.customConfig.uploadImgMaxLength = 5
editor.create();

$("#submitNew").click(function () {
    var c=checkForm();
    if (c==false){
        return;
    }
    $("#formNews").attr('action',"/admin/news/addNews");
    $("#formNews").submit();
});
//单图片的预览问题
function upLoad() {
    var fileInput = document.getElementById("upimg");
    var file = fileInput.files[0];
    //创建读取文件的对象
    var reader = new FileReader();
    //创建文件读取相关的变量
    var imgFile;
    //为文件读取成功设置事件
    reader.onload = function(e) {
        // alert('文件读取完成');
        imgFile = e.target.result;
        console.log(imgFile);
        $("#img").attr('src', imgFile);
    };
    //正式读取文件
    reader.readAsDataURL(file);
}



/**
 * 表单校验
 * @returns {boolean}
 */
function checkForm() {
    var input_cart = document.getElementsByTagName("input");
    for(var i = 0; i < input_cart.length; i++) {
        if(input_cart[i].value == "" || input_cart[i].value == null) {
            input_cart[i].focus();
            toggleWarnModal();
            setTimeout(toggleWarnModal,3000);
            return(false);
        }
    }
}

function toggleWarnModal() {
    $('#myModal').modal('toggle');
}