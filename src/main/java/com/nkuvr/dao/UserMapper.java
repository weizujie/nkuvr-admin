package com.nkuvr.dao;

import com.nkuvr.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */
public interface UserMapper {
    List<User> findAll();

    User queryForLogin(User user);

}
