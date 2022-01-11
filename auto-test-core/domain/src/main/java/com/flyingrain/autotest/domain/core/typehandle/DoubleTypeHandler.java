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
public class DoubleTypeHandler implements TypeHandler<Double> {

    @Override
    public Double handleType(String param) {
        if (StringUtils.isEmpty(param)) {
            return null;
        }
        return Double.parseDouble(param);
    }

    @Override
    public List<TypeEnum> supportType() {
        return Arrays.asList(TypeEnum.DOUBLE, TypeEnum.FLOAT);
    }
}
