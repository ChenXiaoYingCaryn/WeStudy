package com.haizhi.westudy.pojo.dto;

import java.util.Date;

/**
 * @author xiaoying
 * @create 2023-01-01 下午 15:55
 */
public class UserLearnStats {

    private Long id;
    private Long courseId;
    private Long sectionId;
    private String userId;
    private Long learnedDuration;
    private Long mediaProgress;
    private Long mediaDuration;
    private String learnedStatus;
    private Date createDate;
    private Date updateDate;

    public UserLearnStats() {
    }

    public UserLearnStats(Long id, Long courseId, Long sectionId, String userId, Long learnedDuration, Long mediaProgress, Long mediaDuration, String learnedStatus, Date createDate, Date updateDate) {
        this.id = id;
        this.courseId = courseId;
        this.sectionId = sectionId;
        this.userId = userId;
        this.learnedDuration = learnedDuration;
        this.mediaProgress = mediaProgress;
        this.mediaDuration = mediaDuration;
        this.learnedStatus = learnedStatus;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getLearnedDuration() {
        return learnedDuration;
    }

    public void setLearnedDuration(Long learnedDuration) {
        this.learnedDuration = learnedDuration;
    }

    public Long getMediaProgress() {
        return mediaProgress;
    }

    public void setMediaProgress(Long mediaProgress) {
        this.mediaProgress = mediaProgress;
    }

    public Long getMediaDuration() {
        return mediaDuration;
    }

    public void setMediaDuration(Long mediaDuration) {
        this.mediaDuration = mediaDuration;
    }

    public String getLearnedStatus() {
        return learnedStatus;
    }

    public void setLearnedStatus(String learnedStatus) {
        this.learnedStatus = learnedStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "UserLearnStats{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", sectionId=" + sectionId +
                ", userId='" + userId + '\'' +
                ", learnedDuration=" + learnedDuration +
                ", mediaProgress=" + mediaProgress +
                ", mediaDuration=" + mediaDuration +
                ", learnedStatus='" + learnedStatus + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
