package com.haizhi.westudy.dao;

import com.haizhi.westudy.pojo.dao.UserForDao;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xiaoying
 * @create 2022-06-04 下午 4:57
 */
@Mapper
public interface FollowDao {

    @Select("SELECT userId,userName,userProfile,userStudyType FROM db_user WHERE " +
            "userId = ANY(SELECT userId FROM db_follow WHERE followerId = #{userId} AND isDelete = 0);")
    List<UserForDao> listFans(Integer userId);

    @Select("SELECT userId,userName,userProfile,userStudyType FROM db_user WHERE " +
            "userId = ANY(SELECT followerId FROM db_follow WHERE userId = #{userId} AND isDelete = 0);")
    List<UserForDao> listFollow(Integer userId);

    @Select("select count(*) from db_follow where followerId = #{userId} and isDelete = 0")
    int countFans(Integer userId);

    @Select("select count(*) from db_follow where userId = #{userId} and isDelete = 0")
    int countFollow(Integer userId);

    @Update("UPDATE db_follow SET isDelete = 1 where userId = #{userId} and followerId = #{followerId}")
    void unFollow(@Param("userId") Integer userId, @Param("followerId") Integer followerId);

    @Update("UPDATE db_follow SET isDelete = 0 where userId = #{userId} and followerId = #{followerId}")
    void followAgain(@Param("userId") Integer userId, @Param("followerId") Integer followerId);

    @Select("select count(*) from db_follow where userId = #{userId} and followerId = #{followerId} and isDelete = 0")
    int judgeWhetherFollow(@Param("userId") Integer userId, @Param("followerId") Integer followerId);

    @Select("select count(*) from db_follow where userId = #{userId} and followerId = #{followerId}")
    int judgeWhetherFollowed(@Param("userId") Integer userId, @Param("followerId") Integer followerId);

    @Insert("insert into db_follow (userId,followerId) values (#{userId}, #{followerId})")
    void follow(@Param("userId") Integer userId, @Param("followerId") Integer followerId);

}
