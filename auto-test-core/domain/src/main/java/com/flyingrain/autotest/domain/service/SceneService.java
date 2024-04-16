package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.Scene;
import com.flyingrain.autotest.domain.model.SceneCase;
import com.flyingrain.autotest.domain.service.convert.SceneCaseModelConvert;
import com.flyingrain.autotest.domain.service.convert.SceneModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestCaseSceneMapper;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestSceneMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSceneCaseModel;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSceneModel;
import org.glassfish.jersey.internal.guava.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SceneService {

    private final Logger logger = LoggerFactory.getLogger(SceneService.class);

    @Autowired
    private AutoTestCaseSceneMapper autoTestCaseSceneMapper;

    @Autowired
    private AutoTestSceneMapper autoTestSceneMapper;

    @Autowired
    private CaseService caseService;

    public boolean add(Scene scene) {
        logger.info("start to add scene:[{}]", scene);
        int count = autoTestSceneMapper.insert(SceneModelConvert.convertToModel(scene));
        return count == 1;
    }

    public PageableModel<Scene> queryByPage(PageQuery<Scene> pageQuery) {
        logger.info("query scene page:[{}]", pageQuery);
        PageQuery<AutoTestSceneModel> queryCondition = new PageQuery<>(pageQuery.getCurrentPage(), pageQuery.getPageSize(), SceneModelConvert.convertToModel(pageQuery.getConditions()));
        List<AutoTestSceneModel> autoTestSceneModelList = autoTestSceneMapper.queryByPage(queryCondition);
        int count = autoTestSceneMapper.queryByPageCount(queryCondition);
        PageableModel<Scene> result = new PageableModel<>();
        result.copyOf(pageQuery);
        result.setData(autoTestSceneModelList.stream().map(SceneModelConvert::convertToDomain).collect(Collectors.toList()));
        result.setTotal(count);
        return result;
    }

    @Transactional
    public boolean update(Scene scene) {
        logger.info("update scene:[{}]", scene);
        autoTestCaseSceneMapper.deleteBySceneId(scene.getId());
        autoTestSceneMapper.updateById(SceneModelConvert.convertToModel(scene));
        if (!CollectionUtils.isEmpty(scene.getSceneCases())) {
            autoTestCaseSceneMapper.batchInsert(scene.getSceneCases().stream().map(SceneCaseModelConvert::convertToModel).collect(Collectors.toList()));
        }
        return true;
    }

    @Transactional
    public boolean delete(Integer sceneId) {
        logger.info("start to del scene:[{}]", sceneId);
        autoTestCaseSceneMapper.deleteBySceneId(sceneId);
        autoTestSceneMapper.batchDel(Collections.singletonList(sceneId));
        return true;
    }

    public Scene detail(Integer sceneId) {
        logger.info("query scene id:[{}]", sceneId);
        AutoTestSceneModel autoTestSceneModel = autoTestSceneMapper.detail(sceneId);
        Scene scene = SceneModelConvert.convertToDomain(autoTestSceneModel);
        fillScene(scene);
        return scene;
    }


    private void fillScene(Scene scene) {
        List<AutoTestSceneCaseModel> autoTestSceneCaseModels = autoTestCaseSceneMapper.queryAllSceneCase(scene.getId());
        if (CollectionUtils.isEmpty(autoTestSceneCaseModels)) {
            return;
        }
        List<Integer> caseIds = autoTestSceneCaseModels.stream().map(AutoTestSceneCaseModel::getCaseId).distinct().toList();
        List<Case> cases = caseService.queryFilledCaseByIds(caseIds);
        List<SceneCase> sceneCases = autoTestSceneCaseModels.stream().map(autoTestSceneCaseModel -> {
            SceneCase sceneCase = SceneCaseModelConvert.convertToDomain(autoTestSceneCaseModel);
            for (Case runCase : cases) {
                if (sceneCase.getCaseId() == runCase.getId()) {
                    sceneCase.setRunCase(runCase);
                }
                throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "场景用例不存在，场景编码：" + scene.getSceneCode() + ",用例id：" + sceneCase.getCaseId());
            }
            return sceneCase;
        }).toList();
        scene.setSceneCases(sceneCases);
    }
}
