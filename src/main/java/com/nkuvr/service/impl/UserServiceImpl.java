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


    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public void userEdit(User user) {
        userMapper.userEdit(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public void userAdd(User user) {
        userMapper.userAdd(user);
    }
}
