package com.nkuvr.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class LabEntity extends BaseEntity {
    private String title;
    private String realName;
    private Integer phone;
    private Integer numOfPeople;
    private String speaker;
    private String description;
    private String serviceNeeds;
    private String consumerDemand;
    private String otherNeeds;
    private String staff;
    private Integer staffPhone;
    private Date activityTime;


}
