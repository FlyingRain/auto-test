package com.flyingrain.autotest.domain.core.typehandle;

import com.flyingrain.autotest.domain.constant.TypeEnum;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author wally
 * @date 2021-12-15
 */
@Component
public class StringTypeHandler implements TypeHandler<String> {
    @Override
    public String handleType(String param) {
        return "\"" + param + "\"";
    }

    @Override
    public List<TypeEnum> supportType() {
        return Collections.singletonList(TypeEnum.STRING);
    }
}
