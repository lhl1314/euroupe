package com.ouqicha.europebusiness.controller.back;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.bean.vo.RoleVO;
import com.ouqicha.europebusiness.bean.vo.User;
import com.ouqicha.europebusiness.controller.other.BaseController;
import com.ouqicha.europebusiness.service.LoginInfoService;
import com.ouqicha.europebusiness.service.RoleAndPermissionService;
import com.ouqicha.europebusiness.service.UserInfoService;
import com.ouqicha.europebusiness.util.MD5Util;
import com.ouqicha.europebusiness.util.Page;
import com.ouqicha.europebusiness.util.SendPersonPhoneVerifyCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

@RequestMapping("/back")
@Controller
public class AdminAccountController extends BaseController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    LoginInfoService loginInfoService;

    @Autowired
    RoleAndPermissionService roleAndPermissionService;

    /**
     * 后台管理登录
     *
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Integer login(String name, String password, String verifyCode, HttpSession session) {
        String strCode = (String) session.getAttribute("strCode");
        System.out.println("生成的验证码" + strCode);
        if (strCode.equals(verifyCode)) {
            UsernamePasswordToken token = new UsernamePasswordToken(name, password);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);
                Session subjectSession = subject.getSession();
                Serializable id = subjectSession.getId();
                String ida=id.toString();
                AccountVO o = (AccountVO) subject.getPrincipal();
                if (o.getState()==100){
                    session.setAttribute("user", o);
                    loginInfoService.changLoginInfo(o.getId());
                    return 1;
                    //只有管理员才可以登录，其他情况退出
                }else {
                    subject.logout();
                    return 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return -1;
    }

    @RequestMapping(value = "/toHome")
    public String toHome(HttpSession session) {
        AccountVO user = (AccountVO) session.getAttribute("user");
        if (user!=null){
            return "home";
        }else {
            return "login";
        }
    }

    /***
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        // 跳转到/page/login.jsp页面
        return "login";
    }

    /**
     * 管理员注销账户登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpSession session) {
        AccountVO user = (AccountVO) session.getAttribute("user");
        if (user != null) {
            session.removeAttribute("user");
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            System.out.println("账户注销成功------");
        }
        return "redirect:/back/toLogin";
    }

    /**
     * 跳转到添加用户的页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/toAddAccount")
    public String toAddAccount(Model model) {
        List<RoleVO> allRoleAndPermissions = roleAndPermissionService.findAllRoleAndPermissions();
        model.addAttribute("roles", allRoleAndPermissions);
        return "/account/addAccount";
    }

    /**
     * 获取某个角色的所有权限
     *
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/getPermissionByRole")
    @ResponseBody
    public RoleVO getPermissionByRole(int roleId) {
        RoleVO role = roleAndPermissionService.findPermissionsByRole(roleId);
        return role;
    }

    /**
     * 添加账户,之后重定向到添加账户的页面
     */
    @RequestMapping(value = "/addAccount")
    public String addAccount(AccountEntity accountEntity, String roles) {
        userInfoService.addAccountRole(accountEntity, roles);
        return "redirect:/back/toAddAccount";
    }

    /**
     * 获取账户的分页数据
     *
     * @param pageId
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/getAccountByPage")
    public String getAccountByPage(
            @RequestParam(value = "pageId", defaultValue = "1", required = true) int pageId,
            @RequestParam(value = "pageSize", defaultValue = "4", required = false) int pageSize,
            Model model) {
        Page<AccountVO> page = userInfoService.getAccountByPageAndState(pageId, pageSize, 100);
        model.addAttribute("page", page);
        return "/account/pageAccount";
    }

    /**
     * 删除角色，让该用户不具备该角色所拥有的权限
     *
     * @param accountRoleId
     * @return
     */
    @RequestMapping(value = "/deleteAdminAccount")
    @ResponseBody
    public String deleteAdminAccount(int accountRoleId) {
        userInfoService.deleteAccountRole(accountRoleId);
        return Integer.toString(accountRoleId);
    }

    /**
     * 冻结或者解冻管理员
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/freezeOrUnfreezeAdminUser")
    @ResponseBody
    public String freezeOrUnfreezeAdminUser(int id) {
        userInfoService.freezeOrUnfreezeUser(id);
        return Integer.toString(id);
    }

    /**
     * 去修改密码的页面
     * @return
     */
    @RequestMapping(value = "/toUpdatePassword")
    public String toUpdatePassword(){
        return "account/updateAccount";
    }

    /**
     * 验证该账户是否存在
     * @param mobile
     * @return
     */
    @RequestMapping(value = "/checkAccountIfAlso")
    @ResponseBody
    public Integer checkAccountIfAlso(String mobile){
        AccountVO vo = userInfoService.findByMobile(mobile);
        if (vo!=null){
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * 管理员在线修改密码
     * @param session
     * @param mobile
     * @param oldPassword
     * @param newPassword
     * @return
     */

    @RequestMapping(value = "/adminOnlineChangAccount")
    @ResponseBody
    public Integer adminOnlineChangAccount(
            HttpSession session,
            @RequestParam("mobile") String mobile,
            @RequestParam(name = "oldPassword") String oldPassword,
            @RequestParam(name = "newPassword") String newPassword){
        AccountVO  user = (AccountVO) session.getAttribute("user");
        if (user!=null){
            if (!mobile.equals(user.getMobile())){
                AccountVO vo = userInfoService.findByMobile(mobile);
                if (vo!=null){
                    return 0;//该手机号账户已经存在
                }
            }
            if (user.getPassword().equals(MD5Util.getMD5(oldPassword))){
                user.setMobile(mobile);
                user.setPassword(MD5Util.getMD5(newPassword));
                userInfoService.adminUpdateAccount(user);
                return 1;
            }
        }
        return -1;//旧密码错误
    }



    /**
     * admin手机号发送验证码
     * @param phone
     * @param session
     * @return
     */
    @RequestMapping(value = "/adminSendPassword")
    public String adminSendPassword(String phone,HttpSession session){
        String s = SendPersonPhoneVerifyCode.sendCode(phone);
        if (s!=null&&s!=""){
            session.setAttribute("adminSendVerfyCode",s);
        }
        return s;
    }
    /**
     * 忘记密码的修改
     * @return
     */
    @RequestMapping(value = "/forgetPasswordUpdate")
    @ResponseBody
    public Integer forgetPasswordUpdate(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "verifyCode") String verifyCode,
            @RequestParam(name = "password") String password,
            HttpSession session){
        String o = (String) session.getAttribute("adminSendVerfyCode");
        if (o!=null&&o!=""){
            if (o.equals(verifyCode)){
                int i = userInfoService.forgetPasswordUpdate(phone, password);
                return i;
            }
        }
        return -1;
    }
}
