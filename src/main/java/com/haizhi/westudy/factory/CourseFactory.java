package com.haizhi.westudy.factory;

import com.haizhi.westudy.pojo.dto.CourseDto;
import com.haizhi.westudy.pojo.po.CoursePo;

/**
 * @author xiaoying
 * @create 2023/1/14
 */
public class CourseFactory {

    public static CoursePo CourseDtoToCoursePo(CourseDto dto, String imgUrl){
        CoursePo po = new CoursePo();
        po.setName(dto.getName());
        po.setUserId(dto.getUserId());
        po.setImg(imgUrl);
        if(dto.getTag() != null){
            po.setTag(dto.getTag());
        }
        po.setType(dto.getType());
        return po;
    }
}
