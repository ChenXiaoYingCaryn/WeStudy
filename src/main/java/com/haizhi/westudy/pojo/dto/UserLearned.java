package com.haizhi.westudy.pojo.dto;

import java.util.Date;

/**
 * @author xiaoying
 * @create 2023-01-01 下午 15:55
 */
public class UserLearned {

    private Long id;
    private Long courseId;
    private Long sectionId;
    private String userId;
    private Long duration;
    private String learnStats;
    private Date createDate;
    private Date updateDate;

    public UserLearned() {
    }

    public UserLearned(Long id, Long courseId, Long sectionId, String userId, Long duration, String learnStats, Date createDate, Date updateDate) {
        this.id = id;
        this.courseId = courseId;
        this.sectionId = sectionId;
        this.userId = userId;
        this.duration = duration;
        this.learnStats = learnStats;
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

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getLearnStats() {
        return learnStats;
    }

    public void setLearnStats(String learnStats) {
        this.learnStats = learnStats;
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
        return "UserLearned{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", sectionId=" + sectionId +
                ", userId='" + userId + '\'' +
                ", duration=" + duration +
                ", learnStats='" + learnStats + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
