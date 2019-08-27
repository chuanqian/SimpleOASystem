package com.zaqacu.entity;

public class UserLogin {

    private Integer userId;

    private String limitName;

    private String userName;

    private String userPassword;

    private String staffUid;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLimitName() {
        return limitName;
    }

    public void setLimitName(String limitName) {
        this.limitName = limitName == null ? null : limitName.trim();
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

    @Override
    public String toString() {
        return "UserLogin{" +
                "userId=" + userId +
                ", limitName='" + limitName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", staffUid='" + staffUid + '\'' +
                '}';
    }
}