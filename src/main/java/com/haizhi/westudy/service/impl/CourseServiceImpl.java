package com.haizhi.westudy.service.impl;

import com.haizhi.westudy.dao.CourseDao;
import com.haizhi.westudy.enums.UploadEnum;
import com.haizhi.westudy.factory.CourseFactory;
import com.haizhi.westudy.pojo.dto.CourseDto;
import com.haizhi.westudy.pojo.po.CoursePo;
import com.haizhi.westudy.pojo.vo.CourseVo;
import com.haizhi.westudy.service.CourseService;
import com.haizhi.westudy.utils.ResultUtils;
import com.haizhi.westudy.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaoying
 * @create 2023/1/12
 */

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Override
    public ResultUtils listAllCourses() {
        List<CourseVo> list;

        try{
            list = courseDao.listAllCourses();
        }catch (Exception e){
            return ResultUtils.build(100, "Failed to list all courses", e.getMessage());
        }

        return ResultUtils.build(200, "Success to list all courses", list);
    }

    @Override
    public ResultUtils queryCourseByType(String type) {
        List<CourseVo> list;

        try{
            list = courseDao.queryCourseByType(type);
        }catch (Exception e){
            return ResultUtils.build(100, "Failed to query the course by type", e.getMessage());
        }

        return ResultUtils.build(200, "Success to query the course by type", list);
    }

    @Override
    public ResultUtils queryCourseByTagAndUserId(String tag, String userId) {
        List<CourseVo> list;

        try{
            list = courseDao.queryCourseByTagAndUserId(tag, userId);
        }catch (Exception e){
            return ResultUtils.build(100, "Failed to query the course by user id and tag", e.getMessage());
        }

        return ResultUtils.build(200, "Success to query the course by user id and tag", list);
    }

    @Override
    public ResultUtils queryCourseByUserId(String userId) {
        List<CourseVo> list;

        try{
            list = courseDao.queryCourseByUserId(userId);
        }catch (Exception e){
            return ResultUtils.build(100, "Failed to query the course by user id", e.getMessage());
        }

        return ResultUtils.build(200, "Success to query the course by user id", list);
    }

    @Override
    public ResultUtils queryCourseByUserName(String userName) {

        List<CourseVo> list;

        try{
            list = courseDao.queryCourseByUserName(userName);
        }catch (Exception e){
            return ResultUtils.build(100, "Failed to query the course by user name", e.getMessage());
        }

        return ResultUtils.build(200, "Success to query the course by user name", list);
    }

    @Override
    public ResultUtils updateCourse(String name, String id, String userId) {
        try {
            courseDao.updateCourseName(name, id, userId);
        }catch (Exception e){
            return ResultUtils.build(100, "update course fail", e.getMessage());
        }
        return ResultUtils.build(200, "update course success", null);
    }

    @Override
    public ResultUtils deleteCourse(String id, String userId) {
        try{
            courseDao.deleteCourse(id, userId);
        }catch (Exception e){
            return ResultUtils.build(100, "delete course fail", e.getMessage());
        }
        return ResultUtils.build(200, "delete course success", null);
    }

    @Override
    public ResultUtils createCourse(CourseDto dto) {
        if(dto.getImg() == null){
            return  ResultUtils.build(100, "You have to upload the cover of the course",null);
        }

        ResultUtils resp = UploadUtils.uploadFile(dto.getImg(), UploadEnum.image);
        if(resp.getStatus() == 100){
            return resp;
        }

        CoursePo po = CourseFactory.CourseDtoToCoursePo(dto, (String) resp.getData());

        try{
            courseDao.createCourse(po);
        }catch (Exception e){
            return ResultUtils.build(100, "create course fail", e.getMessage());
        }
        return ResultUtils.build(200, "create course success", null);
    }
}
