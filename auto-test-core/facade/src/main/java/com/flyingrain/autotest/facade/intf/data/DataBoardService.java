package com.flyingrain.autotest.facade.intf.data;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.model.DataBoard;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * 数据看板
 */
@Path("/autotest/data")
@Produces(MediaType.APPLICATION_JSON)
public interface DataBoardService {

    @GET()
    @Path("/board")
    CommonResult<DataBoard> loadDataBoard();

}
