package com.zaqacu.entitydto;

import com.zaqacu.entity.Personnel;
import com.zaqacu.entity.Position;
import com.zaqacu.entity.Staff;

public class PersonnelDto extends Personnel {
    private Position position;
    private Staff staff;
    private String staffUid;
    private String positionName;
    private String oldName;
    private String newNmae;
    private String staffInTime;

    public String getStaffInTime() {
        return this.staff.getStaffInTime();
    }

    public void setStaffInTime(String staffInTime) {
        this.staffInTime = staffInTime;
    }

    public String getNewNmae() {
        return newNmae;
    }

    public void setNewNmae(String newNmae) {
        this.newNmae = newNmae;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getsName() {

        return this.sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    private  String sName;

    public String getStaffUid() {
        return staffUid;
    }

    public void setStaffUid(String staffUid) {
        this.staffUid = staffUid;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
