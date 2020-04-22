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

    /**
     * 跳转到用户列表页面并展用户数据
     *
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String toUserList(@RequestParam(name = "page", defaultValue = "1") Integer pageNum, Model model) {
        PageHelper.startPage(pageNum, 5);
        List<User> userList = userService.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "user/user_list";
    }

    /**
     * 跳转用户编辑界面并展示用户数据
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/edit/{id}")
    public String toUserEdit(@PathVariable Long id, Model model) {
        User dbUser = userService.findUserById(id);
        model.addAttribute("userInfo", dbUser);
        return "user/user_edit";
    }

    /**
     * 处理用户编辑
     *
     * @param user
     * @return
     */
    @RequestMapping("/doEdit")
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

    /**
     * 处理用户删除
     *
     * @param id
     * @return
     */
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


    /**
     * 跳转到用户新增页面
     *
     * @return
     */
    @RequestMapping("/add")
    public String toUserAdd() {
        return "user/user_add";
    }

    /**
     * 处理用户新增
     * @param user
     * @return
     */
    @RequestMapping("/doAdd")
    @ResponseBody
    public Result doUserAdd(User user) {
        Result result = new Result();
        try {
            userService.userAdd(user);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }


}
