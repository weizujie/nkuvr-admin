package com.nkuvr.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;


/**
 * @Author: weizujie
 * @Date: 2020/5/7
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */

@Configuration
public class ShiroConfig {

    /**
     * ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(manager);

        /**
         * 添加 shiro 内置过滤器
         * 常用过滤器：
         *      anon: 无需认证即可访问
         *      authc: 必须认证才可以访问
         *      user: 使用 rememberMe 的功能才能访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      role: 该资源必须得到角色权限才能访问
         */
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        // 不需要授权的网页
        map.put("/css/**", "anon");
        map.put("/js/**", "anon");
        map.put("/images/**", "anon");
        map.put("/fonts/**", "anon");
        map.put("/layer/**", "anon");
        map.put("/", "anon");
        map.put("/doLogin", "anon");
        map.put("/register", "anon");
        map.put("/doRegister", "anon");

        // 需要授权才能访问的网页（按顺序判断）
        // 都能访问的页面
        map.put("/user/profile/", "authc");
        map.put("/user/changePassword/", "authc");
        map.put("/appointment/my/", "authc");
        map.put("/appointment/edit/", "authc");
        map.put("/appointment/add", "authc");

        // 管理员权限能访问的页面
        map.put("/user/list", "perms[0]");
        map.put("/user/add", "perms[0]");
        map.put("/user/edit/", "perms[0]");
        map.put("/user/delete/", "perms[0]");
        map.put("/appointment/list", "perms[0]");
        map.put("/appointment/view/", "perms[0]");
        map.put("/appointment/delete/", "perms[0]");

        // 配置退出过滤器,其中的具体的退出代码 Shiro 已经替我们实现了
        map.put("/logout", "logout");

        //拦截所有请求，一般放最后面
        map.put("/**", "authc");


        // 设置登录要跳转的页面
        bean.setLoginUrl("/");
        // 设置未授权页面
        bean.setUnauthorizedUrl("/error/unauth");
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }


    /**
     * DefaultWebSecurityManager
     */
    @Bean(name = "manager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        // 关联 Realm
        manager.setRealm(userRealm);
        return manager;
    }


    /**
     * Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }


}
