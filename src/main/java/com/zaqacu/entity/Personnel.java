package com.zaqacu.entity;

import com.zaqacu.util.TimeUtls;

import java.util.Date;

public class Personnel extends MyPage {

    private Integer personnelId;

    private String personnelStaffUid;

    private Integer personnelOldPositionId;

    private Integer personnelNewPositionId;

    private Date personnelTime;

    private String personnelCause;

    private String staffName;

    private Date startTime;

    private Date endTime;

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

    public Integer getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Integer personnelId) {
        this.personnelId = personnelId;
    }

    public String getPersonnelStaffUid() {
        return personnelStaffUid;
    }

    public void setPersonnelStaffUid(String personnelStaffUid) {
        this.personnelStaffUid = personnelStaffUid == null ? null : personnelStaffUid.trim();
    }

    public Integer getPersonnelOldPositionId() {
        return personnelOldPositionId;
    }

    public void setPersonnelOldPositionId(Integer personnelOldPositionId) {
        this.personnelOldPositionId = personnelOldPositionId;
    }

    public Integer getPersonnelNewPositionId() {
        return personnelNewPositionId;
    }

    public void setPersonnelNewPositionId(Integer personnelNewPositionId) {
        this.personnelNewPositionId = personnelNewPositionId;
    }

    public String getPersonnelTime() {
        return TimeUtls.getTimeFommat(this.personnelTime);
    }

    public void setPersonnelTime(Date personnelTime) {
        this.personnelTime = personnelTime;
    }

    public String getPersonnelCause() {
        return personnelCause;
    }

    public void setPersonnelCause(String personnelCause) {
        this.personnelCause = personnelCause == null ? null : personnelCause.trim();
    }
}