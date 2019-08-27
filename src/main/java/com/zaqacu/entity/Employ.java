package com.zaqacu.entity;

import java.util.Date;

public class Employ {

    private Integer employId;

    private Integer applyEmployId;

    private Integer employStatusId;

    private String employStaffUid;

    private String employXueli;

    private Integer departmentId;

    private Integer employPositionId;

    private Date employInTime;

    private Integer employStaffStatusId;

    public Integer getEmployId() {
        return employId;
    }

    public void setEmployId(Integer employId) {
        this.employId = employId;
    }

    public Integer getApplyEmployId() {
        return applyEmployId;
    }

    public void setApplyEmployId(Integer applyEmployId) {
        this.applyEmployId = applyEmployId;
    }

    public Integer getEmployStatusId() {
        return employStatusId;
    }

    public void setEmployStatusId(Integer employStatusId) {
        this.employStatusId = employStatusId;
    }

    public String getEmployStaffUid() {
        return employStaffUid;
    }

    public void setEmployStaffUid(String employStaffUid) {
        this.employStaffUid = employStaffUid == null ? null : employStaffUid.trim();
    }

    public String getEmployXueli() {
        return employXueli;
    }

    public void setEmployXueli(String employXueli) {
        this.employXueli = employXueli == null ? null : employXueli.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getEmployPositionId() {
        return employPositionId;
    }

    public void setEmployPositionId(Integer employPositionId) {
        this.employPositionId = employPositionId;
    }

    public Date getEmployInTime() {
        return employInTime;
    }

    public void setEmployInTime(Date employInTime) {
        this.employInTime = employInTime;
    }

    public Integer getEmployStaffStatusId() {
        return employStaffStatusId;
    }

    public void setEmployStaffStatusId(Integer employStaffStatusId) {
        this.employStaffStatusId = employStaffStatusId;
    }

}