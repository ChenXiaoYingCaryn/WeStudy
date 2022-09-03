package com.haizhi.westudy.dao;

import com.haizhi.westudy.pojo.dao.UserForDao;
import org.apache.ibatis.annotations.*;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 5:04
 */
@Mapper
public interface UserDao {


    @Select("SELECT userId, userName, userProfile, userStudyType FROM db_user WHERE userId = #{userId}")
    UserForDao getUserById(Integer userId);

    @Select("SELECT userId, userName, userProfile, userStudyType FROM db_user WHERE userName = #{userName} AND userPwd = #{userPwd}")
    UserForDao login (String userName, String userPwd);

    @Select("SELECT COUNT * FROM db_user WHERE userName = #{userName} ")
    int judgeSameName (String userName);

    @Insert("INSERT INTO db_user (userName, userPwd, userProfile, userStudyType) VALUES (#{user.userName}, #{user.userPwd}, #{user.userProfile}, #{user.userStudyType})")
    void register(@Param("user") UserForDao user);




}
