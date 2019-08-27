package com.zaqacu.entitydto;

import com.zaqacu.entity.Position;
import com.zaqacu.entity.Staff;
import com.zaqacu.util.TimeUtls;

import java.util.Date;

public class StaffPactDto {

    private Integer pactId;

    //员工
    private Staff staff;

    private Date pactCreateTime;

    private Date pactEndTime;

    //员工职务
    private Position position;

    private String pactNote;

    private String pactInfo;

    public Integer getPactId() {
        return pactId;
    }

    public void setPactId(Integer pactId) {
        this.pactId = pactId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getPactCreateTime() {
        return TimeUtls.getTimeFommat(this.pactCreateTime);
    }

    public void setPactCreateTime(String pactCreateTime) {
        this.pactCreateTime = TimeUtls.getTimeParse(pactCreateTime);
    }

    public String getPactEndTime() {
        return TimeUtls.getTimeFommat(pactEndTime);
    }

    public void setPactEndTime(String pactEndTime) {
        this.pactEndTime = TimeUtls.getTimeParse(pactEndTime);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getPactNote() {
        return pactNote;
    }

    public void setPactNote(String pactNote) {
        this.pactNote = pactNote;
    }

    public String getPactInfo() {
        return pactInfo;
    }

    public void setPactInfo(String pactInfo) {
        this.pactInfo = pactInfo;
    }
}
