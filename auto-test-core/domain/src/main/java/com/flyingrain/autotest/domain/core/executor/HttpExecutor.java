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
public class HttpExecutor implements Executor<HttpRequestBody> {

    private final Logger logger = LoggerFactory.getLogger(HttpExecutor.class);

    @Override
    public ExecuteResult execute(ExecuteParam<HttpRequestBody> executeParam) {
        logger.info("start to send params：[{}]", executeParam);
        ExecuteResult executeResult = new ExecuteResult();
        try {
            HttpExecuteParam httpExecuteParam = (HttpExecuteParam) executeParam;
            String url = executeParam.getPath();
            HTTPRequestTypeEnum httpRequestTypeEnum = httpExecuteParam.getRequestTypeEnum();
            Map<String, String> headers = httpExecuteParam.getHeaders();
            HttpRequestBody body = httpExecuteParam.getBody();
            long startTime = System.currentTimeMillis();
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
            long endTime = System.currentTimeMillis();
            long spendTime = endTime - startTime;
            executeResult.setSpendTime(spendTime);
            logger.info("end interface [{}],call spend:[{}]", url, spendTime);
        } catch (Exception e) {
            logger.error("execute failed!", e);
            executeResult.setSuccess(false);
            executeResult.setResult(e.getMessage());
        }
        return executeResult;
    }

    private void runPost(String url, Map<String, String> headers, HttpRequestBody body, ExecuteResult executeResult) {
        try {
            String result = HttpClientUtils.post(url, body, headers);
            logger.info("run post result:[{}]", result);
            executeResult.setSuccess(true);
            executeResult.setResult(result);
        } catch (Exception e) {
            logger.error("run result failed!", e);
            executeResult.setSuccess(false);
            executeResult.setResult(e.getMessage());
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
            executeResult.setResult(e.getMessage());
        }
    }
}
