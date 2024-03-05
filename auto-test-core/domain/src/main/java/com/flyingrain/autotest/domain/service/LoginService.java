package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.domain.service.convert.UserModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestLoginMapper;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestUserMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestLoginModel;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestUserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    private final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private AutoTestLoginMapper autoTestLoginMapper;

    @Autowired
    private AutoTestUserMapper autoTestUserMapper;


    public User queryUserByToken(String token) {
        logger.info("start to query token:[{}]", token);
        AutoTestLoginModel autoTestLoginModel = autoTestLoginMapper.queryByToken(token);
        if (autoTestLoginModel == null) {
            logger.error("no such token,or token had expired!");
            return null;
        }
        int userId = autoTestLoginModel.getUserId();
        AutoTestUserModel autoTestUserModel = autoTestUserMapper.queryByUserId(userId);
        User user = UserModelConvert.convertModel(autoTestUserModel);
        user.setToken(token);
        return user;
    }
}
