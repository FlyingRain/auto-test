package com.flyingrain.autotest.domain.core;

import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.core.model.ExecuteResult;
import com.flyingrain.autotest.domain.model.ParamMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONResultExtract implements ResultExtract {

    private final Logger logger = LoggerFactory.getLogger(JSONResultExtract.class);
    private List<ParamMap> resultConfig = new ArrayList<>();


    public JSONResultExtract(List<ParamMap> resultConfig) {
        this.resultConfig = resultConfig;

    }

    @Override
    public void extractResult(ExecuteResult executeResult, ExecuteContext executeContext) {
        String resultStr = executeResult.getResult();
        Map<String, String> resultMap = executeResult.getResultMap();
        Map<String, String> params = executeContext.getParams();
        if (!StringUtils.hasText(resultStr)) {
            return;
        }
        try {
            JSONObject jsonObject = JSONObject.parseObject(resultStr);
            if (!CollectionUtils.isEmpty(resultConfig)) {
                for (ParamMap paramMap : resultConfig) {
                    String keyPath = paramMap.getKey();
                    String[] keys = keyPath.split("\\.");
                    JSONObject value = jsonObject;
                    for (int i = 0; i < keys.length - 1; i++) {
                        if (jsonObject.containsKey(keys[i])) {
                            value = value.getJSONObject(keys[i]);
                        } else {
                            logger.error("result param not exits!result:[{}],extract path:[{}]", resultStr, keyPath);
                            throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "result extract error!");
                        }
                    }
                    String realValue = value.getString(keys[keys.length - 1]);
                    params.put(paramMap.getValue(), realValue);
                    resultMap.put(paramMap.getValue(), realValue);
                }
            }
        } catch (Exception e) {
            logger.error("extract result happen error!", e);
            throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "result extract failed! unknown exception!");
        }
    }
}
