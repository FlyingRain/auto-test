package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestUserModel;

public class UserModelConvert {


    public static User convertModel(AutoTestUserModel autoTestUserModel) {
        if (autoTestUserModel == null) {
            return null;
        }
        User autoTestUser = new User();
        autoTestUser.setId(autoTestUserModel.getId());
        autoTestUser.setUserName(autoTestUserModel.getUserName());
        autoTestUser.setPassword(autoTestUserModel.getPassword());
        autoTestUser.setDepartment(autoTestUserModel.getDepartment());
        autoTestUser.setCreateTime(autoTestUserModel.getCreateTime());
        autoTestUser.setUpdateTime(autoTestUserModel.getUpdateTime());
        return autoTestUser;
    }


    public static AutoTestUserModel convertUser(User autoTestUserModel) {
        if (autoTestUserModel == null) {
            return null;
        }
        AutoTestUserModel autoTestUser = new AutoTestUserModel();
        autoTestUser.setId(autoTestUserModel.getId());
        autoTestUser.setUserName(autoTestUserModel.getUserName());
        autoTestUser.setPassword(autoTestUserModel.getPassword());
        autoTestUser.setDepartment(autoTestUserModel.getDepartment());
        autoTestUser.setCreateTime(autoTestUserModel.getCreateTime());
        autoTestUser.setUpdateTime(autoTestUserModel.getUpdateTime());
        return autoTestUser;
    }


}
