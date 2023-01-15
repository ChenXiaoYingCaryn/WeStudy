package com.haizhi.westudy.service;

import com.haizhi.westudy.pojo.vo.WebLog;
import com.haizhi.westudy.utils.ResultUtils;

public interface LogService {

    public void insert(WebLog webLog);

    ResultUtils findAll();

}
