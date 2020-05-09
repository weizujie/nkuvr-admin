package com.nkuvr.service;

import com.nkuvr.pojo.Appointment;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/4/25
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public interface IAppointmentService {
    /**
     * 根据 id 查询预约列表
     *
     * @param id
     * @return
     */
    List<Appointment> findAppointmentListByUserId(Long id);

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
    Appointment findAppointmentByAppointmentId(Long id);

    /**
     * 用户取消预约
     */
    void appointmentCancelById(Long id);

    /**
     * 删除预约
     *
     * @param id
     */
    void appointmentDeleteById(Long id);

    /**
     * 通过预约
     *
     * @param id
     */
    void appointmentPassById(Long id);

    /**
     * 不通过预约
     *
     * @param id
     */
    void appointmentNoPassById(Long id, String reason);


    /**
     * 预约修改
     */
    void appointmentEdit(Appointment appointment);
}
