package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.model.AutoTestIn;
import com.flyingrain.autotest.facade.intf.tools.InputToOutPutFacade;
import com.flyingrain.autotest.mvc.jersey.Resource;
import org.springframework.stereotype.Component;

@Component
public class InputToOutPutFacadeImpl implements InputToOutPutFacade,Resource {


    @Override
    public CommonResult<String> inToOut(AutoTestIn autoTestIn) {
        return CommonResult.success(autoTestIn.getIn());
    }
}
