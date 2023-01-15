package com.haizhi.westudy.pojo.dto;


/**
 * @author xiaoying
 * @create 2022-05-29 下午 4:18
 */
public class User {

    String userId;
    String userName;
    String userPwd;
    String userProfile;
    String userStudyType;

    public User() {
    }

    public User(String userId, String userName, String userPwd, String userProfile, String userStudyType) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userProfile = userProfile;
        this.userStudyType = userStudyType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public String getUserStudyType() {
        return userStudyType;
    }

    public void setUserStudyType(String userStudyType) {
        this.userStudyType = userStudyType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userProfile='" + userProfile + '\'' +
                ", userStudyType='" + userStudyType + '\'' +
                '}';
    }
}
