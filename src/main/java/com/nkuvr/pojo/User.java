package com.nkuvr.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.transaction.Transactional;

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
public class UserEntity extends BaseEntity {
    private String username;
    private String password;
    private Integer gender;  // 0:女, 1:男
    private Integer stuNum;
    private String realName;
    private String email;
    private String perms;
}
