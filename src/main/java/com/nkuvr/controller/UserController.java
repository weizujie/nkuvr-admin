package com.nkuvr.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nkuvr.dao.UserJpa;
import com.nkuvr.pojo.UserEntity;
import com.nkuvr.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserJpa userJpa;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/profile")
    public String toProfile(Model model) {
        Subject subject = SecurityUtils.getSubject();
        model.addAttribute("users", subject.getPrincipal());
        return "user/profile";
    }

    @GetMapping("/userList")
    public String userList(Model model,
                           @RequestParam(defaultValue = "1") int pageNum,
                           @RequestParam(defaultValue = "5") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> users = userService.selectList();
        PageInfo<UserEntity> pageInfo = new PageInfo<>(users);
        model.addAttribute("users", pageInfo);
        return "user/userList";
    }

    @GetMapping("/form")
    public String toForm() {
        return "user/form";
    }

    @PostMapping("/form")
    public String writeForm() {
        return "redirect:/formList";
    }

}
