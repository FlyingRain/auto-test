package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.facade.intf.model.AutoTestScene;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import com.flyingrain.autotest.facade.intf.scene.SceneFacade;
import org.springframework.stereotype.Component;

@Component
public class SceneFacadeImpl implements SceneFacade {
    @Override
    public CommonResult<PageableModel<AutoTestScene>> list(PageQuery<AutoTestScene> pageQuery) {
        return null;
    }

    @Override
    public CommonResult<Boolean> add(AutoTestScene autoTestScene) {
        return null;
    }

    @Override
    public CommonResult<AutoTestScene> update(AutoTestScene autoTestScene) {
        return null;
    }

    @Override
    public CommonResult<AutoTestScene> detail(Integer id) {
        return null;
    }

    @Override
    public CommonResult<Integer> batchDel(BatchDelRequest batchDelRequest) {
        return null;
    }
}
