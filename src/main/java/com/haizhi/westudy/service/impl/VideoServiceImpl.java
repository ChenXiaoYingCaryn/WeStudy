package com.haizhi.westudy.service.impl;

import com.haizhi.westudy.dao.VideoDao;
import com.haizhi.westudy.enums.UploadEnum;
import com.haizhi.westudy.factory.VideoFactory;
import com.haizhi.westudy.pojo.VideoReq;
import com.haizhi.westudy.pojo.VideoResp;
import com.haizhi.westudy.service.VideoService;
import com.haizhi.westudy.utils.ResultUtils;
import com.haizhi.westudy.utils.StudyTypeUtils;
import com.haizhi.westudy.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xiaoying
 * @create 2022-06-04 上午 10:25
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoDao videoDao;

    VideoFactory videoFactory;

    @Override
    public ResultUtils countUserVideo(Integer userId) {
        int res;
        try{
            res = videoDao.countUserVideo(userId);
        }catch (Exception e){
            return ResultUtils.build(100, "count user video fail", e.getMessage());
        }
        return ResultUtils.build(200,"count user video success", res);
    }

    @Override
    public ResultUtils queryVideoByUserId(Integer userId) {
        List<VideoResp> list;
        try {
            list = videoDao.queryVideoByUserId(userId);
        }catch (Exception e){
            return ResultUtils.build(100, "query video fail", e.getMessage());
        }
        return ResultUtils.build(200, "query video success", list);
    }

    @Override
    public ResultUtils queryVideoByType(Integer type) {
        List<VideoResp> list;
        try {
            list = videoDao.queryVideoByType(type);
        }catch (Exception e){
            return ResultUtils.build(100, "query video fail", e.getMessage());
        }
        return ResultUtils.build(200, "query video success", list);
    }

    @Override
    public ResultUtils queryVideo() {
        List<VideoResp> list;
        try {
            list = videoDao.queryVideo();
        }catch (Exception e){
            return ResultUtils.build(100, "query video fail", e.getMessage());
        }
        return ResultUtils.build(200, "query video success", list);
    }

    @Override
    public ResultUtils deleteVideo(Integer id) {
        try{
            videoDao.deleteVideo(id);
        }catch (Exception e){
            return ResultUtils.build(100,"delete video fail", e.getMessage());
        }
        return ResultUtils.build(200, "delete video success", null);
    }

    @Override
    public ResultUtils getVideoByVideoId(Integer id) {
        VideoResp video;
        try{
            video = videoDao.getVideoByVideoId(id);
        }catch (Exception e){
            return ResultUtils.build(100, "get video fail", e.getMessage());
        }

        if(video == null){
            return ResultUtils.build(100, "This video does not exist", null);
        }

        return ResultUtils.build(200, "get video success", video);
    }

    @Override
    @Transactional
    public ResultUtils updateVideo(VideoReq req){
        ResultUtils video = new ResultUtils();
        ResultUtils img = new ResultUtils();

        if(req.getVideo() != null){
            video = UploadUtils.uploadFile(req.getVideo(), UploadEnum.video);
            if(video.getStatus().equals("100")) {
                return video;
            }
        }
        if(req.getImg() != null){
            img = UploadUtils.uploadFile(req.getImg(), UploadEnum.image);
            if(img.getStatus().equals("100")) {
                return img;
            }
        }


        VideoResp nVideo = VideoFactory.VideoRepToVideoResp(req, video, img);
        try{
            videoDao.updateVideo(nVideo);
        }catch (Exception e){
            return ResultUtils.build(100, "update video fail", e.getMessage());
        }
        return  ResultUtils.build(200, "update video success", null);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResultUtils postVideo(VideoReq req) {

        if(req.getVideo() == null || req.getImg() == null){
            return ResultUtils.build(100,"you must upload video and image file", null);
        }

        ResultUtils videoUrl = UploadUtils.uploadFile(req.getVideo(), UploadEnum.video);
        ResultUtils imgUrl = UploadUtils.uploadFile(req.getImg(), UploadEnum.image);

        VideoResp nVideo = videoFactory.VideoRepToVideoResp(req, videoUrl, imgUrl);
        try{
            videoDao.postVideo(nVideo);
        }catch (Exception e){
            return ResultUtils.build(100, "post video fail", e.getMessage());
        }
        return  ResultUtils.build(200, "post video success", null);
    }
}
