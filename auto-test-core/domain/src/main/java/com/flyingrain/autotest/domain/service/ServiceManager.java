package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.domain.service.convert.ServiceModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestServiceMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceManager {
    private final Logger logger = LoggerFactory.getLogger(ServiceManager.class);

    @Autowired
    private AutoTestServiceMapper autoTestServiceMapper;


    public PageableModel<Service> queryByPage(PageQuery<Service> servicePageQuery) {
        logger.info("query service :[{}]", servicePageQuery);
        PageableModel<Service> pageableModel = new PageableModel<>();
        PageQuery<AutoTestServiceModel> queryCondition = new PageQuery<>(servicePageQuery.getCurrentPage(), servicePageQuery.getPageSize(), ServiceModelConvert.convertService(servicePageQuery.getConditions()));
        List<AutoTestServiceModel> autoTestServiceModels = autoTestServiceMapper.queryByPage(queryCondition);
        int total = autoTestServiceMapper.countByPage(queryCondition);
        pageableModel.copyOf(servicePageQuery);
        pageableModel.setTotal(total);
        if (CollectionUtils.isEmpty(autoTestServiceModels)) {
            pageableModel.setData(new ArrayList<>());
        } else {
            List<Service> services = autoTestServiceModels.stream().map(ServiceModelConvert::convertServiceModel).collect(Collectors.toList());
            pageableModel.setData(services);
        }
        return pageableModel;
    }


    public Service queryById(int serviceId) {
        logger.info("query service detail:[{}]", serviceId);
        AutoTestServiceModel autoTestServiceModel = autoTestServiceMapper.queryById(serviceId);
        return ServiceModelConvert.convertServiceModel(autoTestServiceModel);
    }

    public List<Service> queryByAppIds(List<Integer> appIds) {
        logger.info("query service detail:[{}]", appIds);
        List<AutoTestServiceModel> autoTestServiceModels = autoTestServiceMapper.queryByAppIds(appIds);
        return autoTestServiceModels.stream().map(ServiceModelConvert::convertServiceModel).collect(Collectors.toList());
    }


    public int addService(Service service) {
        logger.info("add service:[{}]", service);
        return autoTestServiceMapper.insertServiceModel(ServiceModelConvert.convertService(service));
    }

    public int updateServiceById(Service service) {
        logger.info("update service:[{}]", service);
        return autoTestServiceMapper.updateServiceById(ServiceModelConvert.convertService(service));
    }

    public int batchDelete(List<Integer> serviceIds, String operator) {
        logger.info("start to batch delete:[{}],operator:[{}]", serviceIds, operator);
        //TODO 校验服务下没有用例，否则不让删除
        if (beforeDeleteCheck(serviceIds)) {
            return autoTestServiceMapper.batchDelete(serviceIds);
        } else {
            throw new AutoTestException("500", "服务下存在用例，请先删除服务下的所有用例");
        }
    }

    private boolean beforeDeleteCheck(List<Integer> serviceIds) {
        return true;
    }

}
