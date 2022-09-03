package com.haizhi.westudy.utils;


import com.haizhi.westudy.enums.UploadEnum;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaoying
 * @create 2022-05-12 下午 8:35
 */
public class UploadUtils {


    private static String FILE_NAME = "westudy";
    private static String IMAGE_PATH = "/westudy/image";
    private static String VIDEO_PATH = "/westudy/video";
    private static String PROFILE_PATH = "/westudy/profile";

    /**
     * 上传图片方法类
     *
     * @param multipartFile
     * @return
     */
    public static ResultUtils uploadFile(MultipartFile multipartFile, Enum ops) {

        // 获取当时日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(new Date());

        String newName = "";
        String uploadFilePath = "";
        String filePath = "";

        if(ops == UploadEnum.video){
            newName = FILE_NAME + format + ".mp4";
            uploadFilePath = VIDEO_PATH;
        }
        if(ops == UploadEnum.image){
            newName = FILE_NAME + format + ".jpg";
            uploadFilePath = IMAGE_PATH;
        }
        if(ops == UploadEnum.profile){
            newName = FILE_NAME + "_profile_" + format + ".jpg";
            uploadFilePath = PROFILE_PATH;
        }

        try {
            File file = new File(uploadFilePath, newName);
            multipartFile.transferTo(file);
            filePath = "http://159.75.110.59:9000/westudy/" + ops + "/" + newName;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.fail("file upload fail");
        }
        return ResultUtils.success("file upload success", filePath);
    }

}
