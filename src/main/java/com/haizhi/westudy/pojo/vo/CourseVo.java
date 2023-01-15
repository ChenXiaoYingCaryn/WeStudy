package com.haizhi.westudy.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xiaoying
 * @create 2023/1/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseVo {

    // 课程名称
    private String courseName;

    // 课程封面
    private String courseImg;

    // 课程创建者名称
    private String userName;

    // 课程类型
    private String type;

    // 课程标签
    private String tag;

    // 创建时间
    private String createTime;
}
