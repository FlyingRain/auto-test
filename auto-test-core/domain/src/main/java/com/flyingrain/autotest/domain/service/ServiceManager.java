package com.flyingrain.autotest.domain.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.HttpHeader;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.domain.model.ServiceParam;
import com.flyingrain.autotest.domain.service.convert.ServiceModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestServiceMapper;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestServiceParamMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ServiceManager {
    private final Logger logger = LoggerFactory.getLogger(ServiceManager.class);

    @Autowired
    private AutoTestServiceMapper autoTestServiceMapper;

    @Autowired
    private AutoTestServiceParamMapper serviceParamMapper;


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


    @Transactional
    public int addService(Service service) {
        logger.info("add service:[{}]", service);
        List<ServiceParam> serviceParams = extractParams(service);
        return autoTestServiceMapper.insertServiceModel(ServiceModelConvert.convertService(service));
    }

    private List<ServiceParam> extractParams(Service service) {
        List<String> params = new ArrayList<>();
        String requestUrl = service.getRequestUrl();
        if (StringUtils.hasText(requestUrl)) {
            List<String> tempUrl = extractParamsFromStr(requestUrl);
            params.addAll(tempUrl);
            logger.info("extract params from url:[{}]", tempUrl.size());
        }
        if (StringUtils.hasText(service.getRequestDataModule())) {
            List<String> tempContent = extractParamsFromStr(requestUrl);
            params.addAll(tempContent);
            logger.info("extract params from url:[{}]", tempContent.size());
        }
        if (StringUtils.hasText(service.getHeaders())) {
            List<HttpHeader> headers = JSONArray.parseArray(service.getHeaders(), HttpHeader.class);
            for (HttpHeader header : headers) {
                List<String> keyParam = extractParamsFromStr(header.getKey());
                List<String> valueParam = extractParamsFromStr(header.getValue());
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


    /**
     * 从字符串中提取动态参数
     *
     * @param str
     * @return
     */
    private List<String> extractParamsFromStr(String str) {
        List<String> serviceParams = new ArrayList<>();
        if (!StringUtils.hasText(str)) {
            return new ArrayList<>();
        }
        int startIndex = 0, endIndex = 0;
        for (int i = 1; i < str.length(); i++) {
            if (Character.toString(str.charAt(i)).equals("{") && Character.toString(str.charAt(i - 1)).equals("$")) {
                if (startIndex != 0) {
                    logger.error("param format error!at str index:[{}]", i);
                    throw new AutoTestException(AutoTestResultCodeEnum.TEMPLATE_ERROR);
                }
                startIndex = i + 1;
            }
            if (Character.toString(str.charAt(i)).equals("}")) {
                endIndex = i;
                if (startIndex == 0 || startIndex >= endIndex) {
                    logger.error("param format error!at str index:[{}]", i);
                    throw new AutoTestException(AutoTestResultCodeEnum.TEMPLATE_ERROR);
                }
                startIndex = 0;
                String param = str.substring(startIndex, endIndex);
                serviceParams.add(param);
            }
        }
        return serviceParams;
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
