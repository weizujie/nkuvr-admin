package com.nkuvr.pojo;

import lombok.Data;

import java.util.Date;
/**
 * @Author: weizujie
 * @Date: 2020/4/25
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
}
