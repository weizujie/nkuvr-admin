package com.nkuvr.controller;

import com.nkuvr.entity.SysUser;
import com.nkuvr.service.SysUserService;
import com.nkuvr.utils.ResultUtil;
import com.nkuvr.utils.SaltUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "登录注册")
@RestController
@CrossOrigin
public class AuthController {

    private final SysUserService sysUserService;

    public AuthController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 处理用户注册（这部分代码应该在业务层实现，懒）
     */
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public ResultUtil register(@RequestBody SysUser sysUser) {
        // 判断注册的用户名是否存在数据库中，不存在则直接注册
        if (sysUserService.getByUsername(sysUser.getUsername()) == null) {
            // 生成随机 salt
            String salt = SaltUtil.getSalt(8);
            // 将随机 salt 保存到数据库
            sysUser.setSalt(salt);
            // 密码加密 (md5 + salt + hash散列)
            Md5Hash md5Hash = new Md5Hash(sysUser.getPassword(), salt, 1024);
            sysUser.setPassword(md5Hash.toHex());
            sysUserService.save(sysUser);
            return ResultUtil.success();
        } else {
            throw new UnknownAccountException("该用户名已存在，请重新输入");
        }
    }

    /**
     * 处理用户登录
     * 使用 json 作为参数传递，则需要将数据转换为 Map，并且加上 @RequestBody 注解
     * RequestBody 主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ResultUtil login(@RequestBody Map<String, String> map) {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(map.get("username"), map.get("password")));
            return ResultUtil.success().data("username", subject.getPrincipal());
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            return ResultUtil.error().message("用户名或密码错误");
        }
    }

    /**
     * 处理用户退出
     */
    @ApiOperation("用户退出")
    @PostMapping("/logout")
    public ResultUtil logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultUtil.success();
    }

    /**
     * 访问未授权页面处理
     */
    @GetMapping("/unauth")
    public ResultUtil unauth() {
        return ResultUtil.error().message("未授权资源禁止访问");
    }
}