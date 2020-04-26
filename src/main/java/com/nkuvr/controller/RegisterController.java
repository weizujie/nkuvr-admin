package com.nkuvr.controller;

import com.nkuvr.pojo.Result;
import com.nkuvr.pojo.User;
import com.nkuvr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: weizujie
 * @Date: 2020/4/25
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
@Controller
public class RegisterController {

    @Autowired
    private IUserService userService;

    /**
     * 跳转用户注册界面
     *
     * @return
     */
    @RequestMapping("/register")
    public String toRegister() {
        return "/register";
    }


    @RequestMapping("/doRegister")
    @ResponseBody
    public Result doRegister(User user) {
        Result result = new Result();
        try {
            userService.register(user);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }


}
