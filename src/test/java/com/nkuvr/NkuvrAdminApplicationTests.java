package com.nkuvr;

import com.nkuvr.pojo.Appointment;
import com.nkuvr.service.IAppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NkuvrAdminApplicationTests {

    @Autowired
    private IAppointmentService appointmentService;

    @Test
    void findAppointmentListByUserIdTest() {
        List<Appointment> list = appointmentService.findAppointmentListByUserId(1L);
        for (Appointment appointment : list) {
            System.out.println(appointment);
        }
    }

}
