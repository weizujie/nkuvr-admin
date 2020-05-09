package com.nkuvr.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nkuvr.pojo.Appointment;
import com.nkuvr.utils.ResultUtil;
import com.nkuvr.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
     * 跳转到 我的预约
     *
     * @return
     */
    @RequestMapping("/my/{id}")
    public String toMyAppointmentList(@PathVariable("id") Long id,
                                      @RequestParam(name = "page", defaultValue = "1") Integer pageNum,
                                      Model model) {
        PageHelper.startPage(pageNum, 5);
        List<Appointment> appointmentList = appointmentService.findAppointmentListByUserId(id);
        PageInfo<Appointment> pageInfo = new PageInfo<>(appointmentList, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "appointment/myAppointment";
    }

    /**
     * 跳转到 预约列表
     *
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String toAppointmentList(@RequestParam(name = "page", defaultValue = "1") Integer pageNum, Model model) {
        PageHelper.startPage(pageNum, 5);
        List<Appointment> appointmentList = appointmentService.findAll();
        PageInfo<Appointment> pageInfo = new PageInfo<>(appointmentList, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "appointment/appointmentList";
    }

    /**
     * 跳转到 新增预约
     *
     * @return
     */
    @RequestMapping("/add")
    public String toAppointmentAdd() {
        return "appointment/addAppointment";
    }

    /**
     * 处理 新增预约
     *
     * @param appointment
     * @return
     */
    @RequestMapping("/doAppointmentAdd")
    @ResponseBody
    public ResultUtil doAppointmentAdd(Appointment appointment) {
        ResultUtil result = new ResultUtil();
        try {
            appointmentService.appointmentAdd(appointment);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 跳转到 查看预约细节页面
     *
     * @return
     */
    @RequestMapping("/view/{id}")
    public String toAppointmentDetail(@PathVariable("id") Long id, Model model) {
        Appointment appointment = appointmentService.findAppointmentByAppointmentId(id);
        model.addAttribute("appointment", appointment);
        return "appointment/viewAppointment";
    }

    /**
     * 处理取消预约
     *
     * @param id
     * @return
     */
    @RequestMapping("/cancel/{id}")
    @ResponseBody
    public ResultUtil doCancel(@PathVariable("id") Long id) {
        ResultUtil result = new ResultUtil();
        try {
            appointmentService.appointmentCancelById(id);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 处理删除预约
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public ResultUtil doDelete(@PathVariable("id") Long id) {
        ResultUtil result = new ResultUtil();
        try {
            appointmentService.appointmentDeleteById(id);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 处理 通过预约
     *
     * @param id
     * @return
     */
    @RequestMapping("/pass/{id}")
    @ResponseBody
    public ResultUtil doAppointmentPass(@PathVariable("id") Long id) {
        ResultUtil result = new ResultUtil();
        try {
            appointmentService.appointmentPassById(id);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 处理 不通过预约
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/nopass/{id}", consumes = "application/json")
    @ResponseBody
    public ResultUtil doAppointmentNoPass(@PathVariable("id") Long id, @RequestBody String reason) throws UnsupportedEncodingException {
        ResultUtil result = new ResultUtil();
        String[] str = reason.split("&");
        String str1 = URLDecoder.decode(str[str.length - 1], "UTF-8");
        String[] str2 = str1.split("=");
        try {
            appointmentService.appointmentNoPassById(id, str2[str2.length - 1]);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }


    /**
     * 跳转到预约修改页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/edit/{id}")
    public String toAppointmentEdit(@PathVariable("id") Long id, Model model) {
        Appointment appointmentByAppointmentId = appointmentService.findAppointmentByAppointmentId(id);
        model.addAttribute("appointment", appointmentByAppointmentId);
        return "appointment/editAppointment";
    }

    /**
     * 处理 预约修改
     *
     * @return
     */
    @RequestMapping("/doAppointmentEdit")
    @ResponseBody
    public ResultUtil doAppointmentEdit(Appointment appointment) {
        ResultUtil result = new ResultUtil();
        try {
            appointmentService.appointmentEdit(appointment);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }


}
