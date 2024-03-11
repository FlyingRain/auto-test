package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.facade.intf.app.AppFacade;
import com.flyingrain.autotest.facade.intf.model.AutoTestApp;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppFacadeImpl implements AppFacade {
    @Override
    public CommonResult<PageableModel<AutoTestApp>> queryAppWithPage(PageQuery<AutoTestApp> queryCondition) {
        return null;
    }

    @Override
    public CommonResult<Boolean> addApp(AutoTestApp autoTestApp) {
        return null;
    }

    @Override
    public CommonResult<List<AutoTestApp>> queryAllApp() {
        return null;
    }

    @Override
    public CommonResult<Boolean> batchDel(BatchDelRequest batchDelRequest) {
        return null;
    }
}
