package com.flyingrain.autotest.service.convert;

import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.facade.intf.model.AutoTestUser;

public class UserViewConvert {

    public static AutoTestUser convertModel(User autoTestUserModel) {
        if (autoTestUserModel == null) {
            return null;
        }
        AutoTestUser autoTestUser = new AutoTestUser();
        autoTestUser.setId(autoTestUserModel.getId());
        autoTestUser.setUserName(autoTestUserModel.getUserName());
        autoTestUser.setPassword(autoTestUserModel.getPassword());
        autoTestUser.setDepartment(autoTestUserModel.getDepartment());
        autoTestUser.setCreateTime(autoTestUserModel.getCreateTime());
        autoTestUser.setUpdateTime(autoTestUserModel.getUpdateTime());
        return autoTestUser;
    }


    public static User convertUser(AutoTestUser autoTestUserModel) {
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

}
