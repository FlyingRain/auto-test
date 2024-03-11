package com.flyingrain.autotest.facade.intf.service;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.model.AutoTestService;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import com.flyingrain.autotest.mvc.jersey.AuthCheck;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/autotest/service")
@Produces(MediaType.APPLICATION_JSON)
public interface ServiceFacade {

    @POST
    @AuthCheck
    @Path("/list")
    CommonResult<PageableModel<AutoTestService>> queryServicePageable(PageQuery<AutoTestService> pageQuery);


    @POST
    @AuthCheck
    @Path("/add")
    CommonResult<Boolean> addService(AutoTestService autoTestService);


    @POST
    @AuthCheck
    @Path("/delete")
    CommonResult<Integer> batchDel(BatchDelRequest serviceBatchDelRequest);


    @POST
    @AuthCheck
    @Path("/update")
    CommonResult<Boolean> updateService(AutoTestService autoTestService);

}
