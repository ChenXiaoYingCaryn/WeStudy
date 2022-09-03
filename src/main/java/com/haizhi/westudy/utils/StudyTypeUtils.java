package com.haizhi.westudy.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 4:45
 */
public class StudyTypeUtils {

    //'前端','后端','人工智能','嵌入式','大数据','产品'
    public static final Map<String, Integer> reqMap = new HashMap<String, Integer>() {
        {
            put("前端", 0);
            put("后端", 1);
            put("人工智能", 2);
            put("嵌入式", 3);
            put("大数据", 4);
            put("产品", 5);
        }
    };

    public static final Map<Integer, String> respMap = new HashMap<Integer, String>() {
        {
            put(0, "前端");
            put(1, "后端");
            put(2, "人工智能");
            put(3, "嵌入式");
            put(4, "大数据");
            put(5, "产品");
        }
    };

}
