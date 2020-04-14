package com.nkuvr.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nkuvr.pojo.User;
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
    private UserServiceImpl userService;

    /**
     * GET 个人中心页面
     *
     * @param model
     * @return
     */
    @GetMapping("/userProfile")
    public String toProfile(Model model) {
        Subject subject = SecurityUtils.getSubject();
        model.addAttribute("users", subject.getPrincipal());
        return "user/user_profile";
    }

    /**
     * GET 用户列表页面，展示用户信息，只有 admin 权限才能访问
     *
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/userList")
    public String userList(Model model,
                           @RequestParam(defaultValue = "1") int pageNum,
                           @RequestParam(defaultValue = "5") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.selectList();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        model.addAttribute("users", pageInfo);
        return "user/user_list";
    }

    /**
     * GET 预约申请页面
     *
     * @return
     */
    @GetMapping("/userFormAdd")
    public String toForm() {
        return "user/user_form_add";
    }

    /**
     * GET 预约列表页面，只有 admin 权限才能访问
     *
     * @return
     */
    @GetMapping("/userFormList")
    public String toFormList() {
        return "user/user_form_list";
    }

    /**
     * GET 预约进度页面，用户查看自己的预约进度
     *
     * @return
     */
    @GetMapping("/userFormSchedule")
    public String toFormSchedule() {
        return "user/user_form_schedule";
    }

    /**
     * GET 用户添加页面，只有 admin 权限才能访问
     *
     * @return
     */
    @GetMapping("/userAdd")
    public String toUserAdd() {
        return "user/user_add";
    }

    /**
     * 删除用户，admin 权限才能访问
     *
     * @return
     */
    @GetMapping("/userDelete")
    public String doUserDelete(Long id) {
        userService.deleteById(id);
        return "redirect:/user/userList";
    }

    /**
     * GET 用户更新页面，只有 admin 权限才能访问
     *
     * @return
     */
    @GetMapping("/toUserUpdate")
    public String toUserUpdate(Model model, User user) {
        User userById = userService.findUserById(user.getId());
        model.addAttribute("userInfo", userById);
        return "user/user_update";
    }

    /**
     * 用户更新
     *
     * @param user
     * @return
     */
    @PostMapping("/userUpdate")
    public String doUserUpdate(User user) {
        // 注意：不能修改当前登录用户
        userService.update(user);
        return "redirect:/user/userList";
    }

}
