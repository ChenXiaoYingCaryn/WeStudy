package com.haizhi.westudy.utils;

/**
 * @author xiaoying
 * @create 2021-11-30 上午 9:44
 */
public class ResultUtils {

    //返回响应状态
    private Integer status;  //200：成功 100：失败

    //返回响应信息
    private String msg;

    //返回响应数据
    private Object data;

    //返回token
    private String token;

    public static ResultUtils build(Integer status, String msg, Object data, String token){
        return new ResultUtils(status , msg , data, token);
    }

    public static ResultUtils build(Integer status, String msg, Object data){
        return new ResultUtils(status , msg , data);
    }

    public static ResultUtils build(Integer status, String msg){
        return new ResultUtils(status , msg , null);
    }

    public static ResultUtils success(String msg , Object data){
        return new ResultUtils(200 , "处理成功!" , data);
    }

    public static ResultUtils fail(String msg){
        return new ResultUtils(100 , msg , null);
    }

    public ResultUtils() {
    }

    public ResultUtils(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultUtils(Integer status, String msg, Object data, String token) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.token = token;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ChatResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
