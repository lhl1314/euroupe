/**
 * 单个图片上传的点击和清空
 */
/**
 * 触发input中file的点击事件
 */
$("#selectLogo").click(function() {
    $(this).parent().children('.restartSelectOneLogo').remove();
    $(this).parent().append("<a href='javascript:void(0)' class='restartSelectOneLogo'>重选</a>")
    $("#upOneImage").click();
});

/**
 * 清空已经选择的input file
 * 实际上是曲线救国的思想，将原先的删除，重新添加一个一模一样的节点既可
 */
$(document).on('click', '.restartSelectOneLogo', function() {
    $(this).parent().children('input').remove();
    $(this).parent().append("<input type='file' id='upOneImage' name='file' accept='image/*' onchange='upLoad()'/>");
    $("#img").attr("src", "fasdf");
    $(".restartSelectOneLogo").remove();
    $("#upOneImage").css("display","none");
});


/**
 * 企业图片上传的点击以及清空
 */
$("#selectCompanyImage").click(function() {
    $(this).parent().children('.restartSelectCompanyImages').remove();
    $(this).parent().append("<a href='javascript:void(0)' class='restartSelectCompanyImages'>重选</a>")
    $("#companyFileId").click();
});
/**
 * 清空企业选择的图片，进而重新选择
 */
$(document).on('click', '.restartSelectCompanyImages', function() {
    $(this).parent().children('input').remove();
    $(this).parent().append("<input type=\"file\" style='display: none;' id=\"companyFileId\" multiple=\"multiple\" name=\"companyFiles\" onchange=\"javascript:setImagePreviews(this.id);\" accept=\"image/*\" />");
    $("#companyImagesId").find("img").remove();
    $(".restartSelectCompanyImages").remove();
});




/**
 * 企业产品图片上传的点击以及清空
 */
$("#selectProductImage").click(function() {
    $(this).parent().children('.restartSelectProductImages').remove();
    $(this).parent().append("<a href='javascript:void(0)' class='restartSelectProductImages'>重选</a>")
    $("#productFileId").click();
});
/**
 * 清空企业产品选择的图片，进而重新选择
 */
$(document).on('click', '.restartSelectProductImages', function() {
    $(this).parent().children('input').remove();
    $(this).parent().append("<input type=\"file\" style='display: none;' id=\"productFileId\" multiple=\"multiple\" name=\"productFiles\" onchange=\"javascript:setImagePreviews(this.id);\" accept=\"image/*\" />");
    $("#productImagesId").find("img").remove();
    $(".restartSelectProductImages").remove();
});


/**
 * 单图片的预览问题
 */
function upLoad() {
    var fileInput = document.getElementById("upOneImage");
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
 * 下面的函数用于多图片的预览功能
 * @param {Object} avalue
 */
function setImagePreviews(inputId) {
    var imageFatherId=$("#"+inputId).parent().next().attr("id");
    var docObj = document.getElementById(inputId); //表单控件

    var dd = document.getElementById(imageFatherId); //预览图片的父节点

    dd.innerHTML = "";

    var fileList = docObj.files;

    for(var i = 0; i < fileList.length; i++) {
        var imageId=imageFatherId+i;
        dd.innerHTML += "<div style='float:left;margin:12px;' > <img id='"+imageId+"'  /> </div>";
        var imgObjPreview = document.getElementById(imageId);
        if(docObj.files && docObj.files[i]) {
            //火狐下，直接设img属性
            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '100px';
            imgObjPreview.style.height = '100px';
            //imgObjPreview.src = docObj.files[0].getAsDataURL();
            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
            imgObjPreview.src = window.URL.createObjectURL(docObj.files[i]);
        } else {
            //IE下，使用滤镜
            docObj.select();
            var imgSrc = document.selection.createRange().text;
            alert(imgSrc)
            var localImagId = document.getElementById("img" + i);
            //必须设置初始大小
            localImagId.style.width = "100px";
            localImagId.style.height = "100px";
            //图片异常的捕捉，防止用户修改后缀来伪造图片
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            } catch(e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty();
        }
    }
    return true;
}


/**
 * js控制表单的提交
 */

$("#submitButton").click(function () {
    var c=checkForm();
    if (c==false){
        return;
    }
    $("#addCompanyForm").attr('action','/admin/company/addCompanyOneAndMore');
    $("#addCompanyForm").submit();
});

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

/**
 * 模态框的打开和关闭
 */
function toggleWarnModal() {
    $('#myModal').modal('toggle');
}