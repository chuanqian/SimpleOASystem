package com.zaqacu.entity;

import com.zaqacu.util.TimeUtls;

import java.util.Date;

public class StaffPact extends MyPage {

    private Integer pactId;

    private String pactStaffUid;

    private Date pactCreateTime;

    private Date pactEndTime;

    private Integer pactStaffPositionId;

    private String pactNote;

    private String pactInfo;

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

    public Integer getPactId() {
        return pactId;
    }

    public void setPactId(Integer pactId) {
        this.pactId = pactId;
    }

    public String getPactStaffUid() {
        return pactStaffUid;
    }

    public void setPactStaffUid(String pactStaffUid) {
        this.pactStaffUid = pactStaffUid == null ? null : pactStaffUid.trim();
    }

    public String getPactCreateTime() {
        return TimeUtls.getTimeFommat(this.pactCreateTime);
    }

    public void setPactCreateTime(String pactCreateTime) {
        this.pactCreateTime = TimeUtls.getTimeParse(pactCreateTime);
    }

    public String getPactEndTime() {
        return TimeUtls.getTimeFommat(this.pactEndTime);
    }

    public void setPactEndTime(String pactEndTime) {
        this.pactEndTime = TimeUtls.getTimeParse(pactEndTime);
    }

    public Integer getPactStaffPositionId() {
        return pactStaffPositionId;
    }

    public void setPactStaffPositionId(Integer pactStaffPositionId) {
        this.pactStaffPositionId = pactStaffPositionId;
    }

    public String getPactNote() {
        return pactNote;
    }

    public void setPactNote(String pactNote) {
        this.pactNote = pactNote == null ? null : pactNote.trim();
    }

    public String getPactInfo() {
        return pactInfo;
    }

    public void setPactInfo(String pactInfo) {
        this.pactInfo = pactInfo == null ? null : pactInfo.trim();
    }
}