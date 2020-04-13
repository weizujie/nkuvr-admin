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
    // 3. ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(securityManager);

        // 添加 shiro 的内置过滤器
        // anon: 无需认证就可以访问
        // authc：必须认证才能访问
        // user: 必须 记住我 才能访问
        // role: 拥有某个角色权限才能访问
        // perms: 拥有对某个资源的权限才能访问

        // 拦截
        Map<String, String> setFilterChainDefinitionMap = new LinkedHashMap<>();
        setFilterChainDefinitionMap.put("/user/*", "authc");
        bean.setFilterChainDefinitionMap(setFilterChainDefinitionMap);
        // 设置登录的请求
        bean.setLoginUrl("/login");

        return bean;
    }

    // 2. DefaultWebSecurityManager
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联 Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // 1. 创建 Realm 对象，需要自定义类
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }


    //配置ShiroDialect，用于thymeleaf和shiro标签的配合使用
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
