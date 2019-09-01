package com.zaqacu.entity;

public class UserLogin extends MyPage {
    private Integer userId;

    private Integer userPermissionsId;

    private String userName;

    private String userPassword;

    private String staffUid;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserPermissionsId() {
        return userPermissionsId;
    }

    public void setUserPermissionsId(Integer userPermissionsId) {
        this.userPermissionsId = userPermissionsId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getStaffUid() {
        return staffUid;
    }

    public void setStaffUid(String staffUid) {
        this.staffUid = staffUid == null ? null : staffUid.trim();
    }
}