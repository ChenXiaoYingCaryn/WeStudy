package com.haizhi.westudy.pojo;

/**
 * @author xiaoying
 * @create 2022-06-04 下午 10:00
 */
public class UserResp {

    String userId;
    String userName;
    String userProfile;
    String userStudyType;

    public UserResp() {
    }

    public UserResp(String userId, String userName, String userProfile, String userStudyType) {
        this.userId = userId;
        this.userName = userName;
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
        return "UserResp{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userProfile='" + userProfile + '\'' +
                ", userStudyType='" + userStudyType + '\'' +
                '}';
    }
}
