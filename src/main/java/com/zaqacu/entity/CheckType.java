package com.zaqacu.entity;

public class CheckType extends MyPage {

    private Integer checkTypeId;

    private String checkTypeName;

    private Double checkTypeMoney;

    public Integer getCheckTypeId() {
        return checkTypeId;
    }

    public void setCheckTypeId(Integer checkTypeId) {
        this.checkTypeId = checkTypeId;
    }

    public String getCheckTypeName() {
        return checkTypeName;
    }

    public void setCheckTypeName(String checkTypeName) {
        this.checkTypeName = checkTypeName == null ? null : checkTypeName.trim();
    }

    public Double getCheckTypeMoney() {
        return checkTypeMoney;
    }

    public void setCheckTypeMoney(Double checkTypeMoney) {
        this.checkTypeMoney = checkTypeMoney;
    }
}