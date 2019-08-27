package com.zaqacu.entitydto;

import com.zaqacu.entity.Staff;

public class StaffArchivesDto {

    private Integer archivesId;

    //员工
    private Staff staff;

    private String archivesName;

    private String archivesNote;

    private String archivesInfo;

    public Integer getArchivesId() {
        return archivesId;
    }

    public void setArchivesId(Integer archivesId) {
        this.archivesId = archivesId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getArchivesName() {
        return archivesName;
    }

    public void setArchivesName(String archivesName) {
        this.archivesName = archivesName;
    }

    public String getArchivesNote() {
        return archivesNote;
    }

    public void setArchivesNote(String archivesNote) {
        this.archivesNote = archivesNote;
    }

    public String getArchivesInfo() {
        return archivesInfo;
    }

    public void setArchivesInfo(String archivesInfo) {
        this.archivesInfo = archivesInfo;
    }
}
