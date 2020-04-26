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
    List<Appointment> findAppointmentListByUserId(Long id);

    List<Appointment> findAll();
}
