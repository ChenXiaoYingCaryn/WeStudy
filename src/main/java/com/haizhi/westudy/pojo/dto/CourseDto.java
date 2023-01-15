package com.haizhi.westudy.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xiaoying
 * @create 2023/1/11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseDto {

    // 课程名称
    private String name;

    // 课程封面
    private MultipartFile img;

    // 用户id
    private String userId;

    // 课程所属类型  --> 前端、后台
    private Integer type;

    // 课程标签（自定义课程分类）
    private Integer tag;
}
