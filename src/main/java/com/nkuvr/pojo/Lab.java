package com.nkuvr.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

@Data
@Entity
@Table(name = "t_lab")
public class Lab extends BaseEntity {
    /**
     * 活动名称
     */
    @Column(length = 50)
    private String title;
    /**
     * 负责人姓名
     */
    @Column(length = 10)
    private String realName;
    /**
     * 负责人手机号码
     */
    @Column(length = 11)
    private Integer phone;
    /**
     * 参加活动的人数
     */
    private Integer numOfPeople;
    /**
     * 主讲人姓名
     */
    @Column(length = 10)
    private String speaker;
    /**
     * 活动描述
     */
    private String description;
    /**
     * 服务需求
     */
    private String serviceNeeds;
    /**
     * 消费需求
     */
    private String consumerDemand;
    /**
     * 其他需求
     */
    private String otherNeeds;
    /**
     * 工作人员姓名
     */
    @Column(length = 10)
    private String staff;
    /**
     * 工作人员手机号码
     */
    @Column(length = 11)
    private Integer staffPhone;
    /**
     * 活动时间
     */
    private Date activityTime;


}
