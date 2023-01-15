package com.haizhi.westudy.dao;

import com.haizhi.westudy.pojo.dto.CourseDto;
import com.haizhi.westudy.pojo.po.CoursePo;
import com.haizhi.westudy.pojo.vo.CourseVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xiaoying
 * @create 2023/1/12
 */

@Mapper
public interface CourseDao {

    @Select("select course.name as course_name, course.img as course_img, tag.tag, type.type, course.create_time as create_time, user.userName as user_name " +
            "from db_course course, db_user user, db_tag tag, db_type type " +
            "where user.userId = course.user_id and course.type = type.id and course.tag = tag.id")
    List<CourseVo> listAllCourses();

    @Select("select course.name as course_name, course.img as course_img, tag.tag, type.type, course.create_time as create_time, user.userName as user_name " +
            "from db_course course, db_user user, db_tag tag, db_type type " +
            "where type.type = #{type} and user.userId = course.user_id and course.type = type.id and course.tag = tag.id")
    List<CourseVo> queryCourseByType(String type);

    @Select("select course.name as course_name, course.img as course_img, tag.tag, type.type, course.create_time as create_time, user.userName as user_name " +
            "from db_course course, db_user user, db_tag tag, db_type type " +
            "where user.userId = #{userId} and user.userId = course.user_id and tag.tag = #{tag} and course.type = type.id and course.tag = tag.id")
    List<CourseVo> queryCourseByTagAndUserId(String tag, String userId);

    @Select("select course.name as course_name, course.img as course_img, tag.tag, type.type, course.create_time as create_time, user.userName as user_name " +
            "from db_course course, db_user user, db_tag tag, db_type type " +
            "where user.userId = #{userId} and user.userId = course.user_id and course.type = type.id and course.tag = tag.id")
    List<CourseVo> queryCourseByUserId(String userId);

    @Select("select course.name as course_name, course.img as course_img, tag.tag, type.type, course.create_time as create_time, user.userName as user_name " +
            "from db_course course, db_user user, db_tag tag, db_type type " +
            "where user.userName like '%${userName}%' and user.userId = course.user_id and is_delete = 0 and course.type = type.id and course.tag = tag.id")
    List<CourseVo> queryCourseByUserName(@Param("userName") String userName);

    @Update("update db_course set name = #{name} where id = #{id} and user_id = #{userId} ")
    void updateCourseName(String name, String id, String userId);

    @Update("update db_course set is_delete = 1 where id = #{id} and user_id = #{userId}")
    void deleteCourse(String id, String userId);

    @Insert("insert into db_course (name, img, user_id) values ( #{po.name}, #{po.img}, #{po.userId})")
    void createCourse(CoursePo po);

}
