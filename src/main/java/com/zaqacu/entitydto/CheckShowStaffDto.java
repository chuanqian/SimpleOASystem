package com.zaqacu.entitydto;

import com.zaqacu.entity.CheckStaffStatus;
import com.zaqacu.entity.Staff;

public class CheckShowStaffDto {
    private String staffName;
    private String staffSex;
    private String staffPhone;
    private String staffXueli;
    private String checkStaffStatusName;
    private String staffUid;
    private Staff staff;
    private CheckStaffStatus checkStaffStatus;

    public String getStaffName() {
        return staff.getStaffName();
    }

    public String getStaffUid() {
        return staff.getStaffUid();
    }

    public void setStaffUid(String staffUid) {
        this.staffUid = staffUid;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffSex() {
        return staff.getStaffSex();
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }

    public String getStaffPhone() {
        return staff.getStaffPhone();
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffXueli() {
        return staff.getStaffXueli();
    }

    public void setStaffXueli(String staffXueli) {
        this.staffXueli = staffXueli;
    }

    public String getCheckStaffStatusName() {
        return checkStaffStatus.getCheckStaffStatusName();
    }

    public void setCheckStaffStatusName(String checkStaffStatusName) {
        this.checkStaffStatusName = checkStaffStatusName;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public CheckStaffStatus getCheckStaffStatus() {
        return checkStaffStatus;
    }

    public void setCheckStaffStatus(CheckStaffStatus checkStaffStatus) {
        this.checkStaffStatus = checkStaffStatus;
    }
}
