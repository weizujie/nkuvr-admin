package com.nkuvr.service.impl;

import com.nkuvr.dao.UserMapper;
import com.nkuvr.pojo.UserEntity;
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
    public List<UserEntity> selectList() {
        return userMapper.selectList();
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void save(UserEntity userEntity) {
        userMapper.save(userEntity);
    }
}
