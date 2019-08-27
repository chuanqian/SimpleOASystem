package com.zaqacu.entity;

public class EmployStatus {

    private Integer employStatusId;

    private String employStatusName;

    public Integer getEmployStatusId() {
        return employStatusId;
    }

    public void setEmployStatusId(Integer employStatusId) {
        this.employStatusId = employStatusId;
    }

    public String getEmployStatusName() {
        return employStatusName;
    }

    public void setEmployStatusName(String employStatusName) {
        this.employStatusName = employStatusName == null ? null : employStatusName.trim();
    }

}