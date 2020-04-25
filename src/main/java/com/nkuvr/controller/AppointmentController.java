package com.nkuvr.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nkuvr.pojo.Appointment;
import com.nkuvr.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/4/25
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    /**
     * 跳转到预约列表
     *
     * @return
     */
    @RequestMapping("/{id}")
    public String toList(@PathVariable("id") Long id,
                         @RequestParam(name = "page", defaultValue = "1") Integer pageNum,
                         Model model) {
        PageHelper.startPage(pageNum, 5);
        List<Appointment> appointmentList = appointmentService.findAppointmentListByUserId(id);
        PageInfo<Appointment> pageInfo = new PageInfo<>(appointmentList, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "appointment/list";
    }

}
