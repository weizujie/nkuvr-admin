package com.nkuvr.controller;

import com.nkuvr.pojo.Result;
import com.nkuvr.pojo.User;
import com.nkuvr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/", "/login"})
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String toLogout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

    @RequestMapping(value = "/doAjaxLogin")
    @ResponseBody
    public Result doAjaxLogin(User user, HttpSession session) {

        Result result = new Result();
        User dbUser = userService.queryForLogin(user);
        if (dbUser != null) {
            session.setAttribute("loginUser", dbUser);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }
}
