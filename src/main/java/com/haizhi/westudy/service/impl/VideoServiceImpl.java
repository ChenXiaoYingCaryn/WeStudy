package com.haizhi.westudy.service.impl;

import com.haizhi.westudy.dao.VideoDao;
import com.haizhi.westudy.enums.UploadEnum;
import com.haizhi.westudy.pojo.VideoReq;
import com.haizhi.westudy.pojo.VideoResp;
import com.haizhi.westudy.pojo.dao.VideoForDao;
import com.haizhi.westudy.service.VideoService;
import com.haizhi.westudy.utils.ResultUtils;
import com.haizhi.westudy.utils.StudyTypeUtils;
import com.haizhi.westudy.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoying
 * @create 2022-06-04 上午 10:25
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoDao videoDao;

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
        List<VideoForDao> list;
        try {
            list = videoDao.queryVideoByUserId(userId);
        }catch (Exception e){
            return ResultUtils.build(100, "query video fail", e.getMessage());
        }
        List<VideoResp> nList = new ArrayList<>();
        for(VideoForDao v : list){
            String t = StudyTypeUtils.respMap.get(v.getType());
            VideoResp nVideo = new VideoResp(v.getId(),v.getTitle(),v.getUrl(),v.getImg(),t,v.getUserId(),v.getIsDelete(),v.getUpdateTime());
            nList.add(nVideo);
        }
        return ResultUtils.build(200, "query video success", nList);
    }

    @Override
    public ResultUtils queryVideoByType(String type) {
        Integer nType = StudyTypeUtils.reqMap.get(type);
        List<VideoForDao> list;
        try {
            list = videoDao.queryVideoByType(nType);
        }catch (Exception e){
            return ResultUtils.build(100, "query video fail", e.getMessage());
        }
        List<VideoResp> nList = new ArrayList<>();
        for(VideoForDao v : list){
            String t = StudyTypeUtils.respMap.get(v.getType());
            VideoResp nVideo = new VideoResp(v.getId(),v.getTitle(),v.getUrl(),v.getImg(),t,v.getUserId(),v.getIsDelete(),v.getUpdateTime());
            nList.add(nVideo);
        }
        return ResultUtils.build(200, "query video success", nList);
    }

    @Override
    public ResultUtils queryVideo() {
        List<VideoForDao> list;
        try {
            list = videoDao.queryVideo();
        }catch (Exception e){
            return ResultUtils.build(100, "query video fail", e.getMessage());
        }
        List<VideoResp> nList = new ArrayList<>();
        for(VideoForDao v : list){
            String type = StudyTypeUtils.respMap.get(v.getType());
            VideoResp nVideo = new VideoResp(v.getId(),v.getTitle(),v.getUrl(),v.getImg(),type,v.getUserId(),v.getIsDelete(),v.getUpdateTime());
            nList.add(nVideo);
        }
        return ResultUtils.build(200, "query video success", nList);
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
        VideoForDao video;
        try{
            video = videoDao.getVideoByVideoId(id);
        }catch (Exception e){
            return ResultUtils.build(100, "get video fail", e.getMessage());
        }

        if(video == null){
            return ResultUtils.build(100, "This video does not exist", null);
        }

        String type = StudyTypeUtils.respMap.get(video.getType());
        VideoResp nVideo = new VideoResp(video.getId(),video.getTitle(),video.getUrl(),video.getImg(),type,video.getUserId(),video.getIsDelete(),video.getUpdateTime());
        return ResultUtils.build(200, "get video success", nVideo);
    }

    @Override
    @Transactional
    public ResultUtils updateVideo(VideoReq video) {
        ResultUtils url = null, img = null;
        Integer type = null;

        if(video.getVideo() != null){
            url = UploadUtils.uploadFile(video.getVideo(), UploadEnum.video);
        }
        if(video.getImg() != null){
            img = UploadUtils.uploadFile(video.getImg(), UploadEnum.image);
        }
        if(video.getType() != null){
            type = StudyTypeUtils.reqMap.get(video.getType());
        }
        VideoForDao nVideo = new VideoForDao(video.getTitle(), (String)url.getData(), (String)img.getData(), type, video.getUserId());

        try{
            videoDao.updateVideo(nVideo);
        }catch (Exception e){
            return ResultUtils.build(100, "update video fail", e.getMessage());
        }
        return  ResultUtils.build(200, "update video success", null);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResultUtils postVideo(VideoReq video) {

        if(video.getVideo() == null || video.getImg() == null){
            return ResultUtils.build(100,"you must upload video and image file", null);
        }


        ResultUtils url = UploadUtils.uploadFile(video.getVideo(), UploadEnum.video);
        ResultUtils img = UploadUtils.uploadFile(video.getImg(), UploadEnum.image);

        Integer type = StudyTypeUtils.reqMap.get(video.getType());

        VideoForDao nVideo = new VideoForDao(video.getTitle(), (String) url.getData(), (String) img.getData(),type, video.getUserId());
        try{
            videoDao.postVideo(nVideo);
        }catch (Exception e){
            return ResultUtils.build(100, "post video fail", e.getMessage());
        }
        return  ResultUtils.build(200, "post video success", null);
    }
}
