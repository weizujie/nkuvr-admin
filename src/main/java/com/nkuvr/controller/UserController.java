package com.nkuvr.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nkuvr.pojo.Result;
import com.nkuvr.pojo.User;
import com.nkuvr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/4/17
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    public String toUserList(@RequestParam(name = "page", defaultValue = "1") Integer pageNum, Model model) {
        PageHelper.startPage(pageNum, 5);
        List<User> userList = userService.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "user/user_list";
    }

    @RequestMapping("/toEdit/{id}")
    public String toUserEdit(@PathVariable Long id, Model model) {
        User dbUser = userService.findUserById(id);
        model.addAttribute("userInfo", dbUser);
        return "user/user_edit";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Result doUserEdit(User user) {
        Result result = new Result();
        try {
            userService.userEdit(user);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Result doUserDelete(@PathVariable Long id) {
        Result result = new Result();
        try {
            userService.deleteUserById(id);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

}
