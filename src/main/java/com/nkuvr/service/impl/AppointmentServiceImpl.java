package com.nkuvr.service.impl;

import com.nkuvr.dao.AppointmentMapper;
import com.nkuvr.pojo.Appointment;
import com.nkuvr.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/4/25
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */

@Service
public class AppointmentServiceImpl implements IAppointmentService {


    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public List<Appointment> findAppointmentListByUserId(Long id) {
        return appointmentMapper.findAppointmentListByUserId(id);
    }
}
