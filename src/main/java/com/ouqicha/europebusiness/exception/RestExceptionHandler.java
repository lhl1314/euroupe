package com.ouqicha.europebusiness.exception;

import java.io.IOException;

import com.ouqicha.europebusiness.bean.vo.ResponseData;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.ExpiredSessionException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 异常增强，以JSON的形式返回给客服端
 * 异常增强类型：NullPointerException,RunTimeException,ClassCastException,
 　　　　　　　　 NoSuchMethodException,IOException,IndexOutOfBoundsException
 　　　　　　　　 以及springmvc自定义异常等，如下：
 SpringMVC自定义异常对应的status code
 Exception                       HTTP Status Code
 ConversionNotSupportedException         500 (Internal Server Error)
 HttpMessageNotWritableException         500 (Internal Server Error)
 HttpMediaTypeNotSupportedException      415 (Unsupported Media Type)
 HttpMediaTypeNotAcceptableException     406 (Not Acceptable)
 HttpRequestMethodNotSupportedException  405 (Method Not Allowed)
 NoSuchRequestHandlingMethodException    404 (Not Found)
 TypeMismatchException                   400 (Bad Request)
 HttpMessageNotReadableException         400 (Bad Request)
 MissingServletRequestParameterException 400 (Bad Request)
 *
 */
@ControllerAdvice
public class RestExceptionHandler{
    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseData runtimeExceptionHandler(RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        return ReturnFormat.retParam(1000, runtimeException.getMessage());
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseData nullPointerExceptionHandler(NullPointerException ex) {
        ex.printStackTrace();
        return ReturnFormat.retParam(1001, null);
    }
    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public ResponseData classCastExceptionHandler(ClassCastException ex) {
        ex.printStackTrace();
        return ReturnFormat.retParam(1002, null);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public ResponseData iOExceptionHandler(IOException ex) {
        ex.printStackTrace();
        return ReturnFormat.retParam(1003, null);
    }
    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public ResponseData noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        ex.printStackTrace();
        return ReturnFormat.retParam(1004, null);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public ResponseData indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        ex.printStackTrace();
        return ReturnFormat.retParam(1005, null);
    }
    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public ResponseData requestNotReadable(HttpMessageNotReadableException ex){
        System.out.println("400..requestNotReadable");
        ex.printStackTrace();
        return ReturnFormat.retParam(400, null);
    }
    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public ResponseData requestTypeMismatch(TypeMismatchException ex){
        System.out.println("400..TypeMismatchException");
        ex.printStackTrace();
        return ReturnFormat.retParam(400, null);
    }
    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public ResponseData requestMissingServletRequest(MissingServletRequestParameterException ex){
        System.out.println("400..MissingServletRequest");
        ex.printStackTrace();
        return ReturnFormat.retParam(400, null);
    }
    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public ResponseData request405(){
        System.out.println("405...");
        return ReturnFormat.retParam(405, null);
    }
    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public ResponseData request406(){
        System.out.println("404...");
        return ReturnFormat.retParam(406, null);
    }
    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class,HttpMessageNotWritableException.class,ExpiredSessionException.class})
    @ResponseBody
    public ResponseData server500(RuntimeException runtimeException){
        System.out.println("500...");
        return ReturnFormat.retParam(406, null);
    }

    /**
         * 授权异常
         * <p>
         * org.apache.shiro.authz.UnauthenticatedException  授权异常
         * org.apache.shiro.authz.HostUnauthorizedException 没有访问权限
         * org.apache.shiro.authz.UnauthorizedException     没有访问权限
         * org.apache.shiro.authz.AuthorizationException    上面异常的父类
         *
         * @param ex 没有权限的异常
        * @return ModelAndView
    */
    @ResponseBody
    @ExceptionHandler(value = {AuthorizationException.class})
    public ResponseData authorizationExceptionHandler(AuthorizationException ex, HttpServletRequest request) {
        System.out.println(ex.getMessage());
        return ReturnFormat.retParam(1016, null);
    }

    /**
     * 认证异常
     * <p>
     * org.apache.shiro.authc.pam.UnsupportedTokenException 身份令牌异常，不支持的身份令牌
     * org.apache.shiro.authc.UnknownAccountException       未知账户/没找到帐号,登录失败
     * org.apache.shiro.authc.LockedAccountException        帐号锁定
     * org.apache.shiro.authz.DisabledAccountException      用户禁用
     * org.apache.shiro.authc.ExcessiveAttemptsException    登录重试次数，超限。只允许在一段时间内允许有一定数量的认证尝试
     * org.apache.shiro.authc.ConcurrentAccessException     一个用户多次登录异常：不允许多次登录，只能登录一次 。即不允许多处登录
     * org.apache.shiro.authz.AccountException              账户异常
     * org.apache.shiro.authz.ExpiredCredentialsException   过期的凭据异常
     * org.apache.shiro.authc.IncorrectCredentialsException 错误的凭据异常
     * org.apache.shiro.authc.CredentialsException          凭据异常
     * org.apache.shiro.authc.AuthenticationException       上面异常的父类
     *
     * @param ex 没有权限的异常
     * @return ModelAndView
     */
    @ResponseBody
    @ExceptionHandler(value = {AuthenticationException.class})
    public ResponseData authenticationExceptionHanlder(AuthenticationException ex, HttpServletRequest request) {
        ex.printStackTrace();
        return ReturnFormat.retParam(1012, null);
    }

}
