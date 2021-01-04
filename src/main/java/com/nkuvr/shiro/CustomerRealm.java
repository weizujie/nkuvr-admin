package kaizen.shiro.shiro;


import kaizen.shiro.pojo.Perms;
import kaizen.shiro.pojo.User;
import kaizen.shiro.service.IUserService;
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
    private IUserService userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取身份信息
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        // 根据主身份信息(primaryPrincipal)获取 角色 和 权限
        User user = userService.findRolesByUsername(primaryPrincipal);
        // 添加角色信息
        if (!CollectionUtils.isEmpty(user.getRoles())) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            user.getRoles().forEach(role -> {
                info.addRole(role.getName());
                // 添加权限信息
                try {
                    // 没有给 student 角色进行授权，会抛出 NullPointerException，但在实际开发中应该不存在无权限的角色，所以可以不用加 try catch
                    List<Perms> perms = userService.findPermsByRoleId(role.getId());
                    log.info(perms.toString());
                    if (!CollectionUtils.isEmpty(perms)) {
                        perms.forEach(perm -> info.addStringPermission(perm.getName()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            return info;
        }
        return null;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User dbUser = userService.findByUsername(token.getUsername());
        if (dbUser == null) {
            throw new UnknownAccountException("该用户名不存在");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(dbUser.getUsername(), dbUser.getPassword(), this.getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(dbUser.getSalt()));
        return info;
    }
}
