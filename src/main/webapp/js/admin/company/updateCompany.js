/**
 * 单个图片上传的点击和清空
 */
/**
 * 触发input中file的点击事件
 */
$("#selectLogo").click(function () {
    $(this).parent().children('.restartSelectOneLogo').remove();
    $("#upOneImage").click();
});


/**
 * 企业图片上传的点击以及清空
 */
$("#selectCompanyImage").click(function () {
    $("#companyExplanation").remove();
    $(this).parent().children('.restartSelectCompanyImages').remove();
    $("#companyFileId").click();
});


/**
 * 企业产品图片上传的点击以及清空
 */
$("#selectProductImage").click(function () {
    $("#productExplanation").remove();
    $(this).parent().children('.restartSelectProductImages').remove();
    $("#productFileId").click();
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
    reader.onload = function (e) {
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
    var imageFatherId = $("#" + inputId).parent().next().attr("id");
    var docObj = document.getElementById(inputId); //表单控件

    var dd = document.getElementById(imageFatherId); //预览图片的父节点

    // dd.innerHTML = "";
    $("." + imageFatherId).remove();
    var fileList = docObj.files;

    for (var i = 0; i < fileList.length; i++) {
        var imageId = imageFatherId + i;
        dd.innerHTML += "<div class='" + imageFatherId + "' style='float:left;margin:12px;' > <img id='" + imageId + "'  /> </div>";
        var imgObjPreview = document.getElementById(imageId);
        if (docObj.files && docObj.files[i]) {
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
            } catch (e) {
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
 * js使用ajax提交信息，采用formDate.图片采用遍历节点，获取src既可
 */

$("#submitButton").click(function () {
    var form = new FormData();
    /**
     * 特别注意：fileAndFilesAndObject,file是指form和input中name的值
     * files是指一个数组
     * */
    var file = document.fileAndFilesAndObject.file.files[0];
    form.append("file", file);
    var companyFiles = document.fileAndFilesAndObject.companyFiles.files;
    for (var i = 0; i < companyFiles.length; i++) {
        form.append("companyFiles", companyFiles[i])
    }
    /**
     * productImages
     * */
    var productFiles = document.fileAndFilesAndObject.productFiles.files;
    for (var i = 0; i < productFiles.length; i++) {
        form.append("productFiles", productFiles[i])
    }
    var name = $("#updateCompanyTable input[name='name']").val();
    var id = $("#updateCompanyTable input[name='id']").val();
    var mobile = $("#updateCompanyTable input[name='mobile']").val();
    var website = $("#updateCompanyTable input[name='website']").val();
    var email = $("#updateCompanyTable input[name='email']").val();
    var country = $("#updateCompanyTable input[name='country']").val();
    var address = $("#updateCompanyTable textarea[name='address']").val();
    var description = $("#updateCompanyTable textarea[name='description']").val();
    form.append("name", name);
    form.append("id", id);
    form.append("mobile", mobile);
    form.append("website", website);
    form.append("email", email);
    form.append("country", country);
    form.append("address", address);
    form.append("description", description);
    var s = $(".oldProductImages .oldImage");
    var c=$(".oldCompanyImages .oldImage");
    var oldProductImages="";
    for (var i=0;i<s.length;i++){
        oldProductImages+=s[i].src+"-";
    }
    var oldCompanyImages="";
    for (var i=0;i<c.length;i++){
        oldCompanyImages+=c[i].src+"-";
    }
    form.append("oldCompanyImages",oldCompanyImages);
    form.append("oldProductImages",oldProductImages);

    var companyLogo=$("#img").attr('src');
    form.append("companyLogo",companyLogo);
   var a=$(this).prev().attr("href");
   var pageId=a.split("=");//获取之前的页码
    //进行Ajax请求
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型,可以不设置
        url: "/admin/company/updateCompanyDetail",//url
        data: form,
        async: false,
        cache: false,
        contentType: false, //禁止设置请求类型
        processData: false, //禁止jquery对DAta数据的处理,默认会处理
        success: function (id) {
            location.href="/admin/company/toUpdateCompanyDetail?id="+id+"&&pageId="+pageId[1];
        },
        // error: function () {
        //     alert("异常！");
        // }
    });
});
/**
 * 删除自身节点
 * */
// $(".deleteOldImage span").click(function () {
// $(this).parent().remove();
// });
$(document).on('click', '.deleteOldImage span', function() {
    $(this).parent().remove();
});

/**
 * 表单校验
 * @returns {boolean}
 */
function checkForm() {
    var input_cart = document.getElementsByTagName("input");
    for (var i = 0; i < input_cart.length; i++) {
        if (input_cart[i].value == "" || input_cart[i].value == null) {
            input_cart[i].focus();
            toggleWarnModal();
            setTimeout(toggleWarnModal, 3000);
            return (false);
        }
    }
}

function toggleWarnModal() {
    $('#myModal').modal('toggle');
}