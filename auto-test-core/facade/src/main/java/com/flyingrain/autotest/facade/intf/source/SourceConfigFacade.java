package com.flyingrain.autotest.facade.intf.source;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.facade.intf.model.AutoTestSourceConfig;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import com.flyingrain.autotest.mvc.jersey.AuthCheck;
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
    @AuthCheck
    @Path("/add")
    CommonResult<Boolean> addSource(AutoTestSourceConfig autoTestSourceConfig);

    @POST
    @AuthCheck
    @Path("/test")
    CommonResult<Boolean> testConnection(AutoTestSourceConfig autoTestSourceConfig);

    @POST
    @AuthCheck
    @Path("/update")
    CommonResult<Boolean> updateSource(AutoTestSourceConfig autoTestSourceConfig);

    @POST
    @AuthCheck
    @Path("/batchDel")
    CommonResult<Integer> batchDel(BatchDelRequest batchDelRequest);

}
