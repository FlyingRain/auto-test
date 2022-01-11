package com.flyingrain.autotest.domain.core.executor.protocol.http;

import com.alibaba.fastjson.JSON;
import com.flyingrain.autotest.domain.constant.AutoTestResultCodeEnum;
import com.flyingrain.autotest.domain.constant.ProtocolTypeEnum;
import com.flyingrain.autotest.domain.core.executor.protocol.ProtocolHandler;
import com.flyingrain.autotest.domain.core.requestHandler.SendRequest;
import com.flyingrain.autotest.domain.core.reuslthandler.SendResult;
import com.flyingrain.autotest.domain.exception.AutoTestException;
import com.flyingrain.autotest.domain.utils.HttpClientUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wally
 * @date 2021-12-16
 */
@Component
public class HttpProtocolHandler implements ProtocolHandler {

    private Logger logger = LoggerFactory.getLogger(HttpProtocolHandler.class);

    private static final String HEADERS = "headers";

    private static final String CONTENT = "content";


    @Override
    public SendResult handle(SendRequest sendRequest) {

        checkSendRequest(sendRequest);

        String resultStr = doHandle(sendRequest);

        return handleResult(resultStr);
    }

    private SendResult handleResult(String resultStr) {
        SendResult sendResult = new SendResult();
        sendResult.setOriginResult(resultStr);
        return sendResult;
    }

    private String doHandle(SendRequest sendRequest) {
        String content = sendRequest.getSendContent().toString();
        Map<String, String> header = new HashMap<>();
        Map<String, Object> sendParam = JSON.parseObject(content, Map.class);
        Object headers = sendParam.get(HEADERS);
        if (headers instanceof Map) {
            header = (Map<String, String>) headers;
        }
        Object sendContent = sendParam.get(CONTENT);
        if (HttpSendTypeEnum.GET.name().equals(sendRequest.getSendType())) {
            logger.info("start to send to :[{}] by GET", sendRequest.getUrl());
            return HttpClientUtils.get(sendRequest.getUrl(), header);
        }
        if (HttpSendTypeEnum.POST.name().equals(sendRequest.getSendType())) {
            logger.info("start to send to:[{}] by POST", sendRequest.getUrl());
            logger.info("start to send content:[{}] by POST", sendRequest.getSendContent());
            return HttpClientUtils.post(sendRequest.getUrl(), sendContent == null ? null : JSON.toJSONString(sendContent), header);
        }
        logger.error("do not support such type:[{}]", sendRequest);
        throw new AutoTestException(AutoTestResultCodeEnum.NO_TYPE_HANDLE);
    }

    private void checkSendRequest(SendRequest sendRequest) {
        if (sendRequest == null || StringUtils.isEmpty(sendRequest.getUrl())) {
            logger.error("url is empty![{}]", sendRequest);
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR);
        }
    }

    @Override
    public ProtocolTypeEnum handProtocol() {
        return ProtocolTypeEnum.HTTP;
    }

}
