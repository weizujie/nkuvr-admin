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

    @Override
    public List<Appointment> findAll() {
        return appointmentMapper.findAll();
    }

    @Override
    public void appointmentAdd(Appointment appointment) {
        appointmentMapper.appointmentAdd(appointment);
    }

    @Override
    public Appointment findAppointmentByAppointmentId(Long id) {
        return appointmentMapper.findAppointmentByAppointmentId(id);
    }

    @Override
    public void appointmentCancelById(Long id) {
        appointmentMapper.appointmentCancelById(id);
    }

    @Override
    public void appointmentDeleteById(Long id) {
        appointmentMapper.appointmentDeleteById(id);
    }

    @Override
    public void appointmentPassById(Long id) {
        appointmentMapper.appointmentPassById(id);
    }

    @Override
    public void appointmentNoPassById(Long id, String reason) {
        appointmentMapper.appointmentNoPassById(id, reason);
    }

    @Override
    public void appointmentEdit(Appointment appointment) {
        appointmentMapper.appointmentEdit(appointment);
    }


}
