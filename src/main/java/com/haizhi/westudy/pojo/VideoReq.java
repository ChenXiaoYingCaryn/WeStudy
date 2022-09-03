package com.haizhi.westudy.pojo;

import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;

/**
 * @author xiaoying
 * @create 2022-06-04 上午 10:37
 */
public class VideoReq {

    String Id;
    String Title;
    MultipartFile video;
    MultipartFile Img;
    String Type;
    String userId;
    Integer isDeleted;
    Data updateTime;

    public VideoReq() {
    }

    public VideoReq(String id, String title, MultipartFile video, MultipartFile img, String type, String userId, Integer isDeleted, Data updateTime) {
        Id = id;
        Title = title;
        this.video = video;
        Img = img;
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

    public MultipartFile getVideo() {
        return video;
    }

    public void setVideo(MultipartFile video) {
        this.video = video;
    }

    public MultipartFile getImg() {
        return Img;
    }

    public void setImg(MultipartFile img) {
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
        return "VideoReq{" +
                "Id='" + Id + '\'' +
                ", Title='" + Title + '\'' +
                ", video=" + video +
                ", Img=" + Img +
                ", Type='" + Type + '\'' +
                ", userId='" + userId + '\'' +
                ", isDeleted=" + isDeleted +
                ", updateTime=" + updateTime +
                '}';
    }
}
