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

    /**
     * 用户修改
     *
     * @param user
     */
    void userEdit(User user);

    /**
     * 用户删除
     *
     * @param id
     */
    void deleteUserById(@Param("id") Long id);

    /**
     * 用户新增
     *
     * @param user
     */
    void userAdd(User user);
}
