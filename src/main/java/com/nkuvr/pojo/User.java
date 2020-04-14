package com.nkuvr.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */


@Data
@Entity
@Table(name = "t_user")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"}, ignoreUnknown = true)
public class User extends BaseEntity {
    /**
     * 用户名，用于登录
     */
    @Column(length = 20)
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 0: 女
     * 1: 男
     */
    @Column(length = 10)
    private Integer gender;
    /**
     * 学号
     */
    @Column(length = 10)
    private Integer stuNum;
    /**
     * 真实姓名
     */
    @Column(length = 20)
    private String realName;
    /**
     * 邮箱
     */
    @Column(length = 32)
    private String email;
    /**
     * 权限字符
     */
    @Column(length = 10)
    private String perms;
}
