package com.zaqacu.entity;

public class StaffArchives extends MyPage {

    private Integer archivesId;

    private String arcivesStaffUid;

    private String archivesName;

    private String archivesNote;

    private String archivesInfo;

    public Integer getArchivesId() {
        return archivesId;
    }

    public void setArchivesId(Integer archivesId) {
        this.archivesId = archivesId;
    }

    public String getArcivesStaffUid() {
        return arcivesStaffUid;
    }

    public void setArcivesStaffUid(String arcivesStaffUid) {
        this.arcivesStaffUid = arcivesStaffUid;
    }

    public String getArchivesName() {
        return archivesName;
    }

    public void setArchivesName(String archivesName) {
        this.archivesName = archivesName == null ? null : archivesName.trim();
    }

    public String getArchivesNote() {
        return archivesNote;
    }

    public void setArchivesNote(String archivesNote) {
        this.archivesNote = archivesNote == null ? null : archivesNote.trim();
    }

    public String getArchivesInfo() {
        return archivesInfo;
    }

    public void setArchivesInfo(String archivesInfo) {
        this.archivesInfo = archivesInfo == null ? null : archivesInfo.trim();
    }
}