package com.flyingrain.autotest.domain.core.judge;

import com.flyingrain.autotest.domain.core.reuslthandler.SendResult;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wally
 * @date 2021-12-23
 */
@Component
public class JsonJudge implements SendResultJudge {

    private Logger logger = LoggerFactory.getLogger(JsonJudge.class);

    @Override
    public void judge(SendResult sendResult, CheckPoint checkPoint) {
        if (checkPoint == null) {
            sendResult.setSuccess(true);
            return;
        }
        Map<String, Object> resultParams = sendResult.getResultValues();
        Map<String, Object> checkData = checkPoint.getCheckData();
        if (MapUtils.isEmpty(checkData)) {
            sendResult.setSuccess(true);
            return;
        }
        for (Map.Entry<String, Object> checkDataEntry : checkData.entrySet()) {
            String key = checkDataEntry.getKey();
            Object value = checkDataEntry.getValue();
            if (judgeElement(sendResult, resultParams, key, value)) return;
        }
        sendResult.setSuccess(true);
    }

    @Override
    public JudgeTypeEnum judgeType() {
        return JudgeTypeEnum.JSON;
    }

    private boolean judgeElement(SendResult sendResult, Map<String, Object> resultParams, String key, Object value) {
        if (value instanceof Map) {
            Map<String,Object> expected = (Map<String, Object>) value;
            Object resultObject = resultParams.get(key);
            if(resultObject instanceof Map){
                Map<String,Object> newResultParams = (Map<String, Object>) resultObject;
                for (Map.Entry<String, Object> checkDataEntry : expected.entrySet()) {
                    String nextKey = checkDataEntry.getKey();
                    Object nextValue = checkDataEntry.getValue();
                    if (judgeElement(sendResult, newResultParams, nextKey, nextValue)) return true;
                }
            }else{
                sendResult.setSuccess(false);
                sendResult.setMsg("key:[" + key + "],is not expected!expect:[" + expected + "],real return [" + resultObject + "]");
                return true;
            }

        } else {
            String valueStr = String.valueOf(value);
            String resultValueStr = String.valueOf(resultParams.get(key));
            if (!valueStr.equals(resultValueStr)) {
                sendResult.setSuccess(false);
                sendResult.setMsg("key:[" + key + "],is not expected!expect:[" + valueStr + "],real return [" + resultValueStr + "]");
                return true;
            }
        }
        return false;
    }
}
