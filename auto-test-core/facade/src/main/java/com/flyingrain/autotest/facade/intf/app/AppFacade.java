package com.flyingrain.autotest.facade.intf.app;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.facade.intf.model.AutoTestApp;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/autotest/app")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AppFacade {

    @Path("/list")
    @POST
    CommonResult<PageableModel<AutoTestApp>> queryAppWithPage(PageQuery<AutoTestApp> queryCondition);

    @Path("/add")
    @POST
    CommonResult<Boolean> addApp(AutoTestApp autoTestApp);

    @Path("/all")
    @GET
    CommonResult<List<AutoTestApp>> queryAllApp();

    @Path("/batchDelete")
    @POST
    CommonResult<Boolean> batchDel(BatchDelRequest batchDelRequest);

}
