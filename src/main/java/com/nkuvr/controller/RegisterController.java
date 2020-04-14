package com.nkuvr.controller;

import com.nkuvr.pojo.User;
import com.nkuvr.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

@Controller
public class RegisterController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/register")
    public String toRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(User user, Model model) {
        User findByUsername = userService.findByUsername(user.getUsername());
        if (findByUsername == null) {
            userService.register(user);
            return "redirect:/login";
        } else {
            model.addAttribute("msg", "该用户名已存在");
            return "register";
        }
    }

}
