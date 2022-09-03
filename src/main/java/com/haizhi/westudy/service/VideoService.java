package com.haizhi.westudy.service;

import com.haizhi.westudy.pojo.VideoReq;
import com.haizhi.westudy.utils.ResultUtils;

/**
 * @author xiaoying
 * @create 2022-06-04 上午 10:25
 */
public interface VideoService {

    ResultUtils countUserVideo(Integer userId);

    ResultUtils queryVideoByUserId(Integer userId);

    ResultUtils queryVideoByType(String type);

    ResultUtils queryVideo();

    ResultUtils deleteVideo(Integer id);

    ResultUtils getVideoByVideoId(Integer id);

    ResultUtils updateVideo(VideoReq video);

    ResultUtils postVideo(VideoReq video);

}
