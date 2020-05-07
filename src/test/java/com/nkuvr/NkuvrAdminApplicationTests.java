package com.nkuvr;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nkuvr.pojo.Appointment;
import com.nkuvr.pojo.User;
import com.nkuvr.service.IAppointmentService;
import com.nkuvr.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        User userByStudentNumber = userService.findUserByStudentNumber("17990421");
        if (userByStudentNumber == null) {
            System.out.println("giao!!!!");
        }
    }
}
