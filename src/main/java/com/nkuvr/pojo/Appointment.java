package com.nkuvr.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: weizujie
 * @Date: 2020/4/25
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */

public class Appointment {

    private Long id;

    private Integer uid;

    private Integer lid;

    private Integer state;

    private Integer appointmentNumber;

    private String activityName;

    private String principal;

    private String contact;

    private String speaker;

    private String description;

    private String deviceDemand;

    private String consumerDemand;

    private String otherDemand;

    private String staff;

    private String staffContact;

    private String teacher;

    private String reason;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date activityTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date setTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;


    private Lab lab;

    private User user;

    public Appointment() {
    }

    public Appointment(Long id, Integer uid, Integer lid, Integer state, Integer appointmentNumber, String activityName, String principal, String contact, String speaker, String description, String deviceDemand, String consumerDemand, String otherDemand, String staff, String staffContact, String teacher, String reason, Date activityTime, Date setTime, Date date, Lab lab, User user) {
        this.id = id;
        this.uid = uid;
        this.lid = lid;
        this.state = state;
        this.appointmentNumber = appointmentNumber;
        this.activityName = activityName;
        this.principal = principal;
        this.contact = contact;
        this.speaker = speaker;
        this.description = description;
        this.deviceDemand = deviceDemand;
        this.consumerDemand = consumerDemand;
        this.otherDemand = otherDemand;
        this.staff = staff;
        this.staffContact = staffContact;
        this.teacher = teacher;
        this.reason = reason;
        this.activityTime = activityTime;
        this.setTime = setTime;
        this.date = date;
        this.lab = lab;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAppointmentNumber() {
        return appointmentNumber;
    }

    public void setAppointmentNumber(Integer appointmentNumber) {
        this.appointmentNumber = appointmentNumber;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeviceDemand() {
        return deviceDemand;
    }

    public void setDeviceDemand(String deviceDemand) {
        this.deviceDemand = deviceDemand;
    }

    public String getConsumerDemand() {
        return consumerDemand;
    }

    public void setConsumerDemand(String consumerDemand) {
        this.consumerDemand = consumerDemand;
    }

    public String getOtherDemand() {
        return otherDemand;
    }

    public void setOtherDemand(String otherDemand) {
        this.otherDemand = otherDemand;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getStaffContact() {
        return staffContact;
    }

    public void setStaffContact(String staffContact) {
        this.staffContact = staffContact;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public Date getSetTime() {
        return setTime;
    }

    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
