package com.flyingrain.autotest.domain.core.requestHandler;

import com.alibaba.fastjson.JSON;
import com.flyingrain.autotest.domain.constant.TypeEnum;
import com.flyingrain.autotest.domain.core.executor.CaseResultCache;
import com.flyingrain.autotest.domain.core.typehandle.CommonTypeHandler;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.Module;
import com.flyingrain.autotest.domain.model.Project;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.domain.utils.TemplateHandleHelper;
import com.flyingrain.autotest.facade.intf.requests.DataTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wally
 * @date 2021-12-15
 */
@Component
public class JsonRequestHandler extends AbstractRequestHandler {

    @Autowired
    private CommonTypeHandler commonTypeHandler;

    @Override
    public SendRequest buildSendRequest(Case runCase, CaseResultCache caseResultCache) {

        String sendContent = generateContent(runCase, caseResultCache);

        String url = generateUrl(runCase, caseResultCache);

        return buildRequest(sendContent, url, runCase);
    }

    @Override
    public DataTypeEnum supportType() {
        return DataTypeEnum.JSON;
    }

    private SendRequest buildRequest(String sendContent, String url, Case runCase) {
        SendRequest sendRequest = new SendRequest();
        sendRequest.setSendContent(sendContent);
        sendRequest.setUrl(url);
        Service service = runCase.getService();
        sendRequest.setSendType(service.getRequestType());
        return sendRequest;
    }

    private String generateUrl(Case runCase, CaseResultCache caseResultCache) {
        Service service = runCase.getService();
        Module module = service.getModule();
        Project project = module.getProject();
        String projectUrl = project.getProjectUrl();
        String moduleUrl = module.getModuleUrl();
        String serviceUrl = service.getRequestUrl();
        String totalUrl = projectUrl + moduleUrl + serviceUrl;

        totalUrl = replaceStaticParam(totalUrl, runCase.getData());

        totalUrl = replaceDynamicParam(totalUrl, caseResultCache);
        return totalUrl;
    }


    @Override
    protected Object handleType(Object value, String type) {
        if (TypeEnum.STRING.name().equals(type.trim().toUpperCase())) {
            return "\"" + value + "\"";
        }
        return value;
    }

    @Override
    protected String handleDynamicObject(Object o) {
        if (o instanceof String) {
            return "\"" + o + "\"";
        }
        if (!TemplateHandleHelper.isPrimitive(o)) {
            return JSON.toJSONString(o);
        }
        return String.valueOf(o);
    }
}
