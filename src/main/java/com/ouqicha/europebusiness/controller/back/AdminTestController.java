package com.ouqicha.europebusiness.controller.back;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/13 0013
 * Time:8:37
 */
@Controller
public class AdminTestController {
    /**
     * 只有游客才可以访问
     *
     * @return
     */
    @RequestMapping(value = "/testGuest")
    @ResponseBody
    public String testGuest() {
        System.out.println("只有游客才可以访问此路径");
        return "只有游客才可以访问此路径";
    }


    /**
     * 必须认证登录后才可访问
     *
     * @return
     */
    @RequiresAuthentication//这个路径，身份必须验证后才可以访问这个路径
    @RequestMapping(value = "/testLogin")
    @ResponseBody
    public String test() {
        System.out.println("必须登陆才可以访问");
        return "必须登陆才可访问此路径";
    }

    /**
     * 必须有admin这个角色才可以访问
     *
     * @return
     */
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/testRole1")
    @ResponseBody
    public String testRole1() {
        System.out.println("需要admin角色可访问");
        return "需要有admin这个角色的才可访问";
    }

    /**
     * 必须有下列权限才可以访问
     *
     * @return
     */
    @RequiresPermissions(value = {"/admin/add", "/admin/delete"})
    @RequestMapping(value = "/testPermission")
    @ResponseBody
    public String testPermission() {
        System.out.println("必须含有某个路径的权限才可以访问");
        return "必须含有某个路径的权限才可以访问";
    }
}
