package com.nkuvr.controller;

import com.nkuvr.dao.UserJpa;
import com.nkuvr.pojo.UserEntity;
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
    private UserJpa userJpa;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/register")
    public String toRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(UserEntity user, Model model) {
        UserEntity byUsername = userService.findByUsername(user.getUsername());
        if (byUsername == null) {
            userJpa.save(user);
            return "redirect:/login";
        } else {
            model.addAttribute("msg", "该用户名已存在");
            return "register";
        }
    }

}
