package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.domain.model.Application;
import com.flyingrain.autotest.domain.service.convert.ApplicationConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestAppMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestApplicationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApplicationManager {

    private final Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    @Autowired
    private AutoTestAppMapper autoTestAppMapper;

    public PageableModel<Application> queryByPage(PageQuery<Application> applicationPageQuery) {
        logger.info("application page query :[{}]", applicationPageQuery);
        List<AutoTestApplicationModel> autoTestApplicationModels = autoTestAppMapper.queryByPage(new PageQuery<>(applicationPageQuery.getCurrentPage(), applicationPageQuery.getPageSize(), ApplicationConvert.convertModel(applicationPageQuery.getConditions())));
        logger.info("query result :[{}]", autoTestApplicationModels.size());
        int count = autoTestAppMapper.pageCount(new PageQuery<>(applicationPageQuery.getCurrentPage(), applicationPageQuery.getPageSize(), ApplicationConvert.convertModel(applicationPageQuery.getConditions())));
        PageableModel<Application> pageableModel = new PageableModel<>();
        pageableModel.setData(autoTestApplicationModels.stream().map(ApplicationConvert::convertApplication).collect(Collectors.toList()));
        pageableModel.setPageSize(applicationPageQuery.getPageSize());
        pageableModel.setCurrentPage(applicationPageQuery.getCurrentPage());
        pageableModel.setTotal(count);
        return pageableModel;
    }


    public boolean insertApplication(Application application) {
        logger.info("start to insert application:[{}]", application);
        int i = autoTestAppMapper.insertApp(ApplicationConvert.convertModel(application));
        return i > 0;
    }

    public int batchDel(List<Integer> appIds) {
        logger.info("start to batch del app ids:[{}]", appIds);
        return autoTestAppMapper.batchDel(appIds);
    }

    public List<Application> queryAll(){
        return autoTestAppMapper.queryAll().stream().map(ApplicationConvert::convertApplication).collect(Collectors.toList());
    }

    public Application queryDetail(int id){

        return ApplicationConvert.convertApplication(autoTestAppMapper.queryById(id));
    }

    public int updateApp(Application application){
        return autoTestAppMapper.updateApp(ApplicationConvert.convertModel(application));
    }
}
