package com.zaqacu.entitydto;

import com.zaqacu.entity.Check;
import com.zaqacu.entity.CheckType;
import com.zaqacu.entity.Staff;

public class CheckDto extends Check {
    private Staff staffBei;
    private Staff staff;
    private String typeName;
    private CheckType checkType;
    private String staffBeiName;
    private String staffName;

    public Staff getStaffBei() {
        return staffBei;
    }

    public void setStaffBei(Staff staffBei) {
        this.staffBei = staffBei;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getTypeName() {
        return checkType.getCheckTypeName();
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public CheckType getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckType checkType) {
        this.checkType = checkType;
    }

    public String getStaffBeiName() {
        return staffBei.getStaffName();
    }

    public void setStaffBeiName(String staffBeiName) {
        this.staffBeiName = staffBeiName;
    }

    public String getStaffName() {
        return staff.getStaffName();
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
