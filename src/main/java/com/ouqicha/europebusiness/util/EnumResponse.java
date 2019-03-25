package com.ouqicha.europebusiness.util;

/**code  1：代表成功
 * msg   2:返回状态的信息说明
 * Created with IDEA
 * author:lhl
 * Date:2019/3/4 0004
 * Time:10:47
 */
public enum EnumResponse {
    /**
     * 账户登录成功
     */
    LOGIN_PASSWORD_SUCCESS(1,"登录成功"),
    /**
     * 发送验证码返回信息
     */
    REGISTER_EMAIL_ALSO(0,"该邮箱已经注册！"),

    REGISTER_MOBILE_ALSO(0,"该手机号已经注册"),

    send_verifyCode_success(1,"验证码发送成功"),

    /**
     * 注册校验
     */
    register_verify_code_success(1,"注册成功！"),

    register_verify_code_failed(0,"验证码错误，注册失败！");



    private final Integer code;
    private final String msg;


    EnumResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }}
