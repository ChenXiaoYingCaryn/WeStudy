package com.haizhi.westudy.controller;

import com.haizhi.westudy.pojo.User;
import com.haizhi.westudy.service.UserService;
import com.haizhi.westudy.utils.ResultUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 5:19
 */
@Api
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUserById")
    public ResultUtils getUserById(Integer userId){
        return userService.getUSerById(userId);
    }

    @GetMapping("/logout")
    public ResultUtils logout(String userName){
        return userService.logout(userName);
    }

    @GetMapping("/login")
    public ResultUtils login(String userName, String userPwd){
        return userService.login(userName,userPwd);
    }

    @PostMapping("/register")
    public ResultUtils register(User user , MultipartFile multipartFile){
        return userService.register(user , multipartFile);
    }


}
