package com.haizhi.westudy.dao;

import com.haizhi.westudy.pojo.vo.WebLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(WebLog webLog){
        mongoTemplate.insert(webLog);
    }

    public List<WebLog> findAll(){
        return mongoTemplate.findAll(WebLog.class);
    }
}
