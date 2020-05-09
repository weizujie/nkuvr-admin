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
     *
     * @param id
     * @return
     */
    List<Appointment> findAppointmentListByUserId(@Param("id") Long id);

    /**
     * 查询所有预约
     *
     * @return
     */
    List<Appointment> findAll();

    /**
     * 预约增加
     *
     * @param appointment
     */
    void appointmentAdd(Appointment appointment);

    /**
     * 根据 id 查询预约
     *
     * @param id
     * @return
     */
    Appointment findAppointmentByAppointmentId(@Param("id") Long id);

    /**
     * 用户取消预约
     */
    void appointmentCancelById(@Param("id") Long id);

    /**
     * 删除预约
     *
     * @param id
     */
    void appointmentDeleteById(@Param("id") Long id);

    /**
     * 通过预约
     *
     * @param id
     */
    void appointmentPassById(@Param("id") Long id);

    /**
     * 不通过预约
     *
     * @param id
     */
    void appointmentNoPassById(@Param("id") Long id, @Param("reason") String reason);

    /**
     * 预约修改
     */
    void appointmentEdit(Appointment appointment);
}
