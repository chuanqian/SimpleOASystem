package com.zaqacu.entitydto;

import com.zaqacu.entity.Department;
import com.zaqacu.entity.Position;
import com.zaqacu.entity.StaffStatus;
import com.zaqacu.entity.Training;
import com.zaqacu.util.TimeUtls;

import java.util.Date;

public class StaffDto {

    private String staffUid;

    private String staffName;

    private String staffSex;

    private Date staffBirth;

    private String staffPhone;

    private String staffEmail;

    private String staffXueli;

    //员工职位
    private Position position;

    private Date staffInTime;

    //员工状态
    private StaffStatus staffStatus;

    private String staffNote;

    //员工培训评价
    private Training training;

    //所在部门
    private Department department;

    private String trainingResult;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getTrainingResult() {
        return trainingResult;
    }

    public void setTrainingResult(String trainingResult) {
        this.trainingResult = trainingResult;
    }

    public String getStaffUid() {
        return staffUid;
    }

    public void setStaffUid(String staffUid) {
        this.staffUid = staffUid;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
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
        this.staffPhone = staffPhone;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffXueli() {
        return staffXueli;
    }

    public void setStaffXueli(String staffXueli) {
        this.staffXueli = staffXueli;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getStaffInTime() {
        return TimeUtls.getTimeFommat(this.staffInTime);
    }

    public void setStaffInTime(String staffInTime) {
        this.staffInTime = TimeUtls.getTimeParse(staffInTime);
    }

    public StaffStatus getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(StaffStatus staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getStaffNote() {
        return staffNote;
    }

    public void setStaffNote(String staffNote) {
        this.staffNote = staffNote;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
