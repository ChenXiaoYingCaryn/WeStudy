package com.haizhi.westudy.service;

import com.haizhi.westudy.pojo.dto.User;
import com.haizhi.westudy.utils.ResultUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 5:11
 */
public interface UserService {

    ResultUtils getUSerById(Integer userId);

    ResultUtils logout(String userName);

    ResultUtils login(String userName, String userPwd);

    ResultUtils register(User user , MultipartFile multipartFile);


}
