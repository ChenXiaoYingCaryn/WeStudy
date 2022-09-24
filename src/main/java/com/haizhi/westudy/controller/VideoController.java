package com.haizhi.westudy.controller;

import com.haizhi.westudy.pojo.VideoReq;
import com.haizhi.westudy.service.VideoService;
import com.haizhi.westudy.utils.JWTUtils;
import com.haizhi.westudy.utils.ResultUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiaoying
 * @create 2022-06-04 上午 10:57
 */
@Api
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("/queryVideoByUserId")
    ResultUtils queryVideoByUserId(@RequestParam Integer userId){
        return videoService.queryVideoByUserId(userId);
    }

    @GetMapping("/queryVideoByType")
    ResultUtils queryVideoByType(@RequestParam String type){
        return videoService.queryVideoByType(type);
    }

    @GetMapping("/queryVideo")
    ResultUtils queryVideo(){
        return videoService.queryVideo();
    }

    @PostMapping("/deleteVideo")
    ResultUtils deleteVideo(@RequestHeader String token,@RequestParam Integer id){
        try{
            JWTUtils.verify(token);
        }catch (Exception e){
            return ResultUtils.build(100, "verify token fail", e.getMessage());
        }
        return videoService.deleteVideo(id);
    }

    @GetMapping("/getVideoByVideoId")
    ResultUtils getVideoByVideoId(@RequestParam Integer id){
        return videoService.getVideoByVideoId(id);
    }

    @PostMapping("/updateVideo")
    ResultUtils updateVideo(@RequestHeader String token, @RequestParam VideoReq video){
        try{
            JWTUtils.verify(token);
        }catch (Exception e){
            return ResultUtils.build(100, "verify token fail", e.getMessage());
        }
        return videoService.updateVideo(video);
    }


    @PostMapping("/postVideo")
    ResultUtils postVideo(@RequestHeader String token, @RequestParam VideoReq video){
        try{
            JWTUtils.verify(token);
        }catch (Exception e){
            return ResultUtils.build(100, "verify token fail", e.getMessage());
        }
        return videoService.postVideo(video);
    }

}
