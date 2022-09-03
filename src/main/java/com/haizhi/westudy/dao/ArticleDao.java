package com.haizhi.westudy.dao;

import com.haizhi.westudy.pojo.dao.ArticleForDao;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 10:13
 */
@Mapper
public interface ArticleDao {

    @Select("select count(*) from db_article where userId = #{userId} and isDelete = 0")
    int countUserArticle(Integer userId);

    @Select("SELECT * FROM db_article WHERE Type = #{type} AND isDelete = 0")
    List<ArticleForDao> queryArticleByUserId(Integer userId);

    @Select("SELECT * FROM db_article WHERE Type = #{type} AND isDelete = 0")
    List<ArticleForDao> queryArticleByType(Integer type);

    @Select("SELECT * FROM db_article WHERE Id = #{Id} AND isDelete = 0")
    ArticleForDao getArticleByArticleId(Integer Id);

    @Update("UPDATE db_article SET isDelete = 1 WHERE Id = #{Id}")
    void deleteArticle(Integer Id);

    @Update({
            "<script> ",
            "update db_article set ",
            "<if test = \"article.Title != null\"> ",
            "Title = #{article.Title}, ",
            "</if> ",
            "<if test = \"article.Text != null\"> ",
            "Text = #{article.Text}, ",
            "</if> ",
            "<if test = \"article.Type != null\"> ",
            "Type = #{article.Type}, ",
            "</if> ",
            "update_time=CURRENT_TIMESTAMP ",
            "WHERE Id = #{article.Id} AND isDelete = 0",
            "</script>"
    })
    void updateArticle(@Param("article") ArticleForDao article);

    @Select("SELECT * FROM db_article WHERE isDelete = 0")
    List<ArticleForDao> queryArticle();

    @Insert("INSERT INTO db_article (Title, Text, Type, userId) VALUES (#{article.Title}, #{article.Text}, #{article.Type}, #{article.userId}) ")
    void postArticle(@Param("article") ArticleForDao article);

}
