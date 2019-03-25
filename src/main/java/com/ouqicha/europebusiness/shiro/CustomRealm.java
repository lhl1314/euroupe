package com.ouqicha.europebusiness.shiro;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.service.UserInfoService;
import com.ouqicha.europebusiness.util.Utils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("----------这里是权限验证");
        AccountVO vo = (AccountVO) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        /**
         * 获取用户的角色进行授权
         */
        Set<String> rolesSet = userInfoService.queryUserRole(vo.getMobile());
        System.out.println("该用户具有的角色*****"+rolesSet);
        authorizationInfo.setRoles(rolesSet);

        /**
         * 获取该用户所有角色的权限
         */
        Set<String> permissionsSet = userInfoService.findPermissions(vo.getMobile());
        System.out.println("该用户所具有的权限有"+permissionsSet);
        authorizationInfo.setStringPermissions(permissionsSet);
        return authorizationInfo;
    }

    /**
     * 认证登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken == null||StringUtils.isBlank((String) authenticationToken.getPrincipal())) {
            return null;
        }
        //根据token中的用户名查库，获得user对象
        AccountVO user=null;
        String o = (String) authenticationToken.getPrincipal();
        if (Utils.checkEmail(o)){
            AccountVO vo = userInfoService.findByMailBox(o);
            user=vo;
        }else {
            user = userInfoService.findByMobile(o);
        }
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
