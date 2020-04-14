package com.nkuvr.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */


@Configuration
public class ShiroConfig {
    /**
     * ShiroFilterFactoryBean
     * <p>
     * anon: 无需认证就可以访问
     * authc：必须认证才能访问
     * user: 必须 记住我 才能访问
     * role: 拥有某个角色权限才能访问
     * perms: 拥有对某个资源的权限才能访问
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(securityManager);
        // 添加 shiro 内置过滤器
        Map<String, String> filterMap = new LinkedHashMap<>();
        // 需要认证访问的页面
        filterMap.put("/user/userFormAdd", "authc");
        filterMap.put("/user/userFormSchedule", "authc");
        filterMap.put("/user/userProfile", "authc");
        // 需要权限访问的页面
        filterMap.put("/user/userList", "perms[admin]");
        filterMap.put("/user/userFormList", "perms[admin]");
        filterMap.put("/user/userAdd", "perms[admin]");
        filterMap.put("/user/userUpdate", "perms[admin]");
        filterMap.put("/user/toUserUpdate", "perms[admin]");
        filterMap.put("/user/userDelete", "perms[admin]");


        bean.setFilterChainDefinitionMap(filterMap);
        // 设置登录的请求
        bean.setLoginUrl("/login");
        // 设置未授权提示页面
        bean.setUnauthorizedUrl("/error/unAuth");

        return bean;
    }

    /**
     * DefaultWebSecurityManager
     *
     * @param userRealm
     * @return
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联 Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建 Realm 对象，需要自定义类
     *
     * @return
     */
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }


    /**
     * 配置ShiroDialect，用于thymeleaf和shiro标签的配合使用
     *
     * @return
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
