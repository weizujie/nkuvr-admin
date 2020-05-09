package com.nkuvr.controller;

import com.nkuvr.utils.ResultUtil;
import com.nkuvr.pojo.User;
import com.nkuvr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * 用户登录页面
     *
     * @return
     */
    @RequestMapping(value = {"/", "/login"})
    public String toLogin() {
        return "login";
    }

    /**
     * 处理用户登录
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public ResultUtil doLogin(User user, HttpSession session) {
        ResultUtil result = new ResultUtil();
        User dbUser = userService.login(user);
        if (dbUser != null) {
            // 登录成功
            session.setAttribute("loginUser", dbUser);
            result.setSuccess(true);
        } else {
            // 登录失败
            result.setSuccess(false);
        }
        return result;
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
