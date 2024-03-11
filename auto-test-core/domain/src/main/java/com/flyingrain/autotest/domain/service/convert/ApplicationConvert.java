package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.Application;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestApplicationModel;

public class ApplicationConvert {

    public static AutoTestApplicationModel convertModel(Application application){
        if(application==null){
            return null;
        }
        AutoTestApplicationModel autoTestApplicationModel= new AutoTestApplicationModel();
        autoTestApplicationModel.setId(application.getId());
        autoTestApplicationModel.setAppCode(application.getAppCode());
        autoTestApplicationModel.setAppName(application.getAppName());
        autoTestApplicationModel.setOwner(application.getOwner());
        autoTestApplicationModel.setDesc(application.getDesc());
        autoTestApplicationModel.setCreateTime(application.getCreateTime());
        autoTestApplicationModel.setUpdateTime(application.getUpdateTime());
        return autoTestApplicationModel;
    }

    public static Application convertApplication(AutoTestApplicationModel application){
        if(application==null){
            return null;
        }
        Application autoTestApplicationModel= new Application();
        autoTestApplicationModel.setId(application.getId());
        autoTestApplicationModel.setAppCode(application.getAppCode());
        autoTestApplicationModel.setAppName(application.getAppName());
        autoTestApplicationModel.setOwner(application.getOwner());
        autoTestApplicationModel.setDesc(application.getDesc());
        autoTestApplicationModel.setCreateTime(application.getCreateTime());
        autoTestApplicationModel.setUpdateTime(application.getUpdateTime());
        return autoTestApplicationModel;
    }

}
