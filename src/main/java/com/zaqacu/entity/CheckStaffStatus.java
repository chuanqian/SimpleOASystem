package com.zaqacu.entity;

public class CheckStaffStatus {

    private Integer checkStaffStatusId;

    private String checkStaffStatusUid;

    private String checkStaffStatusName;

    public Integer getCheckStaffStatusId() {
        return checkStaffStatusId;
    }

    public void setCheckStaffStatusId(Integer checkStaffStatusId) {
        this.checkStaffStatusId = checkStaffStatusId;
    }

    public String getCheckStaffStatusUid() {
        return checkStaffStatusUid;
    }

    public void setCheckStaffStatusUid(String checkStaffStatusUid) {
        this.checkStaffStatusUid = checkStaffStatusUid == null ? null : checkStaffStatusUid.trim();
    }

    public String getCheckStaffStatusName() {
        return checkStaffStatusName;
    }

    public void setCheckStaffStatusName(String checkStaffStatusName) {
        this.checkStaffStatusName = checkStaffStatusName == null ? null : checkStaffStatusName.trim();
    }
}