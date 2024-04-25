package com.flyingrain.autotest.domain.core;

import com.alibaba.fastjson.JSONArray;
import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.DynamicParamTypeEnum;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.ParamValue;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.domain.utils.FunctionExecuteHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CaseExecutorHelper {

    private static final Logger logger = LoggerFactory.getLogger(CaseExecutorHelper.class);

    /**
     * 填充用例中的变量
     *
     * @param runCase
     */
    public static void fillDynamicParam(Case runCase, Map<String, String> params) {
        Service service = runCase.getService();
        if (StringUtils.hasText(runCase.getParamValue())) {
            try {
                List<ParamValue> paramValueList = JSONArray.parseArray(runCase.getParamValue()).toJavaList(ParamValue.class);
                paramValueList.forEach(paramValue -> {
                    if (!paramValue.isGlobal()) {
                        params.put(paramValue.getName(), paramValue.getValue());
                    }
                });
            } catch (Exception e) {
                logger.error("parse case paramValue failed!case value:[{}]", runCase.getParamValue());
                logger.error("exception:", e);
            }
        }
        fillService(service, params);
    }

    public static void fillService(Service service, Map<String, String> params) {
        service.setRequestUrl(replaceParam(params, service.getRequestUrl()));
        service.setHeaders(replaceParam(params, service.getHeaders()));
        service.setRequestDataModule(replaceParam(params, service.getRequestDataModule()));
    }

    public static String replaceParam(Map<String, String> params, String str) {
        if (StringUtils.hasText(str)) {
            Stack<Integer> index = new Stack<>();
            int cursor = 1;
            try {
                while (cursor < str.length()) {
                    StringBuilder temp = new StringBuilder(str);
                    if (Character.toString(str.charAt(cursor)).equals("{") && Character.toString(str.charAt(cursor - 1)).equals("$")) {
                        index.push(cursor + 1);
                        cursor++;
                    } else if (Character.toString(str.charAt(cursor)).equals("}") && !index.isEmpty()) {
                        int startIndex = index.pop();
                        String atomicParam = str.substring(startIndex, cursor);
                        String value = calculateValue(atomicParam, params);
                        if (value == null) {
                            logger.warn("atomicParam value is null![{}]", atomicParam);
                            if (temp.charAt(startIndex - 3) == '"')
                                value = "";
                            else value = "null";
                        }
                        temp.replace(startIndex - 2, cursor + 1, value);
                        str = temp.toString();
                        int resultLen = StringUtils.hasText(value) ? value.length() : 0;
                        cursor = startIndex - 2 + resultLen;
                    } else {
                        cursor++;
                    }
                }
            } catch (Exception e) {
                logger.error("replace param happen error", e);
                throw new AutoTestException(AutoTestResultCodeEnum.DYNAMIC_PARAM_ERROR);
            }
            if (!index.isEmpty()) {
                logger.error("replace param error! remain index:[{}],str:[{}]", index.pop(), str);
                throw new AutoTestException(AutoTestResultCodeEnum.DYNAMIC_PARAM_ERROR);
            }
        }
        return str;
    }

    private static String calculateValue(String atomicParam, Map<String, String> params) {
        logger.info("start to calculate atomic param:[{}]", atomicParam);
        DynamicParamTypeEnum dynamicParamTypeEnum = extractParamType(atomicParam);
        switch (dynamicParamTypeEnum) {
            case FUNCTION:
                int functionStart = atomicParam.indexOf("(");
                int functionEnd = atomicParam.indexOf(")");
                String functionName = atomicParam.substring(0, functionStart);
                String[] functionParams = null;
                if (functionStart + 1 < functionEnd) {
                    functionParams = atomicParam.substring(functionStart + 1, functionEnd).split(",");
                }
                String value = FunctionExecuteHelper.executeFunction(functionName, functionParams);
                logger.info("execute function value:[{}]", value);
                return value;
            case PARAM:
                return params.get(atomicParam);
            default:
                logger.error("not support type:[{}]", atomicParam);
                throw new AutoTestException(AutoTestResultCodeEnum.DYNAMIC_PARAM_ERROR);
        }
    }


    public static DynamicParamTypeEnum extractParamType(String param) {
        String reg = "[\\w]+\\([\\w\\d,': -]+\\)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(param);
        if (matcher.matches()) {
            return DynamicParamTypeEnum.FUNCTION;
        }
        return DynamicParamTypeEnum.PARAM;
    }


}
