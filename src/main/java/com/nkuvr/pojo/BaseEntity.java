package com.nkuvr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: weizujie
 * @Date: 2020/4/13
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -7674269980281525370L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime = new Date();
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime = new Date();
}
