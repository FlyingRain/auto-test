package com.flyingrain.autotest.service.convert;

import com.flyingrain.autotest.domain.model.Application;
import com.flyingrain.autotest.facade.intf.model.AutoTestApp;

public class ApplicationViewConvert {

    public static AutoTestApp convertView(Application application) {
        if (application == null) {
            return null;
        }
        AutoTestApp autoTestApp = new AutoTestApp();
        autoTestApp.setId(application.getId());
        autoTestApp.setAppCode(application.getAppCode());
        autoTestApp.setAppName(application.getAppName());
        autoTestApp.setDesc(application.getDesc());
        autoTestApp.setOwner(application.getOwner());
        autoTestApp.setCreateTime(application.getCreateTime());
        autoTestApp.setUpdateTime(application.getUpdateTime());
        return autoTestApp;
    }

    public static Application convertModel(AutoTestApp application) {
        if (application == null) {
            return null;
        }
        Application autoTestApp = new Application();
        autoTestApp.setId(application.getId());
        autoTestApp.setAppCode(application.getAppCode());
        autoTestApp.setAppName(application.getAppName());
        autoTestApp.setDesc(application.getDesc());
        autoTestApp.setOwner(application.getOwner());
        autoTestApp.setCreateTime(application.getCreateTime());
        autoTestApp.setUpdateTime(application.getUpdateTime());
        return autoTestApp;
    }
}
