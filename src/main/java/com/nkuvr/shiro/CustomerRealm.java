package com.nkuvr.shiro;


import com.nkuvr.entity.SysPerms;
import com.nkuvr.entity.SysUser;
import com.nkuvr.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义 realm
 *
 * @Author: weizujie
 * @Date: 2020/12/5
 * @Github: https://github.com/weizujie
 */
@Slf4j
public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取身份信息
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        // 根据主身份信息(primaryPrincipal)获取 角色 和 权限
        SysUser sysUser = sysUserService.getRolesByUsername(primaryPrincipal);
        // 添加角色信息
        if (!CollectionUtils.isEmpty(sysUser.getRoles())) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            sysUser.getRoles().forEach(role -> {
                info.addRole(role.getName());
                // 添加权限信息
                try {
                    // 没有给 student 角色进行授权，会抛出 NullPointerException，但在实际开发中应该不存在无权限的角色，所以可以不用加 try catch
                    List<SysPerms> perms = sysUserService.getPermsByRoleId(role.getId());
                    if (!CollectionUtils.isEmpty(perms)) {
                        perms.forEach(perm -> info.addStringPermission(perm.getName()));
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            });
            return info;
        }
        return null;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SysUser dbUser = sysUserService.getByUsername(token.getUsername());
        if (dbUser == null) {
            throw new UnknownAccountException("该用户名不存在");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(dbUser.getUsername(), dbUser.getPassword(), this.getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(dbUser.getSalt()));
        return info;
    }
}
