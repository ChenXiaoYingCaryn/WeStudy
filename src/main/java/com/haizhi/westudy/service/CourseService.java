package com.haizhi.westudy.service;

import com.haizhi.westudy.pojo.dto.CourseDto;
import com.haizhi.westudy.pojo.po.CoursePo;
import com.haizhi.westudy.utils.ResultUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xiaoying
 * @create 2023/1/12
 */
public interface CourseService {

    ResultUtils listAllCourses();

    ResultUtils queryCourseByType(String type);

    ResultUtils queryCourseByTagAndUserId(String tag, String userId);

    ResultUtils queryCourseByUserId (String userId);

    ResultUtils queryCourseByUserName (String userName);

    ResultUtils updateCourse (String name, String id, String userId);

    ResultUtils deleteCourse (String id, String userId);

    ResultUtils createCourse (CourseDto dto);

}
