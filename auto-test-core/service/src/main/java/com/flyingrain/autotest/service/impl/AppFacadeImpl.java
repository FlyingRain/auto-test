package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.Application;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.domain.service.ApplicationManager;
import com.flyingrain.autotest.domain.service.ServiceManager;
import com.flyingrain.autotest.facade.intf.app.AppFacade;
import com.flyingrain.autotest.facade.intf.model.AutoTestApp;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceModel;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.convert.ApplicationViewConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppFacadeImpl implements AppFacade, Resource {

    private final Logger logger = LoggerFactory.getLogger(AppFacadeImpl.class);

    @Autowired
    private ApplicationManager applicationManager;

    @Autowired

    private ServiceManager serviceManager;

    @Override
    public CommonResult<PageableModel<AutoTestApp>> queryAppWithPage(PageQuery<AutoTestApp> queryCondition) {
        PageQuery<Application> pageQuery = new PageQuery<>(queryCondition.getCurrentPage(), queryCondition.getPageSize(), ApplicationViewConvert.convertModel(queryCondition.getConditions()));
        PageableModel<Application> result = applicationManager.queryByPage(pageQuery);
        PageableModel<AutoTestApp> temp = PageableModel.copy(result);
        temp.setData(result.getData().stream().map(ApplicationViewConvert::convertView).collect(Collectors.toList()));
        return CommonResult.success(temp);
    }

    @Override
    public CommonResult<Boolean> addApp(AutoTestApp autoTestApp) {
        boolean result = applicationManager.insertApplication(ApplicationViewConvert.convertModel(autoTestApp));
        return CommonResult.success(result);
    }

    @Override
    public CommonResult<List<AutoTestApp>> queryAllApp() {
        List<Application> result = applicationManager.queryAll();
        return CommonResult.success(result.stream().map(ApplicationViewConvert::convertView).collect(Collectors.toList()));
    }

    @Override
    public CommonResult<Integer> batchDel(BatchDelRequest batchDelRequest) {
        checkParam(batchDelRequest);
        int count = applicationManager.batchDel(batchDelRequest.getIds());
        return CommonResult.success(count);
    }

    @Override
    public CommonResult<AutoTestApp> queryDetailById(Integer id) {
        Application application = applicationManager.queryDetail(id);
        return CommonResult.success(ApplicationViewConvert.convertView(application));
    }

    @Override
    public CommonResult<Boolean> updateApp(AutoTestApp autoTestApp) {
        StringBuilder errorMsg = new StringBuilder();
        if (autoTestApp.getId() == 0) {
            logger.error("id is invalid");
            errorMsg.append("id is invalid;");
        }
        int count = applicationManager.updateApp(ApplicationViewConvert.convertModel(autoTestApp));
        return count == 1 ? CommonResult.success(true) : CommonResult.fail("500", errorMsg.toString());
    }

    private void checkParam(BatchDelRequest batchDelRequest) {
        List<Integer> appIds = batchDelRequest.getIds();
        List<Service> autoTestServiceModels = serviceManager.queryByAppIds(appIds);
        if (!CollectionUtils.isEmpty(autoTestServiceModels)) {
            logger.error("can't delete  app  still had service:[{}]", autoTestServiceModels);
            throw new AutoTestException(AutoTestResultCodeEnum.DEPEND_NOT_CLEAN.getCode(),"请先删除应用下的所有服务");
        }
    }


}
