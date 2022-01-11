package com.flyingrain.autotest.domain.core.executor.protocol;

import com.flyingrain.autotest.domain.constant.ProtocolTypeEnum;
import com.flyingrain.autotest.domain.core.requestHandler.SendRequest;
import com.flyingrain.autotest.domain.core.reuslthandler.SendResult;

/**
 * @author wally
 * @date 2021-12-14
 */
public interface ProtocolHandler {

    SendResult handle(SendRequest sendRequest);

    ProtocolTypeEnum handProtocol();
}
