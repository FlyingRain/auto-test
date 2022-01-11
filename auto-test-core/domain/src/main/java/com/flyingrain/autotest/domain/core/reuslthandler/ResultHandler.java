package com.flyingrain.autotest.domain.core.reuslthandler;

import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.facade.intf.requests.DataTypeEnum;

/**
 * @author wally
 * @date 2021-12-20
 */
public interface ResultHandler {

    SendResult handleResult(SendResult result, Case runCase);

    DataTypeEnum supportType();
}
