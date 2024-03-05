package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.domain.AutoTestModuleManager;
import com.flyingrain.autotest.facade.intf.TestFacade;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestModuleModel;
import com.flyingrain.autotest.mvc.jersey.AutoTestService;
import com.flyingrain.autotest.mvc.jersey.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AutoTestService
public class TestFacadeImpl implements TestFacade, Resource {

    private final Logger logger = LoggerFactory.getLogger(TestFacadeImpl.class);

    @Autowired
    private AutoTestModuleManager autoTestModuleManager;

    @Override
    public String test() {
        logger.info("test log");
        List<AutoTestModuleModel> autoTestModuleModels = autoTestModuleManager.queryAllModule();
        return autoTestModuleModels + "";
    }


}
