package com.ouqicha.europebusiness.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.ouqicha.europebusiness.bean.other.ResponsePhone;

import javax.servlet.http.HttpSession;
import java.rmi.ServerException;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/7 0007
 * Time:9:28
 */
public class SendPersonPhoneVerifyCode {
    static final String ACCESS_KEY_ID = "LTAIjD2Z2c67s8dX";
    static final String ACCESS_KEY__SECRET = "QsGEHd6pcG0tcwJ8hHRtKYjAKO7Udm";

    public static String sendCode(String telephone){
        DefaultProfile profile = DefaultProfile.getProfile("default", ACCESS_KEY_ID, ACCESS_KEY__SECRET);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", telephone);
        request.putQueryParameter("SignName", "刘洪历");
        request.putQueryParameter("TemplateCode", "SMS_130914117");
        String code=Utils.getRandNumbers();
        request.putQueryParameter("TemplateParam", "{\"code\":" + code + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println("发送的验证码是："+code);
            System.out.println(response.getData());
            return code;
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        SendPersonPhoneVerifyCode.sendCode("15255710559");
    }
}
