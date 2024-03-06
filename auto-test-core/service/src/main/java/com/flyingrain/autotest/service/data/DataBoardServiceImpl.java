package com.flyingrain.autotest.service.data;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.data.DataBoardService;
import com.flyingrain.autotest.facade.intf.model.DataBoard;
import com.flyingrain.autotest.mvc.jersey.Resource;
import org.springframework.stereotype.Component;

@Component
public class DataBoardServiceImpl implements DataBoardService, Resource {
    @Override
    public CommonResult<DataBoard> loadDataBoard() {
        return CommonResult.success(new DataBoard());
    }
}
