package com.ouqicha.europebusiness.bean.other;

/**发送验证码的返回信息
 * Created with IDEA
 * author:lhl
 * Date:2019/3/7 0007
 * Time:13:47
 */
public class ResponsePhone {
    private String Message;
    private String RequestId;
    private String BizId;
    private String Code;

    public ResponsePhone() {
    }

    public ResponsePhone(String message, String requestId, String bizId, String code) {
        Message = message;
        RequestId = requestId;
        BizId = bizId;
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    public String getBizId() {
        return BizId;
    }

    public void setBizId(String bizId) {
        BizId = bizId;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    @Override
    public String toString() {
        return "ResponsePhone{" +
                "Message='" + Message + '\'' +
                ", RequestId='" + RequestId + '\'' +
                ", BizId='" + BizId + '\'' +
                ", Code='" + Code + '\'' +
                '}';
    }
}
