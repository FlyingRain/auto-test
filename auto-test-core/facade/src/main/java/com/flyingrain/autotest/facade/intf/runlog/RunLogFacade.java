package com.flyingrain.autotest.facade.intf.runlog;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.facade.intf.model.AutoTestRunLog;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/autotest/runlog")
@Produces(MediaType.APPLICATION_JSON)
public interface RunLogFacade {

    @POST
    @Path("/list")
    CommonResult<PageableModel<AutoTestRunLog>> queryByPage(PageQuery<AutoTestRunLog> autoTestRunLogPageQuery);


    @GET
    @Path("/detail")
    AutoTestRunLog  queryDetail(@QueryParam("id") Integer id);


}
