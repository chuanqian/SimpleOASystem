package com.zaqacu.entity;

import java.util.Date;

public class Pay extends MyPage{

    private Integer payId;

    private String payStaffUid;

    private Integer payBasicId;

    private Integer payMertisId;

    private Double payRewords;

    private Double payFine;

    private Double payTotal;

    private Date payTime;

    private Date startTimes;

    private Date endTimes;

    private String staffNamePay;

    public Date getStartTime() {
        return startTimes;
    }

    public void setStartTimes(Date startTime) {
        this.startTimes = startTime;
    }

    public Date getEndTime() {
        return endTimes;
    }

    public void setEndTimes(Date endTime) {
        this.endTimes = endTime;
    }

    public String getStaffNamePay() {
        return staffNamePay;
    }

    public void setStaffNamePay(String staffNamePay) {
        this.staffNamePay = staffNamePay;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPayStaffUid() {
        return payStaffUid;
    }

    public void setPayStaffUid(String payStaffUid) {
        this.payStaffUid = payStaffUid == null ? null : payStaffUid.trim();
    }

    public Integer getPayBasicId() {
        return payBasicId;
    }

    public void setPayBasicId(Integer payBasicId) {
        this.payBasicId = payBasicId;
    }

    public Integer getPayMertisId() {
        return payMertisId;
    }

    public void setPayMertisId(Integer payMertisId) {
        this.payMertisId = payMertisId;
    }

    public Double getPayRewords() {
        return payRewords;
    }

    public void setPayRewords(Double payRewords) {
        this.payRewords = payRewords;
    }

    public Double getPayFine() {
        return payFine;
    }

    public void setPayFine(Double payFine) {
        this.payFine = payFine;
    }

    public Double getPayTotal() {
        return payTotal;
    }

    public void setPayTotal(Double payTotal) {
        this.payTotal = payTotal;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

}