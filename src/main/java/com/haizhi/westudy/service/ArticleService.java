package com.haizhi.westudy.service;

import com.haizhi.westudy.pojo.Article;
import com.haizhi.westudy.utils.ResultUtils;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 10:18
 */
public interface ArticleService {

    ResultUtils countUserArticle(Integer userId);

    ResultUtils queryArticleByUserId(Integer userId);

    ResultUtils queryArticleByType(String type);

    ResultUtils getArticleByArticleId(Integer Id);

    ResultUtils deleteArticle(Integer Id);

    ResultUtils updateArticle(Article article);

    ResultUtils queryArticle();

    ResultUtils postArticle(Article article);

}
