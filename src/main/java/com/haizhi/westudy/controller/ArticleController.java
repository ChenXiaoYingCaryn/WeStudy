package com.haizhi.westudy.controller;

import com.haizhi.westudy.pojo.Article;
import com.haizhi.westudy.service.ArticleService;
import com.haizhi.westudy.utils.JWTUtils;
import com.haizhi.westudy.utils.ResultUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 10:30
 */
@Api
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/countUserArticle")
    ResultUtils countUserArticle(Integer userId){
        return articleService.countUserArticle(userId);
    }


    @GetMapping("/queryArticleByUserId")
    ResultUtils queryArticleByUserId(Integer userId){
        return articleService.queryArticleByUserId(userId);
    }

    @GetMapping("/queryArticleByType")
    ResultUtils queryArticleByType(String type){
        return articleService.queryArticleByType(type);
    }

    @GetMapping("/getArticleByArticleId")
    ResultUtils getArticleByArticleId(Integer Id){
        return articleService.getArticleByArticleId(Id);
    }

    @PostMapping("/deleteArticle")
    ResultUtils deleteArticle(@RequestHeader String token, Integer id){
        try{
            JWTUtils.verify(token);
        }catch (Exception e){
            return ResultUtils.build(100, "verify token fail", e.getMessage());
        }
        return articleService.deleteArticle(id);
    }

    @PostMapping("/updateArticle")
    ResultUtils updateArticle(@RequestHeader String token, Article article){
        try{
            JWTUtils.verify(token);
        }catch (Exception e){
            return ResultUtils.build(100, "verify token fail", e.getMessage());
        }
        return articleService.updateArticle(article);
    }

    @GetMapping("/queryArticle")
    ResultUtils queryArticle(){
        return articleService.queryArticle();
    }

    @PostMapping("/postArticle")
    ResultUtils postArticle(@RequestHeader String token, Article article){
        try{
            JWTUtils.verify(token);
        }catch (Exception e){
            return ResultUtils.build(100, "verify token fail", e.getMessage());
        }
        return articleService.postArticle(article);
    }

}
