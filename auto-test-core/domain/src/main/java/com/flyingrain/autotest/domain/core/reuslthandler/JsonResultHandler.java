package com.flyingrain.autotest.domain.core.reuslthandler;

import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.facade.intf.requests.DataTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wally
 * @date 2021-12-20
 */
@Component
public class JsonResultHandler implements ResultHandler {

    @Override
    public SendResult handleResult(SendResult sendResult, Case runCase) {
        if (sendResult.getOriginResult() == null || StringUtils.isEmpty(sendResult.getOriginResult().toString())) {
            return sendResult;
        }
        Map<String, Object> resultParams = JSONObject.parseObject(sendResult.getOriginResult().toString(), Map.class);
        sendResult.setResultValues(resultParams);
        sendResult.setCaseId(runCase.getId());
        return sendResult;
    }

    @Override
    public DataTypeEnum supportType() {
        return DataTypeEnum.JSON;
    }
}
