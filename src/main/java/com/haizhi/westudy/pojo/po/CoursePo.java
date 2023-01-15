package com.haizhi.westudy.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xiaoying
 * @create 2023/1/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CoursePo {
    // 课程名称
    private String name;

    // 用户id
    private String userId;

    // 课程封面
    private String img;

    // 课程类型
    private Integer type;

    // 课程标签
    private Integer tag;
}
