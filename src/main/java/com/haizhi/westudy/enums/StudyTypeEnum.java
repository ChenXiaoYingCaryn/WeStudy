package com.haizhi.westudy.enums;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 4:19
 */
public enum StudyTypeEnum {

    BackEnd(0),
    FrontEnd(1);



    private Integer type;

    StudyTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
