package com.haizhi.westudy.pojo.dto;

/**
 * 媒体播放进度前端传入参数
 * @author xiaoying
 * @create 2023/1/1
 */
public class ProgressDto {

    /**
     * 节id(媒体视频id)
     */
    private Long sectionId;
    /**
     * 代表媒体视频或者文档属于哪个维度下的id，比如学习维度，娱乐维度
     */
    private Long courseId;
    /**
     * 类型，代表当前是媒体视频还是文档
     */
    private String sectionType;
    /**
     * 增量时间，非视频为0，视频就传新增的看视频时长
     */
    private Long deltaDuration;
    /**
     * 视频播放节点，非视频为0，视频就传已看到的视频节点
     */
    private Long mediaProgress;
    /**
     * 是否第一次打开当前媒体。(方便以后扩展使用)
     */
    private Boolean first;

    public ProgressDto() {
    }

    public ProgressDto(Long sectionId, Long courseId, String sectionType, Long deltaDuration, Long mediaProgress, Boolean first) {
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.sectionType = sectionType;
        this.deltaDuration = deltaDuration;
        this.mediaProgress = mediaProgress;
        this.first = first;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getSectionType() {
        return sectionType;
    }

    public void setSectionType(String sectionType) {
        this.sectionType = sectionType;
    }

    public Long getDeltaDuration() {
        return deltaDuration;
    }

    public void setDeltaDuration(Long deltaDuration) {
        this.deltaDuration = deltaDuration;
    }

    public Long getMediaProgress() {
        return mediaProgress;
    }

    public void setMediaProgress(Long mediaProgress) {
        this.mediaProgress = mediaProgress;
    }

    public Boolean getFirst() {
        return first;
    }

    public void setFirst(Boolean first) {
        this.first = first;
    }

    @Override
    public String toString() {
        return "ProgressRequest{" +
                "sectionId=" + sectionId +
                ", courseId=" + courseId +
                ", sectionType='" + sectionType + '\'' +
                ", deltaDuration=" + deltaDuration +
                ", mediaProgress=" + mediaProgress +
                ", first=" + first +
                '}';
    }
}
