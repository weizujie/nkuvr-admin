package com.nkuvr.service.impl;

import com.nkuvr.dao.UserMapper;
import com.nkuvr.pojo.User;
import com.nkuvr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 根据 id 查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    /**
     * 用户修改
     *
     * @param user
     */
    @Override
    public void userEdit(User user) {
        userMapper.userEdit(user);
    }

    /**
     * 用户删除
     *
     * @param id
     */
    @Override
    public void deleteUserById(Long id) {
        userMapper.deleteUserById(id);
    }

    /**
     * 用户新增
     *
     * @param user
     */
    @Override
    public void userAdd(User user) {
        userMapper.userAdd(user);
    }
}
