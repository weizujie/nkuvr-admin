package com.nkuvr.config;

import com.nkuvr.pojo.UserEntity;
import com.nkuvr.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        // 用户名，密码，数据库中取
        UserEntity user = userService.findByUsername(userToken.getUsername());
        if (user == null) {
            // UnknownAccountException
            return null;
        }
        // 密码认证，shiro 自己做，密码加密了
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
