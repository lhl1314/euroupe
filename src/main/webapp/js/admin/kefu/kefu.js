/**
 * 指定用户的函数
 */
$('.chat_box_left_bottom li').on('click', function () {
    $(".content").empty();

    $(this).addClass('bg').siblings().removeClass('bg');

    var accountName = $(this).children('.li_right').children('.account').text();
    $('.chat_box_right_header').text('正在和' + accountName + '会话');

    $(this).find("i").remove();
    var sendId = $(this).attr("id");//客户Id
    var acceptId = $(".chat_box_left_header").attr("id");//客服Id
    // /**
    //  * 获取和该客户对话的信息
    //  * */
    $.ajax(
        {
            type:"post",
            async:false,
            url:"/admin/dialogue/getDialogues",
            data:{
                sendId:sendId,
                acceptId:acceptId
            },
            success:function (msg) {
                console.log(msg)
                var kefuId=$(".chat_box_left_header").attr("id");//客服Id
                $.each(msg,function(i,item){  //遍历二维数组
                    // var sendId=item.sendId;
                    var aId=item.acceptId;
                    var content=item.content;
                    if (aId==kefuId){
                        //发送的身份接收
                        sendMsg("/img/5.jpg",content);
                    } else {
                        answers("/img/13.jpg",content);
                    }
                });
            },
            dataType:"json"
        }
    );
});
/**
 * 发送消息的函数
 */
$('.sendBtn').on('click', function () {
    var bg = $(".chat_box_left_bottom").children(".bg");
    if (bg.length == 0) {
        alert("请点击选择交流的账户!");
    } else {
        var sendMessage = $('#textarea').val();
        var sendImage = $(".header_left").children("img").attr("src");
        if (sendMessage == '') {
            alert("请输入要发送的信息");
        } else {
            var sendId = $(".chat_box_left_header").attr("id");//客服Id
            var acceptId = $(".bg").attr("id");
            adminAddDialogue(sendId, acceptId, sendImage, sendMessage);
        }

    }

});

/**
 * 添加留言，后台交互
 */
function adminAddDialogue(sendId, acceptId, sendImage, sendMessage) {
    $.ajax(
        {
            type: "post",
            async: false,
            url: "/admin/dialogue/addDialogue",
            data: {
                sendId: sendId,
                acceptId: acceptId,
                content: sendMessage
            },
            success: function () {
                answers(sendImage, sendMessage);
                $(".bg").children(".li_right").children(".account_accept_message").text(sendMessage.substring(0, 8) + '......');
                $('#textarea').val("");
                $('#textarea').focus();
            },
            dataType: "json"
        }
    );
}

/**
 * 下面两个函数只是页面的显示数据，和后台没有交互
 /**
 * 回复消息的函数
 */
function answers(answerImage, str) {
    // var answerImage = $(".bg").children(".li_left").children("img").attr("src");
    // var str = '生活里，有很多转瞬即逝，像在车站的告别，刚刚还相互拥抱，转眼已各自天涯。很多时候，你不懂，我也不懂，就这样，说着说着就变了，听着听着就倦了，看着看着就厌了，跟着跟着就慢了，走着走着就散了，爱着爱着就淡了，想着想着就算了。';
    var answer = '';
    answer += '<div class="answer_image_header"><img src="' + answerImage + '"/></div>' +
        '<div class="answer_content">' + str + '</div>' +
        '<div style="clear:both;">' + '</div>';
    $('.content').append(answer);
    $('.content').scrollTop($('.content')[0].scrollHeight);
}

/**
 * 发送消息
 * @param sendImage
 * @param sendMessage
 */
function sendMsg(sendImage, sendMessage) {
    var str = '';
    str += '<div class="sent_image_header">' +
        '<img src="' + sendImage + '"/>' +
        '</div>' +
        '<div class="send_content">' + sendMessage + '</div>' +
        '<div style="clear:both;">' + '</div>';
    $('.content').append(str);

    $(".bg").children(".li_right").children(".account_accept_message").text(sendMessage.substring(0, 8) + '......');

    $("#textarea").val(''); //清空textarea
    // setTimeout(answers, 1000);
    $('.content').scrollTop($('.content')[0].scrollHeight); //滑动轮直接到底部
}