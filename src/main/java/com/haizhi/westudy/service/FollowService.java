package com.haizhi.westudy.service;

import com.haizhi.westudy.utils.ResultUtils;

/**
 * @author xiaoying
 * @create 2022-06-04 下午 5:35
 */
public interface FollowService {

    ResultUtils listFans(Integer userId);

    ResultUtils listFollow(Integer userId);

    ResultUtils judgeWhetherFollow(Integer userId, Integer followerId);

    ResultUtils countFans(Integer userId);

    ResultUtils countFollow(Integer userId);

    ResultUtils unFollow(Integer userId, Integer followerId);

    ResultUtils follow(Integer userId, Integer followerId);

}
