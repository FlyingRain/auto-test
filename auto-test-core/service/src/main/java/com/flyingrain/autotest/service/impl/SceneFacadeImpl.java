package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.domain.model.Scene;
import com.flyingrain.autotest.domain.service.SceneService;
import com.flyingrain.autotest.facade.intf.model.AutoTestScene;
import com.flyingrain.autotest.facade.intf.scene.SceneFacade;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.convert.SceneViewConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SceneFacadeImpl implements SceneFacade, Resource {


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
        return CommonResult.success(sceneService.add(SceneViewConvert.convertToModel(autoTestScene)));
    }

    @Override
    public CommonResult<Boolean> update(AutoTestScene autoTestScene) {
        return CommonResult.success(sceneService.update(SceneViewConvert.convertToModel(autoTestScene)));
    }

    @Override
    public CommonResult<AutoTestScene> detail(Integer id) {
        return CommonResult.success(SceneViewConvert.convertToView(sceneService.detail(id)));
    }

    @Override
    public CommonResult<Boolean> delScene(Integer sceneId) {
        return CommonResult.success(sceneService.delete(sceneId));
    }
}
