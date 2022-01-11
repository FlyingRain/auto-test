package com.flyingrain.autotest.domain.core.typehandle;

import com.flyingrain.autotest.domain.constant.TypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author wally
 * @date 2021-12-15
 */
@Component
public class IntTypeHandler implements TypeHandler<Long> {

    @Override
    public Long handleType(String param) {
        if (StringUtils.isEmpty(param)) {
            return null;
        }
        return Long.parseLong(param);
    }

    @Override
    public List<TypeEnum> supportType() {
        return Arrays.asList(TypeEnum.INT, TypeEnum.LONG, TypeEnum.SHORT);
    }
}
