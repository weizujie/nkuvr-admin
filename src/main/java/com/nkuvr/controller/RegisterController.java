package com.nkuvr.controller;

import com.nkuvr.utils.ResultUtil;
import com.nkuvr.pojo.User;
import com.nkuvr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    /**
     * 处理用户注册
     *
     * @param user
     * @return
     */
    @RequestMapping("/doRegister")
    @ResponseBody
    public ResultUtil doRegister(User user, @RequestParam("studentNumber") String studentNumber) {
        ResultUtil result = new ResultUtil();
        try {
            // 判断用户是否存在
            User userByStudentNumber = userService.findUserByStudentNumber(studentNumber);
            if (userByStudentNumber == null) {
                // 不存在，注册
                userService.register(user);
                result.setSuccess(true);
            } else {
                // 存在，返回 false
                result.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }


}
