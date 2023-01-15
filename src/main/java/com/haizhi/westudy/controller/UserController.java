package com.haizhi.westudy.controller;

import com.haizhi.westudy.pojo.dto.User;
import com.haizhi.westudy.service.UserService;
import com.haizhi.westudy.utils.ResultUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public ResultUtils getUserById(@RequestParam Integer userId){
        return userService.getUSerById(userId);
    }

    @GetMapping("/logout")
    public ResultUtils logout(@RequestParam String userName){
        return userService.logout(userName);
    }

    @GetMapping("/login")
    public ResultUtils login(@RequestParam String userName,@RequestParam String userPwd){
        return userService.login(userName,userPwd);
    }

    @PostMapping("/register")
    public ResultUtils register(@RequestParam User user ,@RequestParam MultipartFile multipartFile){
        return userService.register(user , multipartFile);
    }


}
