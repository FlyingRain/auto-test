package com.flyingrain.autotest.domain.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.DynamicParamExtract;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.ParamMap;
import com.flyingrain.autotest.domain.model.ParamValue;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.domain.model.ServiceParam;
import com.flyingrain.autotest.domain.service.convert.ServiceModelConvert;
import com.flyingrain.autotest.domain.service.convert.ServiceParamModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestCaseMapper;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestServiceMapper;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestServiceParamMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestCaseModel;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceModel;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceParamModel;
import org.glassfish.jersey.internal.guava.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ServiceManager {
    private final Logger logger = LoggerFactory.getLogger(ServiceManager.class);

    @Autowired
    private AutoTestServiceMapper autoTestServiceMapper;

    @Autowired
    private AutoTestServiceParamMapper serviceParamMapper;

    @Autowired
    private AutoTestCaseMapper autoTestCaseMapper;


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
        Service service = ServiceModelConvert.convertServiceModel(autoTestServiceModel);
        fillServiceParam(service);
        return service;
    }

    public void fillServiceParam(Service service) {
        List<AutoTestServiceParamModel> autoTestServiceParamModels = serviceParamMapper.queryServiceParams(service.getId());
        if (!CollectionUtils.isEmpty(autoTestServiceParamModels)) {
            List<ServiceParam> serviceParams = autoTestServiceParamModels.stream().map(ServiceParamModelConvert::convertModel).collect(Collectors.toList());
            service.setParams(serviceParams);
        }
    }

    public List<Service> queryByAppIds(List<Integer> appIds) {
        logger.info("query service detail:[{}]", appIds);
        List<AutoTestServiceModel> autoTestServiceModels = autoTestServiceMapper.queryByAppIds(appIds);
        return autoTestServiceModels.stream().map(ServiceModelConvert::convertServiceModel).collect(Collectors.toList());
    }


    @Transactional
    public int addService(Service service) {
        logger.info("add service:[{}]", service);
        AutoTestServiceModel autoTestServiceModel = ServiceModelConvert.convertService(service);
        autoTestServiceMapper.insertServiceModel(autoTestServiceModel);
        service.setId(autoTestServiceModel.getId());
        logger.info("insert service success;id:[{}]", service.getId());
        List<ServiceParam> serviceParams = extractParams(service);
        if (!CollectionUtils.isEmpty(serviceParams)) {
            int count = serviceParamMapper.batchInsert(serviceParams.stream().map(ServiceParamModelConvert::convertServiceParam).collect(Collectors.toList()));
            logger.info("insert service param:[{}]", count);
        }
        logger.info("insert service ,service:[{}]", service.getName());
        return 1;
    }

    private List<ServiceParam> extractParams(Service service) {
        Set<String> params = new HashSet<>();
        String requestUrl = service.getRequestUrl();
        if (StringUtils.hasText(requestUrl)) {
            List<String> tempUrl = DynamicParamExtract.extractParam(requestUrl);
            params.addAll(tempUrl);
            logger.info("extract params from url:[{}]", tempUrl.size());
        }
        if (StringUtils.hasText(service.getRequestDataModule())) {
            List<String> tempContent = DynamicParamExtract.extractParam(service.getRequestDataModule());
            params.addAll(tempContent);
            logger.info("extract params from body:[{}]", tempContent.size());
        }
        if (StringUtils.hasText(service.getHeaders())) {
            List<ParamMap> headers = JSONArray.parseArray(service.getHeaders(), ParamMap.class);
            for (ParamMap header : headers) {
                List<String> keyParam = DynamicParamExtract.extractParam(header.getKey());
                List<String> valueParam = DynamicParamExtract.extractParam(header.getValue());
                params.addAll(keyParam);
                params.addAll(valueParam);
            }
        }
        return params.stream().map(param -> {
            ServiceParam serviceParam = new ServiceParam();
            serviceParam.setParam(param);
            serviceParam.setServiceId(service.getId());
            return serviceParam;
        }).collect(Collectors.toList());
    }


    @Transactional
    public int updateServiceById(Service service) {
        logger.info("update service:[{}]", service);
        serviceParamMapper.deleteServiceParams(service.getId());
        List<ServiceParam> params = extractParams(service);
        if (!CollectionUtils.isEmpty(params)) {
            serviceParamMapper.batchInsert(params.stream().map(ServiceParamModelConvert::convertServiceParam).collect(Collectors.toList()));
        } else {
            params = new ArrayList<>();
        }
        updateCase(service.getId(), params);
        return autoTestServiceMapper.updateServiceById(ServiceModelConvert.convertService(service));
    }

    private void updateCase(int id, List<ServiceParam> params) {
        List<AutoTestCaseModel> caseModels = autoTestCaseMapper.queryByServiceIds(Collections.singletonList(id));
        caseModels.forEach(autoTestCaseModel -> {
            String paramValue = autoTestCaseModel.getParamValue();
            List<ParamValue> paramValueList = StringUtils.hasText(paramValue) ? JSONArray.parseArray(paramValue, ParamValue.class) : new ArrayList<>();
            List<ParamValue> newParam = params.stream().map(serviceParam -> {
                ParamValue p = new ParamValue();
                p.setName(serviceParam.getParam());
                for (ParamValue old : paramValueList) {
                    if (serviceParam.getParam().equals(old.getName())) {
                        p.setValue(old.getValue());
                    }
                }
                return p;
            }).toList();
            autoTestCaseModel.setParamValue(JSONArray.toJSONString(newParam));
            autoTestCaseMapper.updateCaseById(autoTestCaseModel);
        });
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

    public List<Service> queryServiceByIds(List<Integer> serviceIds) {
        logger.info("query serviceIds:[{}]", serviceIds);
        List<AutoTestServiceModel> autoTestServiceModels = autoTestServiceMapper.queryServiceByIds(serviceIds);
        return autoTestServiceModels.stream().map(ServiceModelConvert::convertServiceModel).collect(Collectors.toList());

    }

    private boolean beforeDeleteCheck(List<Integer> serviceIds) {
        List<AutoTestCaseModel> cases = autoTestCaseMapper.queryByServiceIds(serviceIds);
        return CollectionUtils.isEmpty(cases);
    }

    public List<Service> queryAllService() {
        return autoTestServiceMapper.queryAllService().stream().map(ServiceModelConvert::convertServiceModel).peek(this::fillServiceParam).collect(Collectors.toList());
    }

}
