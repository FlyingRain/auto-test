package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.*;
import com.flyingrain.autotest.common.util.constant.AutoTestConstants;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.Scene;
import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.domain.service.SceneService;
import com.flyingrain.autotest.facade.intf.model.AutoTestScene;
import com.flyingrain.autotest.facade.intf.scene.SceneFacade;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.convert.SceneViewConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SceneFacadeImpl implements SceneFacade, Resource {

    private final Logger logger = LoggerFactory.getLogger(SceneFacadeImpl.class);

    @Autowired
    private SceneService sceneService;

    @Override
    public CommonResult<PageableModel<AutoTestScene>> list(PageQuery<AutoTestScene> pageQuery) {
        PageableModel<Scene> pageableModel = sceneService.queryByPage(new PageQuery<>(pageQuery.getCurrentPage(), pageQuery.getPageSize(), SceneViewConvert.convertToModel(pageQuery.getConditions())));
        PageableModel<AutoTestScene> autoTestScenePageableModel = PageableModel.copy(pageableModel);
        autoTestScenePageableModel.setData(pageableModel.getData().stream().map(SceneViewConvert::convertToView).collect(Collectors.toList()));
        return CommonResult.success(autoTestScenePageableModel);
    }

    @Override
    public CommonResult<Boolean> add(AutoTestScene autoTestScene) {
        User user = RunTimeContext.get(AutoTestConstants.USER);
        if (user == null) {
            throw new AutoTestException(AutoTestResultCodeEnum.NOT_LOGIN);
        }
        autoTestScene.setOperator(user.getUserName());
        return CommonResult.success(sceneService.add(SceneViewConvert.convertToModel(autoTestScene)));
    }

    @Override
    public CommonResult<Boolean> update(AutoTestScene autoTestScene) {
        User user = RunTimeContext.get(AutoTestConstants.USER);
        if (user == null) {
            throw new AutoTestException(AutoTestResultCodeEnum.NOT_LOGIN);
        }
        autoTestScene.setOperator(user.getUserName());
        return CommonResult.success(sceneService.update(SceneViewConvert.convertToModel(autoTestScene)));
    }

    @Override
    public CommonResult<AutoTestScene> detail(Integer id) {
        return CommonResult.success(SceneViewConvert.convertToView(sceneService.detail(id)));
    }

    @Override
    public CommonResult<Boolean> delScene(Integer sceneId) {
        User user = RunTimeContext.get(AutoTestConstants.USER);
        if (user == null) {
            throw new AutoTestException(AutoTestResultCodeEnum.NOT_LOGIN);
        }
        logger.info("user:[{}] del scene:[{}]", user, sceneId);
        return CommonResult.success(sceneService.delete(sceneId));
    }

    @Override
    public CommonResult<String> run(Integer sceneId) {
        logger.info("will run sceneId:[{}]", sceneId);
        return CommonResult.success(sceneService.run(sceneId));
    }
}
