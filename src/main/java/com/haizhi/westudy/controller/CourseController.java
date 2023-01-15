package com.haizhi.westudy.controller;

import com.haizhi.westudy.pojo.dto.CourseDto;
import com.haizhi.westudy.service.CourseService;
import com.haizhi.westudy.utils.ResultUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xiaoying
 * @create 2023/1/12
 */
@Api
@RestController
@RequestMapping("/Course")
public class CourseController {

    @Autowired
    CourseService courseService;

    /**
     * 查询所有课程
     * @return
     */
    @GetMapping("/ListAllCourses")
    ResultUtils ListAllCourses(){
        return courseService.listAllCourses();
    }

    /**
     * 根据类型查询课程
     * @param type
     * @return
     */
    @GetMapping("/QueryCourseByType")
    ResultUtils QueryCourseByType(String type){
        return courseService.queryCourseByType(type);
    }

    /**
     * 根据用户id和标签查询课程
     * @param tag
     * @param userId
     * @return
     */
    @GetMapping("/QueryCourseByTagAndUserId")
    ResultUtils QueryCourseByTagAndUserId(String tag, String userId){
        return courseService.queryCourseByTagAndUserId(tag, userId);
    }

    /**
     * 根据用户id查询课程
     * @param userId
     * @return
     */
    @GetMapping("/QueryCourseByUserId")
    ResultUtils QueryCourseByUserId(String userId) {
        return courseService.queryCourseByUserId(userId);
    }

    /**
     * 根据用户名查询课程（模糊）
     * @param userName
     * @return
     */
    @GetMapping("/QueryCourseByUserName")
    ResultUtils QueryCourseByUserName(String userName) {
        return courseService.queryCourseByUserName(userName);
    }

    /**
     * 更新课程名称
     * @param name
     * @param id
     * @param userId
     * @return
     */
    @PostMapping("/UpdateCourse")
    ResultUtils UpdateCourse(String name, String id, String userId){
        return courseService.updateCourse(name, id, userId);
    }

    /**
     * 删除课程
     * @param id
     * @param userId
     * @return
     */
    @PostMapping("/DeleteCourse")
    ResultUtils DeleteCourse (String id, String userId){
        return courseService.deleteCourse(id, userId);
    }

    /**
     * 新建课程
     * @param dto
     * @return
     */
    @PostMapping("/CreateCourse")
    ResultUtils CreateCourse (CourseDto dto) {
        return courseService.createCourse(dto);
    }

}
