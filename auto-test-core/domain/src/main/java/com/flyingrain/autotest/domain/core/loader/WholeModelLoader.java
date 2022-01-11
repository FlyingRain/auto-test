package com.flyingrain.autotest.domain.core.loader;

import com.flyingrain.autotest.domain.service.convert.*;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestProjectMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestProjectModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author wally
 * @date 2021-12-09
 */
@Component
public class WholeModelLoader {

    private static final Logger logger = LoggerFactory.getLogger(WholeModelLoader.class);

    @Autowired
    private ProjectModelLoader projectModelLoader;

    @Autowired
    private AutoTestProjectMapper autoTestProjectMapper;

    public synchronized void loadAllModel() {
        List<AutoTestProjectModel> autoTestProjectModels = autoTestProjectMapper.queryAllProject();
        if (CollectionUtils.isEmpty(autoTestProjectModels)) {
            logger.warn("no project!");
            return;
        }
        autoTestProjectModels.stream().map(ProjectModelConvert::convertModel).forEach(projectModelLoader::loadModel);
    }
}
