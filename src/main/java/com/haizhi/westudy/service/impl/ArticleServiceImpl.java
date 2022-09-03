package com.haizhi.westudy.service.impl;

import com.haizhi.westudy.dao.ArticleDao;
import com.haizhi.westudy.pojo.Article;
import com.haizhi.westudy.pojo.dao.ArticleForDao;
import com.haizhi.westudy.service.ArticleService;
import com.haizhi.westudy.utils.ResultUtils;
import com.haizhi.westudy.utils.StudyTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 10:19
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public ResultUtils countUserArticle(Integer userId) {
        int res;
        try{
            res = articleDao.countUserArticle(userId);
        }catch (Exception e){
            return ResultUtils.build(100, "count user article fail", e.getMessage());
        }
        return ResultUtils.build(200,"count user article success", res);
    }

    @Override
    public ResultUtils queryArticleByUserId(Integer userId) {
        List<ArticleForDao> list;
        try {
            list = articleDao.queryArticleByUserId(userId);
        }catch (Exception e){
            return ResultUtils.build(100, "query article fail", e.getMessage());
        }

        List<Article> nList = new ArrayList<>();
        for (ArticleForDao item : list){
            String aType = StudyTypeUtils.respMap.get(item.getType());
            Article nArticle = new Article(item.getId(), item.getTitle(), item.getText(), aType, item.getUserId(), item.getIsDelete(), item.getUpdateTime());
            nList.add(nArticle);
        }
        return ResultUtils.build(200,"query article success", nList);
    }

    @Override
    public ResultUtils queryArticleByType(String type) {
        Integer nType = StudyTypeUtils.reqMap.get(type);
        List<ArticleForDao> list;
        try {
            list = articleDao.queryArticleByType(nType);
        }catch (Exception e){
            return ResultUtils.build(100, "query article fail", e.getMessage());
        }

        List<Article> nList = new ArrayList<>();
        for (ArticleForDao item : list){
            String aType = StudyTypeUtils.respMap.get(item.getType());
            Article nArticle = new Article(item.getId(), item.getTitle(), item.getText(), aType, item.getUserId(), item.getIsDelete(), item.getUpdateTime());
            nList.add(nArticle);
        }
        return ResultUtils.build(200,"query article success", nList);
    }

    @Override
    public ResultUtils getArticleByArticleId(Integer Id) {
        ArticleForDao article;
        try{
            article = articleDao.getArticleByArticleId(Id);
        }catch (Exception e){
            return ResultUtils.build(100, "get article fail", e.getMessage());
        }
        String type = StudyTypeUtils.respMap.get(article.getType());
        Article nArticle = new Article(article.getId(), article.getTitle(), article.getText(), type, article.getUserId(), article.getIsDelete(), article.getUpdateTime());
        return ResultUtils.build(200, "get article success", nArticle);
    }

    @Override
    public ResultUtils deleteArticle(Integer id) {
        try{
            articleDao.deleteArticle(id);
        }catch (Exception e){
            return ResultUtils.build(100, "delete article fail", e.getMessage());
        }
        return ResultUtils.build(200, "delete article success", null);
    }

    @Override
    public ResultUtils updateArticle(Article article) {
        String reqType = article.getType();
        Integer respType = null;
        if(reqType != null){
            respType = StudyTypeUtils.reqMap.get(reqType);
        }
        ArticleForDao nArticle = new ArticleForDao(article.getId(),article.getTitle(),article.getText(),respType,article.getUserId());

        try{
            articleDao.updateArticle(nArticle);
        }catch (Exception e){
            return ResultUtils.build(100, "update article fail", e.getMessage());
        }
        return ResultUtils.build(200,"update article success", null);

    }

    @Override
    public ResultUtils queryArticle() {
        List<ArticleForDao> list = articleDao.queryArticle();
        List<Article> nList = new ArrayList<>();

        for(ArticleForDao a : list){
            String type = StudyTypeUtils.respMap.get(a.getType());
            Article article = new Article(a.getId(), a.getTitle(), a.getText(), type, a.getUserId(), a.getIsDelete(), a.getUpdateTime());
            nList.add(article);
        }

        return ResultUtils.build(200, "query article success", nList);
    }

    @Override
    public ResultUtils postArticle(Article article) {
        int type = StudyTypeUtils.reqMap.get(article.getType());
        ArticleForDao nArticle = new ArticleForDao(article.getTitle(),article.getText(), type, article.getUserId());

        try {
            articleDao.postArticle(nArticle);
        }catch (Exception e){
            return ResultUtils.build(100, "post article fail", e.getMessage());
        }
        return ResultUtils.build(200,"post article success", null);
    }
}
