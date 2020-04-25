package com.nkuvr.dao;

import com.nkuvr.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Author: weizujie
 * @Date: 2020/4/25
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public interface UserMapper {
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
    User findUserById(@Param("id") Long id);

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    User login(User user);

}
