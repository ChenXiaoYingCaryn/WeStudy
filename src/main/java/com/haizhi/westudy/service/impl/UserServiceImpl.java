package com.haizhi.westudy.service.impl;

import com.haizhi.westudy.dao.UserDao;
import com.haizhi.westudy.pojo.dto.User;
import com.haizhi.westudy.pojo.vo.UserVo;
import com.haizhi.westudy.pojo.dao.UserForDao;
import com.haizhi.westudy.service.UserService;
import com.haizhi.westudy.utils.JWTUtils;
import com.haizhi.westudy.utils.ResultUtils;
import com.haizhi.westudy.utils.StudyTypeUtils;
import com.haizhi.westudy.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

import static com.haizhi.westudy.enums.UploadEnum.profile;

/**
 * @author xiaoying
 * @create 2022-05-29 下午 5:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public ResultUtils getUSerById(Integer userId) {
        UserForDao user = userDao.getUserById(userId);
        String type = StudyTypeUtils.respMap.get(user.getUserStudyType());
        UserVo nUser = new UserVo(user.getUserId(), user.getUserName(), user.getUserProfile(), type);
        return ResultUtils.build(200, "get user success", nUser);
    }

    @Override
    public ResultUtils logout(String userName) {
        HashMap<String,String> map = new HashMap<>();
        map.put("userName",userName);
        String token = JWTUtils.logout(map);
        return ResultUtils.build(200,"logout success", token);
    }

    @Override
    public ResultUtils login(String userName, String userPwd) {
        UserForDao user = userDao.login(userName, userPwd);
        if(user == null){
            return ResultUtils.build(100, "login fail", "用户名或密码错误");
        }

        String type = StudyTypeUtils.respMap.get(user.getUserStudyType());
        User nUser = new User(user.getUserId(), user.getUserName(), "", user.getUserProfile(), type);

        HashMap<String,String> map = new HashMap<>();
        map.put("userName",userName);
        String token = JWTUtils.getToken(map);
        return ResultUtils.build(200,"login success", nUser, token);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultUtils register(User user, MultipartFile multipartFile) {

        if(userDao.judgeSameName(user.getUserName()) != 0){
            return ResultUtils.build(100,"register fail", "用户名重复");
        }

        ResultUtils profilePath = UploadUtils.uploadFile(multipartFile , profile);
        if(profilePath.getStatus() == 100){
            return ResultUtils.build(100, "register fail", profilePath.getData());
        }

        Integer type = StudyTypeUtils.reqMap.get(user.getUserStudyType());
        UserForDao u = new UserForDao(user.getUserName(), user.getUserPwd(), (String) profilePath.getData(), type);
        try{
            userDao.register (u);
        }catch (Exception e){
            return ResultUtils.build(100, "register fail", e.getMessage());
        }

        return ResultUtils.build(200, "register success", null);
    }
}
