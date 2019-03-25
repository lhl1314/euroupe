package com.ouqicha.europebusiness.controller.user;

import com.alibaba.fastjson.JSON;
import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.bean.vo.ResponseData;
import com.ouqicha.europebusiness.bean.vo.User;

import com.ouqicha.europebusiness.controller.other.BaseController;
import com.ouqicha.europebusiness.service.SessionService;
import com.ouqicha.europebusiness.service.UserInfoService;
import com.ouqicha.europebusiness.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/api/userinfo")
@Controller
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    ResponseData<AccountVO> login(String name, String password){
        ResponseData<AccountVO> responseData = new ResponseData<AccountVO>();
        String errMessage = "";
        int errCode = 0;
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        Subject subject = SecurityUtils.getSubject();
//        try{
//            subject.isAuthenticated();

            subject.login(token);//shiro进行验证用户登陆合法性, 如果合法，则更新session表userid
            AccountVO accountVO = (AccountVO) subject.getPrincipal();
            Session session = subject.getSession();//
            if(null != session){
                String sessionId = session.getId().toString();
                System.out.println("======="+sessionId);
                accountVO.setToken(sessionId);
                int userId = accountVO.getId();
                sessionService.updateSessionByUserId(userId, sessionId);
            }
//            System.out.println(subject.hasRole("back"));
//            AccountEntity accountEntity = (AccountEntity) subject.getPrincipal();
//            AccountVO accountVO = transforEntity(AccountVO.class, accountEntity);
//            AccountVO accountEntity = userInfoService.findByMobile(name);
            responseData.setData(accountVO);
//        }catch (UnknownAccountException ex) {//用户名没有找到
//            errMessage = ex.getMessage();
//            errCode = 1;
//        } catch (IncorrectCredentialsException ex) {//用户名密码不匹配
//            errMessage = ex.getMessage();
//            errCode = 1;
//        }catch (AuthenticationException ex) {//其他的登录错误
//            errMessage = ex.getMessage();
//            errCode = 1;
//        }catch (ExpiredSessionException ex){
//            errMessage = ex.getMessage();
//            errCode = 1;
//        }
        //验证是否成功登录的方法
//        if (subject.isAuthenticated() && errMessage.equals("")) {
//
//        }else{
//
//        }
        responseData.setErrorCode(errCode);
        responseData.setErrorMessage(errMessage);
        return responseData;
    }

    @RequestMapping("/register")
    public @ResponseBody
    ResponseData<AccountEntity> register(AccountVO accountVO) throws Exception {
        ResponseData<AccountEntity> responseData = new ResponseData<AccountEntity>();
        String errMessage = "";
        int errCode = 0;
        String passMd5 = MD5Util.getMD5(accountVO.getPassword());
        accountVO.setPassword(passMd5);
        AccountEntity accountEntity = transforEntity(AccountEntity.class, accountVO);
        accountEntity.getLoginInfoEntity().setAccountEntity(accountEntity);
        userInfoService.saveAccount(accountEntity);
        responseData.setErrorCode(errCode);
        responseData.setErrorMessage(errMessage);
        return responseData;
    }

    @RequestMapping("/login1")
    public void login(User user, HttpServletResponse response){
        try {
            response.getWriter().write(JSON.toJSONString(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
