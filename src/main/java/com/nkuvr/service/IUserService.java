package com.nkuvr.service;

import com.nkuvr.pojo.UserEntity;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */
public interface IUserService {
    List<UserEntity> selectList();

    UserEntity findByUsername(String username);

    void save(UserEntity userEntity);

}
