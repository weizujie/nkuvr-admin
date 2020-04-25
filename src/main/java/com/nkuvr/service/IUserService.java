package com.nkuvr.service;

import com.nkuvr.pojo.User;

import java.util.List;
/**
 * @Author: weizujie
 * @Date: 2020/4/25
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public interface IUserService {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据 id 查询用户
     *
     * @param id
     * @return
     */
    User findUserById(Long id);

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    User login(User user);

}
