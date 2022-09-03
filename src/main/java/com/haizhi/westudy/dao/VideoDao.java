package com.haizhi.westudy.dao;

import com.haizhi.westudy.pojo.dao.VideoForDao;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author xiaoying
 * @create 2022-06-04 上午 10:19
 */
@Mapper
public interface VideoDao {

    @Select("select count(*) from db_video where userId = #{userId} and isDelete = 0")
    int countUserVideo(Integer userId);

    @Select("select * from db_video where userId = #{userId} and isDelete = 0")
    List<VideoForDao> queryVideoByUserId(Integer userId);

    @Select("select * from db_video where Type = #{type} and isDelete = 0")
    List<VideoForDao> queryVideoByType(Integer type);

    @Select("select * from db_video where isDelete = 0")
    List<VideoForDao> queryVideo();

    @Update("update db_video set isDelete = 1 where Id = #{Id}")
    void deleteVideo(Integer Id);

    @Select("SELECT * FROM db_video WHERE Id = #{Id} AND isDelete = 0")
    VideoForDao getVideoByVideoId(Integer Id);

    @Update({
            "<script> ",
            "update db_video set ",
            "<if test = \"video.Title != null\"> ",
            "Title = #{video.Title}, ",
            "</if> ",
            "<if test = \"video.Url != null\"> ",
            "Url = #{video.Url}, ",
            "</if> ",
            "<if test = \"video.Img != null\"> ",
            "Img = #{video.Img}, ",
            "</if> ",
            "<if test = \"video.Type != null\"> ",
            "Type = #{video.Type}, ",
            "</if> ",
            "update_time=CURRENT_TIMESTAMP ",
            "WHERE Id = #{video.Id} AND isDelete = 0",
            "</script>"
    })
    void updateVideo(@Param("video")VideoForDao video);

    @Insert("INSERT INTO db_video (Title, Url, Img, Type, userId) VALUES (#{video.Title}, #{video.Url}, #{video.Img}, #{video.Type}, #{video.userId}) ")
    void postVideo(@Param("video") VideoForDao video);

}
