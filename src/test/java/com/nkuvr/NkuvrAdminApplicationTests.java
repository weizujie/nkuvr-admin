package com.nkuvr;

import com.nkuvr.pojo.Appointment;
import com.nkuvr.pojo.User;
import com.nkuvr.service.IAppointmentService;
import com.nkuvr.service.IUserService;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class NkuvrAdminApplicationTests {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAppointmentService appointmentService;

    @Test
    void findAppointmentListByUserIdTest() {
        List<Appointment> list = appointmentService.findAppointmentListByUserId(1L);
        for (Appointment appointment : list) {
            System.out.println(appointment.getUser());
        }
    }

    @Test
    void findUserByStudentNumberTest() {
        User userByStudentNumber = userService.findUserByStudentNumber("17990425");
        if (userByStudentNumber == null) {
            System.out.println("giao!!!!");
        }
    }

    @Test
    void splitTest() {
        String str = "id=2&阿伟大单位";
        String[] reason = str.split("&");
        System.out.println(reason[reason.length-1]);

    }

}
