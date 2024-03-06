package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.domain.service.convert.UserModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestLoginMapper;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestUserMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestLoginModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Component
public class UserManager {

    private final Logger logger = LoggerFactory.getLogger(UserManager.class);

    @Autowired
    private AutoTestUserMapper autoTestUserMapper;

    @Autowired
    private AutoTestLoginMapper loginMapper;


    @Transactional
    public User login(String userName, String password) {
        logger.info("receive user login:[{}]", userName);
        User autoTestUser = UserModelConvert.convertModel(autoTestUserMapper.queryByUserNamePassword(userName, password));
        if (autoTestUser == null) {
            throw new AutoTestException(AutoTestResultCodeEnum.USER_NOT_EXIST);
        }
        loginMapper.expireToken(autoTestUser.getId());
        String token = UUID.randomUUID().toString();
        logger.info("generate new token:[{}]", token);
        AutoTestLoginModel autoTestLoginModel = new AutoTestLoginModel();
        autoTestLoginModel.setUserId(autoTestUser.getId());
        autoTestLoginModel.setToken(token);
        autoTestLoginModel.setStatus(1);
        loginMapper.insertLogin(autoTestLoginModel);
        autoTestUser.setToken(token);
        return autoTestUser;
    }

    public boolean register(User user) {
        if (user == null || !StringUtils.hasText(user.getUserName())) {
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR);
        }
        int count = autoTestUserMapper.insertUser(UserModelConvert.convertUser(user));
        return count > 0;
    }

    public boolean modifyPassword(String userName, String password) {
        int result = autoTestUserMapper.modifyPassword(userName, password);
        return result > 0;
    }


}
