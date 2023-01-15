package com.haizhi.westudy.pojo.dto;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

/**
 * @author xiaoying
 * @create 2022-06-04 上午 10:37
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VideoReq {

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
    MultipartFile Video;

    /**
     * 视频封面
     */
    MultipartFile Img;

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

}
