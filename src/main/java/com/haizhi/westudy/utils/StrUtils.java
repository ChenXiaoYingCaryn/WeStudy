package com.haizhi.westudy.utils;

public class StrUtils {


    /**
     * get base url
     * http://localhost:8080/login -> http://localhost:8080
     * @param url
     * @return
     */
    public static String GetBaseURL(String url){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < url.length(); i++) {
            if(count >= 3){
                break;
            }
            if(url.charAt(i) == '/'){
                count++;
            }
            sb.append(url.charAt(i));
        }
        return sb.toString();
    }

}
