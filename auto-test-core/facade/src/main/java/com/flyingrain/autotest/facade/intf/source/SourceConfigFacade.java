package com.flyingrain.autotest.facade.intf.source;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.facade.intf.model.AutoTestSourceConfig;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/autotest/sourceConfig")
@Produces(MediaType.APPLICATION_JSON)
public interface SourceConfigFacade {

    @Path("/all")
    @GET
    CommonResult<List<AutoTestSourceConfig>> allSource();


    @POST
    @Path("/list")
    CommonResult<PageableModel<AutoTestSourceConfig>> querySourceByPage(PageQuery<AutoTestSourceConfig> pageQuery);


    @GET
    @Path("/detail")
    CommonResult<AutoTestSourceConfig> queryDetail(@QueryParam("id") int id);

    @POST
    @Path("/add")
    CommonResult<Boolean> addSource(AutoTestSourceConfig autoTestSourceConfig);

    @POST
    @Path("/update")
    CommonResult<Boolean> updateSource(AutoTestSourceConfig autoTestSourceConfig);

    @POST
    @Path("/batchDel")
    CommonResult<Integer> batchDel(List<Integer> ids);

}
