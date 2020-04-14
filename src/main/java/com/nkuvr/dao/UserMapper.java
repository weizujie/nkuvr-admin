package com.nkuvr.dao;

import com.nkuvr.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */
public interface UserMapper {
    void deleteById(@Param("id") Long id);

    User findUserById(Long id);

    List<User> selectList();

    User findByUsername(String username);

    int update(User user);

    void register(User user);
}
