package com.flyingrain.autotest.domain.core.typehandle;

import com.flyingrain.autotest.domain.constant.TypeEnum;

import java.util.List;

/**
 * @author wally
 * @date 2021-12-15
 */
public interface TypeHandler<T> {

    T handleType(String param);

    List<TypeEnum> supportType();
}
