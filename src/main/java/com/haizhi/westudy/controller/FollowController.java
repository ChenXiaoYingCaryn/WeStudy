package com.haizhi.westudy.controller;

import com.haizhi.westudy.service.FollowService;
import com.haizhi.westudy.utils.JWTUtils;
import com.haizhi.westudy.utils.ResultUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiaoying
 * @create 2022-06-04 下午 5:36
 */
@Api
@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    FollowService followService;

    @GetMapping("/listFans")
    ResultUtils listFans(@RequestParam Integer userId){
        return followService.listFans(userId);
    }

    @GetMapping("/listFollow")
    ResultUtils listFollow(@RequestParam Integer userId){
        return followService.listFollow(userId);
    }

    @GetMapping("/judgeWhetherFollow")
    ResultUtils judgeWhetherFollow(@RequestParam Integer userId, @RequestParam Integer followerId){
        return followService.judgeWhetherFollow(userId, followerId);
    }

    @GetMapping("/countFans")
    ResultUtils countFans(@RequestParam Integer userId){
        return followService.countFans(userId);
    }

    @GetMapping("/countFollow")
    ResultUtils countFollow(@RequestParam Integer userId){
        return followService.countFollow(userId);
    }

    @PostMapping("/unFollow")
    ResultUtils unFollow(@RequestHeader String token,@RequestParam Integer userId,@RequestParam Integer followId){
        try{
            JWTUtils.verify(token);
        }catch (Exception e){
            return ResultUtils.build(100, "verify token fail", e.getMessage());
        }
        return followService.unFollow(userId, followId);
    }

    @PostMapping("/follow")
    ResultUtils follow(@RequestHeader String token, Integer userId, Integer followId){
        try{
            JWTUtils.verify(token);
        }catch (Exception e){
            return ResultUtils.build(100, "verify token fail", e.getMessage());
        }
        return followService.follow(userId, followId);
    }

}
