package com.flyingrain.autotest.domain.core.typehandle;

import com.flyingrain.autotest.domain.constant.AutoTestResultCodeEnum;
import com.flyingrain.autotest.domain.constant.TypeEnum;
import com.flyingrain.autotest.domain.exception.AutoTestException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wally
 * @date 2021-12-15
 */
@Component
public class CommonTypeHandler implements InitializingBean {

    private static String DEFAULTTYPE = "STRING";

    private Logger logger = LoggerFactory.getLogger(CommonTypeHandler.class);
    @Autowired
    private List<TypeHandler> typeHandlers;

    private final Map<String, TypeHandler> handlerMap = new HashMap<>();

    public <T> T handleType(String param, String type) {
        if (StringUtils.isEmpty(param)) {
            return null;
        }
        type = type == null ? DEFAULTTYPE : type.toUpperCase();
        TypeHandler typeHandler = handlerMap.get(type.trim());
        if (typeHandler == null) {
            logger.error("hanle type error!no type exist![{}]", type);
            throw new AutoTestException(AutoTestResultCodeEnum.NO_TYPE_HANDLE);
        }
        return (T) typeHandler.handleType(param);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (!CollectionUtils.isEmpty(typeHandlers)) {
            typeHandlers.forEach(typeHandler -> {
                List<TypeEnum> typeEnums = typeHandler.supportType();
                for (TypeEnum typeEnum : typeEnums) {
                    handlerMap.put(typeEnum.name(), typeHandler);
                }
            });
        }
    }
}
