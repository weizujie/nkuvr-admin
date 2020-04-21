package com.nkuvr.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 用户类 User
 *
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String realName;
    private String studentNumber;
    private String remark;
    private Integer state;
    private Date createTime;
    private Date updateTime;

}
