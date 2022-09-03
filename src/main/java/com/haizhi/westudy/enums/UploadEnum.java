package com.haizhi.westudy.enums;

/**
 * @author xiaoying
 * @create 2022-05-28 下午 4:21
 */
public enum UploadEnum {

    video("video"),
    image("image"),
    profile("profile");


    private String message;

    UploadEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
