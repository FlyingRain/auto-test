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
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONResultExtract implements ResultExtract {

    private final Logger logger = LoggerFactory.getLogger(JSONResultExtract.class);
    private List<ParamMap> resultConfig = new ArrayList<>();


    public JSONResultExtract(List<ParamMap> resultConfig) {
        this.resultConfig = resultConfig;

    }

    @Override
    public void extractResult(ExecuteResult executeResult, ExecuteContext executeContext) {
        if (CollectionUtils.isEmpty(resultConfig)) {
            logger.info("no result need to extract,exit[{}]", executeContext.getExecuteCode());
            return;
        }
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
                    int extractLen = isMethodKey(keys[keys.length - 1]) ? keys.length - 2 : keys.length - 1;
                    for (int i = 0; i < extractLen; i++) {
                        value = extractKey(keys[i], value);
                        if (value == null) {
                            logger.error("result param not exits!result:[{}],extract path:[{}]", resultStr, keyPath);
                            throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "result extract error!" + keyPath);
                        }
                    }
                    String realValue = null;
                    if (isMethodKey(keys[keys.length - 1])) {
                        realValue = executeMethod(value, keys[keys.length - 2], keys[keys.length - 1]);
                    } else if (isArrayKey(keys[keys.length - 1])) {
                        String key = keys[keys.length - 1];
                        int start = key.indexOf("[");
                        String numberStr = key.substring(start + 1, key.length() - 1);
                        realValue = value.getJSONArray(key.substring(0, start)).getString(Integer.parseInt(numberStr));
                    } else {
                        realValue = value.getString(keys[keys.length - 1]);
                    }
                    params.put(paramMap.getValue(), realValue);
                    resultMap.put(paramMap.getValue(), realValue);
                }
            }
        } catch (Exception e) {
            logger.error("extract result happen error!", e);
            executeResult.setSuccess(false);
            executeResult.setExtractResult(e.getMessage());
        }
    }

    private String executeMethod(JSONObject value, String key, String method) {
        if (method.endsWith("size()")) {
            JSONArray array = value.getJSONArray(key);
            return String.valueOf(array.size());
        }
        throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_METHOD);
    }

    private JSONObject extractKey(String key, JSONObject jsonObject) {
        JSONObject result = null;
        if (isArrayKey(key)) {
            int start = key.indexOf("[");
            String numberStr = key.substring(start + 1, key.length() - 1);
            result = jsonObject.getJSONArray(key.substring(0, start)).getJSONObject(Integer.parseInt(numberStr));
        } else if (isMethodKey(key)) {
            throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "结果提取函数只能在最后：" + key);
        } else {
            result = jsonObject.getJSONObject(key);
        }
        return result;
    }

    private boolean isMethodKey(String key) {
        return key.endsWith("()");
    }

    private boolean isArrayKey(String key) {
        String reg = "[\\w_0-9]+\\[\\d]";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(key);
        return matcher.matches();
    }
}
