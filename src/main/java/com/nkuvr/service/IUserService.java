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
    List<User> selectList();

    User findByUsername(String username);

    void deleteById(Long id);

    User findUserById(Long id);

    int update(User user);


    void register(User user);
}
