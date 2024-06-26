package com.flyingrain.autotest.facade.intf.globalconfig;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.facade.intf.model.AutoTestGlobalConfig;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import com.flyingrain.autotest.mvc.jersey.AuthCheck;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/autotest/globalConfig")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface GlobalConfigFacade {


    @Path("/insert")
    @AuthCheck
    @POST
    CommonResult<Boolean> insert(AutoTestGlobalConfig autoTestGlobalConfig);

    @Path("/queryByPage")
    @POST
    CommonResult<PageableModel<AutoTestGlobalConfig>> pageQuery(PageQuery<AutoTestGlobalConfig> pageQuery);


    @Path("/update")
    @AuthCheck

    @POST
    CommonResult<Boolean> update(AutoTestGlobalConfig autoTestGlobalConfig);

    @POST
    @Path("/batchDel")
    @AuthCheck
    CommonResult<Integer> batchDel(BatchDelRequest batchDelRequest);

    @GET
    @Path("/queryAll")
    CommonResult<List<AutoTestGlobalConfig>> queryAll();

}
