package com.flyingrain.autotest.domain.core.requestHandler;

import com.flyingrain.autotest.domain.core.executor.CaseResultCache;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.facade.intf.requests.DataTypeEnum;

/**
 * @author wally
 * @date 2021-12-15
 */
public interface RequestHandler {

    SendRequest buildSendRequest(Case runCase, CaseResultCache caseResultCache);

    DataTypeEnum supportType();
}
