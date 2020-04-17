package com.nkuvr.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nkuvr.pojo.User;
import com.nkuvr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/4/17
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toUserList(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                             Model model) {
        try {
            // 分页查询， 使用 pagehelper 插件
            PageHelper.startPage(pageNum, pageSize);
            List<User> userList = userService.findAll();
            PageInfo<User> pageInfo = new PageInfo<>(userList);
            model.addAttribute("pageInfo", pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/user_list";
    }


}
