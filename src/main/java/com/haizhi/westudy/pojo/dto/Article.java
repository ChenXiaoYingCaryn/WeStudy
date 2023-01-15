package com.haizhi.westudy.pojo.dto;

import javax.xml.crypto.Data;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 10:06
 */
public class Article {

    String Id;
    String Title;
    String Text;
    String Type;
    String userId;
    Integer isDeleted;
    Data updateTime;

    public Article() {
    }

    public Article(String id, String title, String text, String type, String userId, Integer isDeleted, Data updateTime) {
        Id = id;
        Title = title;
        Text = text;
        Type = type;
        this.userId = userId;
        this.isDeleted = isDeleted;
        this.updateTime = updateTime;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Data getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Data updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "Id='" + Id + '\'' +
                ", Title='" + Title + '\'' +
                ", Text='" + Text + '\'' +
                ", Type='" + Type + '\'' +
                ", userId='" + userId + '\'' +
                ", isDeleted=" + isDeleted +
                ", updateTime=" + updateTime +
                '}';
    }
}
