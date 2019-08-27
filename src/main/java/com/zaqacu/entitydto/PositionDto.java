package com.zaqacu.entitydto;

import com.zaqacu.entity.Department;

public class PositionDto {
    private Integer positionId;

    private String positionName;

    private Department department;

    private Integer positionTotal;

    private Integer positionLacknum;

    private Integer positionExitsnum;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getPositionTotal() {
        return positionTotal;
    }

    public void setPositionTotal(Integer positionTotal) {
        this.positionTotal = positionTotal;
    }

    public Integer getPositionLacknum() {
        return positionLacknum;
    }

    public void setPositionLacknum(Integer positionLacknum) {
        this.positionLacknum = positionLacknum;
    }

    public Integer getPositionExitsnum() {
        return positionExitsnum;
    }

    public void setPositionExitsnum(Integer positionExitsnum) {
        this.positionExitsnum = positionExitsnum;
    }
}
