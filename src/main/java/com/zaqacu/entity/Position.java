package com.zaqacu.entity;

public class Position extends MyPage {

    private Integer positionId;

    private String positionName;

    private Integer positionDepartmentId;

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
        this.positionName = positionName == null ? null : positionName.trim();
    }

    public Integer getPositionDepartmentId() {
        return positionDepartmentId;
    }

    public void setPositionDepartmentId(Integer positionDepartmentId) {
        this.positionDepartmentId = positionDepartmentId;
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

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", positionDepartmentId=" + positionDepartmentId +
                ", positionTotal=" + positionTotal +
                ", positionLacknum=" + positionLacknum +
                ", positionExitsnum=" + positionExitsnum +
                '}';
    }
}