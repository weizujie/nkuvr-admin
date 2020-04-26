package com.nkuvr.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: weizujie
 * @Date: 2020/4/25
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */

@Data
public class User {

    private String id;
    private String username;
    private String password;
    private String studentNumber;
    private String realName;
    private Integer gender;
    private Integer state;
    private Integer remark;
    private Date createTime = new Date();
    private Date updateTime = new Date();
}
