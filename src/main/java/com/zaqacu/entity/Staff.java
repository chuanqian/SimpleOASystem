package com.zaqacu.entity;

import com.zaqacu.util.TimeUtls;

import java.util.Date;

public class Staff extends MyPage {

    private String staffUid;

    private String staffName;

    private String staffSex;

    private Date staffBirth;

    private String staffPhone;

    private String staffEmail;

    private String staffXueli;

    private Integer staffDepartmentId;

    private Integer staffPosition;

    private Date staffInTime;

    private Integer staffStatusId;

    private String staffNote;

    private Integer staffTrainingId;


    public String getStaffUid() {
        return staffUid;
    }

    public void setStaffUid(String staffUid) {
        this.staffUid = staffUid == null ? null : staffUid.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex == null ? null : staffSex.trim();
    }

    public String getStaffBirth() {
        return TimeUtls.getTimeFommat(this.staffBirth);
    }

    public void setStaffBirth(String staffBirth) {
        this.staffBirth = TimeUtls.getTimeParse(staffBirth);
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone == null ? null : staffPhone.trim();
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail == null ? null : staffEmail.trim();
    }

    public String getStaffXueli() {
        return staffXueli;
    }

    public void setStaffXueli(String staffXueli) {
        this.staffXueli = staffXueli == null ? null : staffXueli.trim();
    }

    public Integer getStaffDepartmentId() {
        return staffDepartmentId;
    }

    public void setStaffDepartmentId(Integer staffDepartmentId) {
        this.staffDepartmentId = staffDepartmentId;
    }

    public Integer getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(Integer staffPosition) {
        this.staffPosition = staffPosition;
    }

    public String getStaffInTime() {
        return TimeUtls.getTimeFommat(this.staffInTime);
    }

    public void setStaffInTime(String staffInTime) {
        this.staffInTime = TimeUtls.getTimeParse(staffInTime);
    }

    public Integer getStaffStatusId() {
        return staffStatusId;
    }

    public void setStaffStatusId(Integer staffStatusId) {
        this.staffStatusId = staffStatusId;
    }

    public String getStaffNote() {
        return staffNote;
    }

    public void setStaffNote(String staffNote) {
        this.staffNote = staffNote == null ? null : staffNote.trim();
    }

    public Integer getStaffTrainingId() {
        return staffTrainingId;
    }

    public void setStaffTrainingId(Integer staffTrainingId) {
        this.staffTrainingId = staffTrainingId;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffUid='" + staffUid + '\'' +
                ", staffName='" + staffName + '\'' +
                ", staffSex='" + staffSex + '\'' +
                ", staffBirth=" + staffBirth +
                ", staffPhone='" + staffPhone + '\'' +
                ", staffEmail='" + staffEmail + '\'' +
                ", staffXueli='" + staffXueli + '\'' +
                ", staffDepartmentId=" + staffDepartmentId +
                ", staffPosition=" + staffPosition +
                ", staffInTime=" + staffInTime +
                ", staffStatusId=" + staffStatusId +
                ", staffNote='" + staffNote + '\'' +
                ", staffTrainingId=" + staffTrainingId +
                '}';
    }
}