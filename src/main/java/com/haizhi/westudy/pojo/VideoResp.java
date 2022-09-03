package com.haizhi.westudy.pojo;

import javax.xml.crypto.Data;

/**
 * @author xiaoying
 * @create 2022-06-03 下午 5:04
 */
public class VideoResp {

    String Id;
    String Title;
    String Url;
    String Img;
    String Type;
    String userId;
    Integer isDelete;
    Data updateTime;

    public VideoResp() {
    }

    public VideoResp(String id, String title, String url, String img, String type, String userId, Integer isDelete, Data updateTime) {
        Id = id;
        Title = title;
        Url = url;
        Img = img;
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
        return "Video{" +
                "Id='" + Id + '\'' +
                ", Title='" + Title + '\'' +
                ", Url='" + Url + '\'' +
                ", Img='" + Img + '\'' +
                ", Type='" + Type + '\'' +
                ", userId='" + userId + '\'' +
                ", isDeleted=" + isDelete +
                ", updateTime=" + updateTime +
                '}';
    }
}
