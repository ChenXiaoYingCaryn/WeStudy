package com.haizhi.westudy.service.impl;

import com.haizhi.westudy.dao.FollowDao;
import com.haizhi.westudy.pojo.vo.UserVo;
import com.haizhi.westudy.pojo.dao.UserForDao;
import com.haizhi.westudy.service.FollowService;
import com.haizhi.westudy.utils.ResultUtils;
import com.haizhi.westudy.utils.StudyTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoying
 * @create 2022-06-04 下午 5:35
 */
@Service
public class FollowerServiceImpl implements FollowService {

    @Autowired
    FollowDao followDao;

    @Override
    public ResultUtils listFans(Integer userId) {
        List<UserForDao> list;
        try{
            list = followDao.listFans(userId);
        }catch (Exception e){
            return ResultUtils.build(100, "fail to list fans", e.getMessage());
        }
        List<UserVo> nList = new ArrayList<>();
        for(UserForDao u : list){
            String type = StudyTypeUtils.respMap.get(u.getUserStudyType());
            UserVo user = new UserVo(u.getUserId(), u.getUserName(), u.getUserProfile(), type);
            nList.add(user);
        }
        return ResultUtils.build(200, "success to list fans", nList);
    }

    @Override
    public ResultUtils listFollow(Integer userId) {
        List<UserForDao> list;
        try{
            list = followDao.listFollow(userId);
        }catch (Exception e){
            return ResultUtils.build(100, "fail to list follow", e.getMessage());
        }
        List<UserVo> nList = new ArrayList<>();
        for(UserForDao u : list){
            String type = StudyTypeUtils.respMap.get(u.getUserStudyType());
            UserVo user = new UserVo(u.getUserId(), u.getUserName(), u.getUserProfile(), type);
            nList.add(user);
        }
        return ResultUtils.build(200, "success to list follow", nList);

    }

    @Override
    public ResultUtils judgeWhetherFollow(Integer userId, Integer followerId) {
        int count; boolean flag = false;
        try {
            count = followDao.judgeWhetherFollow(userId, followerId);
        }catch (Exception e){
            return ResultUtils.build(100, "fail to judge whether follow", e.getMessage());
        }
        if(count == 1) flag = true;
        return ResultUtils.build(200, "success to judge whether follow", flag);
    }

    @Override
    public ResultUtils countFans(Integer userId) {
        int count;
        try {
            count = followDao.countFans(userId);
        }catch (Exception e){
            return ResultUtils.build(100, "fail to count follower", e.getMessage());
        }
        return ResultUtils.build(200, "success to count follower", count);
    }

    @Override
    public ResultUtils countFollow(Integer userId) {
        int count;
        try {
            count = followDao.countFollow(userId);
        }catch (Exception e){
            return ResultUtils.build(100, "fail to count follow", e.getMessage());
        }
        return ResultUtils.build(200, "success to count follow", count);
    }

    @Override
    public ResultUtils unFollow(Integer userId, Integer followerId) {
        try {
            followDao.unFollow(userId, followerId);
        }catch (Exception e){
            return ResultUtils.build(100, "fail to unfollow", e.getMessage());
        }
        return ResultUtils.build(200, "success to unfollow", null);
    }

    @Override
    public ResultUtils follow(Integer userId, Integer followerId) {
        int count = followDao.judgeWhetherFollowed(userId, followerId);
        if(count == 0){
            try {
                followDao.follow(userId, followerId);
            }catch (Exception e){
                return ResultUtils.build(100,"fail to follow", e.getMessage());
            }
        }else{
            try{
                followDao.followAgain(userId, followerId);
            }catch (Exception e){
                return ResultUtils.build(100,"fail to follow", e.getMessage());
            }
        }
        return ResultUtils.build(200, "success to follow", null);
    }
}
