package com.haizhi.westudy.service;

import com.haizhi.westudy.pojo.WebLog;
import com.haizhi.westudy.utils.ResultUtils;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LogService {

    public void insert(WebLog webLog);

    ResultUtils findAll();

}
