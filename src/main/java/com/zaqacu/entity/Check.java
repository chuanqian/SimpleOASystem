package com.zaqacu.entity;

import com.zaqacu.util.TimeUtls;

import java.util.Date;

public class Check extends MyPage {

    private Integer checkId;

    private String checkBeiStaffUid;

    private Integer checkTypeId;

    private Double checkMoney;

    private Date checkTime;

    private String checkStaffUid;

    private Date startTime;
    private Date endTime;
    private String staffName;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = TimeUtls.getTimeNull(startTime);
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = TimeUtls.getTimeNull(endTime);
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public String getCheckBeiStaffUid() {
        return checkBeiStaffUid;
    }

    public void setCheckBeiStaffUid(String checkBeiStaffUid) {
        this.checkBeiStaffUid = checkBeiStaffUid == null ? null : checkBeiStaffUid.trim();
    }

    public Integer getCheckTypeId() {
        return checkTypeId;
    }

    public void setCheckTypeId(Integer checkTypeId) {
        this.checkTypeId = checkTypeId;
    }

    public Double getCheckMoney() {
        return checkMoney;
    }

    public void setCheckMoney(Double checkMoney) {
        this.checkMoney = checkMoney;
    }

    public String getCheckTime() {
        return TimeUtls.getTimeFommat(checkTime);
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = TimeUtls.getTimeParse(checkTime);
    }

    public String getCheckStaffUid() {
        return checkStaffUid;
    }

    public void setCheckStaffUid(String checkStaffUid) {
        this.checkStaffUid = checkStaffUid == null ? null : checkStaffUid.trim();
    }

}