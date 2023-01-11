package com.haizhi.westudy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * @author xiaoying
 * @create 2022-06-03 下午 5:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VideoResp {

    /**
     * id
     */
    String Id;

    /**
     * 视频名称
     */
    String Title;

    /**
     * 视频
     */
    String Video;

    /**
     * 视频封面
     */
    String Img;

    /**
     * 视频类型
     */
    Integer Type;

    /**
     * 用户id
     */
    String UserId;

    /**
     * 课程id
     */
    String CourseId;

    /**
     * 视频集数
     */
    String SectionId;

    /**
     * 是否删除
     */
    Integer IsDelete;

    /**
     * 更新时间
     */
    String UpdateTime;

    /**
     * 创建时间
     */
    String CreateTime;

}
