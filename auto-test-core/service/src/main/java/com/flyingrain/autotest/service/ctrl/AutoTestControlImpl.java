package com.flyingrain.autotest.service.ctrl;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.ctrl.AutoTestControl;
import com.flyingrain.autotest.facade.intf.requests.RunRequest;
import com.flyingrain.autotest.facade.intf.results.RunResult;
import org.springframework.stereotype.Component;

/**
 * @author wally
 * @date 2021-12-08
 */
@Component
public class AutoTestControlImpl implements AutoTestControl {


    @Override
    public CommonResult<Boolean> loadProject(String moduleCode) {
        return null;
    }

    @Override
    public CommonResult<RunResult> run(RunRequest runRequest) {
        return null;
    }

}
