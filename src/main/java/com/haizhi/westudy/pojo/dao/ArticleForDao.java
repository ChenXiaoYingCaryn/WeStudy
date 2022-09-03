package com.haizhi.westudy.pojo.dao;

import javax.xml.crypto.Data;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 10:12
 */
public class ArticleForDao {

    String Id;
    String Title;
    String Text;
    Integer Type;
    String userId;
    Integer isDelete;
    Data updateTime;

    public ArticleForDao() {
    }

    public ArticleForDao(String id, String title, String text, Integer type, String userId) {
        Id = id;
        Title = title;
        Text = text;
        Type = type;
        this.userId = userId;
    }
    public ArticleForDao(String title, String text, Integer type, String userId) {
        Title = title;
        Text = text;
        Type = type;
        this.userId = userId;
    }

    public ArticleForDao(String id, String title, String text, Integer type, String userId, Integer isDelete, Data updateTime) {
        Id = id;
        Title = title;
        Text = text;
        Type = type;
        this.userId = userId;
        this.isDelete = isDelete;
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

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Data getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Data updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ArticleForDao{" +
                "Id='" + Id + '\'' +
                ", Title='" + Title + '\'' +
                ", Text='" + Text + '\'' +
                ", Type=" + Type +
                ", userId='" + userId + '\'' +
                ", isDeleted=" + isDelete +
                ", updateTime=" + updateTime +
                '}';
    }
}
