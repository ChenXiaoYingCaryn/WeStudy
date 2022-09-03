package com.haizhi.westudy.pojo.dao;

import javax.xml.crypto.Data;

/**
 * @author xiaoying
 * @create 2022-06-03 下午 5:11
 */
public class VideoForDao {

    String Id;
    String Title;
    String Url;
    String Img;
    Integer Type;
    String userId;
    Integer isDelete;
    Data updateTime;

    public VideoForDao() {
    }

    public VideoForDao(String title, String url, String img, Integer type, String userId) {
        Title = title;
        Url = url;
        Img = img;
        Type = type;
        this.userId = userId;
    }

    public VideoForDao(String id, String title, String url, String img, Integer type, String userId, Integer isDeleted, Data updateTime) {
        Id = id;
        Title = title;
        Url = url;
        Img = img;
        Type = type;
        this.userId = userId;
        this.isDelete = isDeleted;
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

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
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
        return "VideoForDao{" +
                "Id='" + Id + '\'' +
                ", Title='" + Title + '\'' +
                ", Url='" + Url + '\'' +
                ", Img='" + Img + '\'' +
                ", Type=" + Type +
                ", userId='" + userId + '\'' +
                ", isDeleted=" + isDelete +
                ", updateTime=" + updateTime +
                '}';
    }
}
