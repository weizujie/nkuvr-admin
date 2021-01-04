package kaizen.shiro.config;

import kaizen.shiro.shiro.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * shiro 配置
 *
 * @Author: weizujie
 * @Date: 2020/12/5
 * @Github: https://github.com/weizujie
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建 shiroFilter，负责拦截所有请求
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 给 filter 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> map = new HashMap<>();


        // 配置系统公共资源(匿名访问)
        map.put("/api/v1/login", "anon");
        map.put("/api/v1/register", "anon");

        // 配置系统受限资源(需要认证才能访问的资源)
        map.put("/**", "authc");

        // 配置 shiro 默认登录界面地址。前后端分离项目中，登录界面跳转应该由前端控制，后端仅返回 json 数据
        shiroFilterFactoryBean.setLoginUrl("/api/v1/unauth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * 安全管理器
     */
    @Bean
    public DefaultWebSecurityManager securityManager(Realm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 给安全管理器设置自定义 realm
        securityManager.setRealm(realm);
        return securityManager;
    }

    /**
     * 自定义 realm
     */
    @Bean
    public Realm realm() {
        CustomerRealm realm = new CustomerRealm();
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        // 使用加密算法
        credentialsMatcher.setHashAlgorithmName("md5");
        // 设置散列次数，与 IUserServiceImpl 类中设置的一致
        credentialsMatcher.setHashIterations(1024);
        // 设置 realm 使用 hash 凭证匹配器
        realm.setCredentialsMatcher(credentialsMatcher);

        // 开启缓存管理
        EhCacheManager cacheManager = new EhCacheManager();
        realm.setCacheManager(cacheManager);
        // 开启全局缓存
        realm.setCachingEnabled(true);
        // 开启认证缓存
        realm.setAuthenticationCachingEnabled(true);
        realm.setAuthenticationCacheName("authenticationCache");
        // 开启授权缓存
        realm.setAuthorizationCachingEnabled(true);
        realm.setAuthorizationCacheName("authorizationCache");
        
        return realm;
    }

    /**
     * Session 管理器
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        // 设置 session 过期时间为 1 小时
        sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        // 删除过期的 session
        sessionManager.setDeleteInvalidSessions(true);
        // 是否定时检查 session
        sessionManager.setSessionValidationSchedulerEnabled(true);
        // 取消登录跳转 URL 后面的 jsessionid 参数
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }


    /**
     * 开启 Shiro 注解，如@RequiresRoles,@RequiresPermissions
     *
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    /**
     * 开启 Shiro 注解，如@RequiresRoles,@RequiresPermissions
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}
