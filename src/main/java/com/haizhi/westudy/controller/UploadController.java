package com.haizhi.westudy.controller;

import com.haizhi.westudy.enums.UploadEnum;
import com.haizhi.westudy.utils.ResultUtils;
import com.haizhi.westudy.utils.UploadUtils;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 3:52
 */

@Api
@RestController
public class UploadController {


    @PostMapping("/uploadVideo")
    @ResponseBody
    ResultUtils uploadVideo(MultipartFile multipartFile){
        return UploadUtils.uploadFile(multipartFile, UploadEnum.video);
    }

    @PostMapping("/uploadImage")
    @ResponseBody
    ResultUtils uploadImage(MultipartFile multipartFile){
        return UploadUtils.uploadFile(multipartFile, UploadEnum.image);
    }



}
