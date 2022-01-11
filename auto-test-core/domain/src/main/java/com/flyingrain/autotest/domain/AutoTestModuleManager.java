package com.flyingrain.autotest.domain;

import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestModuleMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestModuleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutoTestModuleManager {

    @Autowired
    private AutoTestModuleMapper autoTestModuleMapper;

    public List<AutoTestModuleModel> queryAllModule() {
        return autoTestModuleMapper.queryAllModule(1L);
    }


}
