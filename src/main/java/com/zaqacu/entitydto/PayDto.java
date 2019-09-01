package com.zaqacu.entitydto;

import com.zaqacu.entity.BasicMoney;
import com.zaqacu.entity.MertisMoney;
import com.zaqacu.entity.Staff;
import com.zaqacu.util.TimeUtls;

import java.util.Date;

public class PayDto {

    private Integer payId;

    private String payStaffUid;

    private Staff staff;

    private String staffName;

    private Integer payBasicId;

    private BasicMoney basicMoney;

    private double basicNum;

    private Integer payMertisId;

    private MertisMoney mertisMoney;

    private double mertisNum;

    private Double payRewords;

    private Double payFine;

    private Double payTotal;

    private Date payTime;

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
        this.payStaffUid = payStaffUid;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getStaffName() {
        return staff.getStaffName();
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getPayBasicId() {
        return payBasicId;
    }

    public void setPayBasicId(Integer payBasicId) {
        this.payBasicId = payBasicId;
    }

    public BasicMoney getBasicMoney() {
        return basicMoney;
    }

    public void setBasicMoney(BasicMoney basicMoney) {
        this.basicMoney = basicMoney;
    }

    public double getBasicNum() {
        return basicMoney.getBasicMoneyNum();
    }

    public void setBasicNum(double basicNum) {
        this.basicNum = basicNum;
    }

    public Integer getPayMertisId() {
        return payMertisId;
    }

    public void setPayMertisId(Integer payMertisId) {
        this.payMertisId = payMertisId;
    }

    public MertisMoney getMertisMoney() {
        return mertisMoney;
    }

    public void setMertisMoney(MertisMoney mertisMoney) {
        this.mertisMoney = mertisMoney;
    }

    public double getMertisNum() {
        return mertisMoney.getMertisMoneyNum();
    }

    public void setMertisNum(double mertisNum) {
        this.mertisNum = mertisNum;
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

    public String getPayTime() {
        return TimeUtls.getTimeFommat(payTime);
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
