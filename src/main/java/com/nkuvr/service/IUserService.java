package com.nkuvr.service;

import com.nkuvr.pojo.User;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */
public interface IUserService {
    List<User> findAll();

    User findUserById(Long id);

    User login(User user);

    int userEdit(User user);
}
