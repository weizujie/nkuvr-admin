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
public class Appointment {
    private Long id;
    private Integer uid;
    private Integer lid;
    private Integer state;
    private Integer appointmentNumber;
    private String activityName;
    private String principal;
    private String contact;
    private String speaker;
    private String description;
    private String deviceDemand;
    private String consumerDemand;
    private String otherDemand;
    private String staff;
    private String staffContact;
    private String teacher;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date activityTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date setTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date();

    private Lab lab;
    private User user;
}
