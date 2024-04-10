package com.flyingrain.autotest.facade.intf.testcase;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.facade.intf.model.AutoTestCase;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import com.flyingrain.autotest.mvc.jersey.AuthCheck;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/autotest/case")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CaseFacade {

    @POST
    @AuthCheck
    @Path("/queryList")
    CommonResult<PageableModel<AutoTestCase>> queryCasesByPage(PageQuery<CaseQueryRequest> caseQueryRequestPageQuery);


    @POST
    @AuthCheck
    @Path("/delete")
    CommonResult<Integer> batchDel(BatchDelRequest batchDelRequest);

    @POST
    @AuthCheck
    @Path("/update")
    CommonResult<Boolean> update(AutoTestCase autoTestCase);

    @POST
    @AuthCheck
    @Path("/insert")
    CommonResult<Boolean> insert(AutoTestCase autoTestCase);

    @GET
    @Path("/detail")
    CommonResult<AutoTestCase> detail(@QueryParam("id") Integer id);

    @GET
    @Path("/start")
    CommonResult<String>  start(@QueryParam("id") Integer id);

}
