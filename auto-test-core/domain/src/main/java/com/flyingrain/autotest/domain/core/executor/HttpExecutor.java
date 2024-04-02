package com.flyingrain.autotest.domain.core.executor;

import com.flyingrain.autotest.common.util.constant.HTTPRequestTypeEnum;
import com.flyingrain.autotest.domain.core.model.ExecuteParam;
import com.flyingrain.autotest.domain.core.model.ExecuteResult;
import com.flyingrain.autotest.domain.core.model.HttpExecuteParam;
import com.flyingrain.autotest.domain.utils.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("HTTP")
public class HttpExecutor implements Executor<String> {

    private final Logger logger = LoggerFactory.getLogger(HttpExecutor.class);

    @Override
    public ExecuteResult execute(ExecuteParam<String> executeParam) {
        logger.info("start to send params");
        ExecuteResult executeResult = new ExecuteResult();
        HttpExecuteParam httpExecuteParam = (HttpExecuteParam) executeParam;
        String url = executeParam.getPath();
        HTTPRequestTypeEnum httpRequestTypeEnum = httpExecuteParam.getRequestTypeEnum();
        Map<String, String> headers = httpExecuteParam.getHeaders();
        String body = httpExecuteParam.getBody();
        switch (httpRequestTypeEnum) {
            case GET:
                runGet(url, headers, executeResult);
                break;
            case POST:
                runPost(url, headers, body, executeResult);
                break;
            default:
                break;

        }

        return executeResult;
    }

    private void runPost(String url, Map<String, String> headers, String body, ExecuteResult executeResult) {
        try {
            String result = HttpClientUtils.post(url, body, headers);
            logger.info("run post result:[{}]", result);
            executeResult.setSuccess(true);
            executeResult.setResult(result);
        } catch (Exception e) {
            logger.error("run result failed!", e);
            executeResult.setSuccess(false);
        }
    }

    private void runGet(String url, Map<String, String> headers, ExecuteResult executeResult) {
        try {
            String result = HttpClientUtils.get(url, headers);
            logger.info("run result:[{}]", result);
            executeResult.setResult(result);
            executeResult.setSuccess(true);
        } catch (Exception e) {
            logger.error("run result failed!", e);
            executeResult.setSuccess(false);
        }
    }
}
