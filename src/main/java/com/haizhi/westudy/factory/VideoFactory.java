package com.haizhi.westudy.factory;

import com.haizhi.westudy.pojo.VideoReq;
import com.haizhi.westudy.pojo.VideoResp;
import com.haizhi.westudy.utils.ResultUtils;

/**
 * @author xiaoying
 * @create 2023/1/6
 */
public class VideoFactory {

    public static VideoResp VideoRepToVideoResp(VideoReq req, ResultUtils video, ResultUtils img){
        VideoResp resp = new VideoResp();
        resp.setId(req.getId());
        resp.setTitle(req.getTitle());
        if(video.getData() != null){
            resp.setVideo((String) video.getData());
        }
        if(img.getData() != null){
            resp.setImg((String) img.getData());
        }
        resp.setType(req.getType());
        resp.setUserId(req.getUserId());
        resp.setCourseId(req.getCourseId());
        resp.setSectionId(req.getSectionId());
        return resp;
    }

}

