package com.nkuvr.controller;

import com.nkuvr.pojo.User;
import com.nkuvr.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: weizujie
 * @Date: 2020/4/25
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @GetMapping(value = "/")
    public String toLogin() {
        return "login";
    }

    /**
     * 处理用户登录
     */
    @PostMapping(value = "/doLogin")
    public String doLogin(User user, Model model) {
        String studentNumber = user.getStudentNumber();
        String password = user.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(studentNumber, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            //login认证通过后，便可拿到shiro保存的用户对象
            User user1 = (User) subject.getPrincipal();
            subject.getSession().setAttribute("loginUser", user1);
            return "redirect:/user/index";
            // 密码输入错误的时候捕获 IncorrectCredentialsException 异常，不然会报 500 错误
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            model.addAttribute("msg", "学号或密码错误，请重新输入");
            return "/";
        } catch (LockedAccountException e) {
            model.addAttribute("msg", "帐号已被禁用");
            return "/";
        }
    }


    /**
     * 处理用户退出
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String doLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }


}
