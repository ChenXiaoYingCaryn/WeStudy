package com.haizhi.westudy.dao;

import com.haizhi.westudy.pojo.vo.VideoVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xiaoying
 * @create 2022-06-04 上午 10:19
 */
@Mapper
public interface VideoDao {

    @Select("select count(*) from db_video where user_id = #{userId} and isDelete = 0")
    int countUserVideo(Integer userId);

    @Select("select * from db_video where user_id = #{userId} and is_delete = 0")
    List<VideoVo> queryVideoByUserId(Integer userId);

    @Select("select * from db_video where type = #{type} and is_delete = 0")
    List<VideoVo> queryVideoByType(Integer type);

    @Select("select * from db_video where is_delete = 0")
    List<VideoVo> queryVideo();

    @Update("update db_video set is_delete = 1 where Id = #{Id}")
    void deleteVideo(Integer Id);

    @Select("SELECT * FROM db_video WHERE Id = #{Id} AND is_delete = 0")
    VideoVo getVideoByVideoId(Integer Id);

    @Update({
            "<script> ",
            "update db_video set ",
            "<if test = \"video.Title != null\"> ",
            "title = #{video.Title}, ",
            "</if> ",
            "<if test = \"video.Video != null\"> ",
            "video = #{video.Video}, ",
            "</if> ",
            "<if test = \"video.Img != null\"> ",
            "img = #{video.Img}, ",
            "</if> ",
            "<if test = \"video.Type != null\"> ",
            "type = #{video.Type}, ",
            "</if> ",
            "<if test = \"video.courseId != null\"> ",
            "type = #{video.courseId}, ",
            "</if> ",
            "<if test = \"video.sectionId != null\"> ",
            "type = #{video.sectionId}, ",
            "</if> ",
            "update_time=CURRENT_TIMESTAMP ",
            "WHERE Id = #{video.Id} AND is_delete = 0",
            "</script>"
    })
    void updateVideo(@Param("video") VideoVo video);

    @Insert("INSERT INTO db_video (title, video, img, type, course_id, section_id, user_id) VALUES " +
            "(#{video.Title}, #{video.Video}, #{video.Img}, #{video.Type}, #{video.courseId}, #{video.sectionId}, " +
            "#{video.userId})")
    void postVideo(@Param("video") VideoVo video);

}
