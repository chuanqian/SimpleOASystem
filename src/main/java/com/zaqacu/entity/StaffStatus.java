package com.zaqacu.entity;

public class StaffStatus extends MyPage {

    private Integer staffStatusId;

    private String staffStatusName;

    public Integer getStaffStatusId() {
        return staffStatusId;
    }

    public void setStaffStatusId(Integer staffStatusId) {
        this.staffStatusId = staffStatusId;
    }


    public String getStaffStatusName() {
        return staffStatusName;
    }

    public void setStaffStatusName(String staffStatusName) {
        this.staffStatusName = staffStatusName == null ? null : staffStatusName.trim();
    }
}