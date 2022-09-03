package com.haizhi.westudy.pojo.dao;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 5:01
 */
public class UserForDao {

    String userId;
    String userName;
    String userPwd;
    String userProfile;
    Integer userStudyType;

    public UserForDao() {
    }

    public UserForDao(String userName, String userPwd, String userProfile, Integer userStudyType) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userProfile = userProfile;
        this.userStudyType = userStudyType;
    }

    public UserForDao(String userId, String userName, String userPwd, String userProfile, Integer userStudyType) {
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

    public Integer getUserStudyType() {
        return userStudyType;
    }

    public void setUserStudyType(Integer userStudyType) {
        this.userStudyType = userStudyType;
    }

    @Override
    public String toString() {
        return "UserForDao{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userProfile='" + userProfile + '\'' +
                ", userStudyType=" + userStudyType +
                '}';
    }
}
