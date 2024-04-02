package com.flyingrain.autotest.domain.core;

import com.alibaba.fastjson.JSONArray;
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
import java.util.HashMap;
import java.util.List;

public class JSONResultExtract implements ResultExtract {

    private final Logger logger = LoggerFactory.getLogger(JSONResultExtract.class);
    private List<ParamMap> resultConfig = new ArrayList<>();


    public JSONResultExtract(String config) {
        if (StringUtils.hasText(config)) {
            resultConfig = JSONArray.parseArray(config).toJavaList(ParamMap.class);
        }

    }

    @Override
    public void extractResult(ExecuteResult executeResult, ExecuteContext executeContext) {
        String resultStr = executeResult.getResult();
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
                    value.toJavaObject(String.class);


                }
            }
        } catch (Exception e) {
            logger.error("extract result happen error!", e);
        }
    }
}
