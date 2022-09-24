package com.haizhi.westudy.service.impl;


import com.haizhi.westudy.dao.LogDao;
import com.haizhi.westudy.pojo.WebLog;
import com.haizhi.westudy.service.LogService;
import com.haizhi.westudy.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public void insert(WebLog webLog) {
        logDao.insert(webLog);
    }

    @Override
    public ResultUtils findAll() {
        List<WebLog> list = logDao.findAll();
        return ResultUtils.build(200,"处理成功", list);
    }
}
