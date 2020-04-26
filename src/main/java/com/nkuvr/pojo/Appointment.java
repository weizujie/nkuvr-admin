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
public class Appointment {
    private Long id;
    private Integer uid;
    private Integer lid;
    private Integer state;
    private Integer cancel;
    private Integer appointmentNumber;
    private Date date;

    private Lab lab;
    private User user;
}
