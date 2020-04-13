package com.nkuvr.dao;

import com.nkuvr.pojo.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */
public interface UserJpa extends JpaRepository<UserEntity, Long> {
}
