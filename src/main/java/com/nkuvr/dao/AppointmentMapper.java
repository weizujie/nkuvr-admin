package com.nkuvr.dao;

import com.nkuvr.pojo.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/4/25
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public interface AppointmentMapper {
    /**
     * 根据用户 id 查询用户预约情况
     * @param id
     * @return
     */
    List<Appointment> findAppointmentListByUserId(@Param("id") Long id);
}
