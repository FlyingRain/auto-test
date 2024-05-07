package com.flyingrain.autotest.facade.intf.report;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.facade.intf.model.AutoTestReport;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/autotest/report")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ReportFacade {

    @GET
    @Path("/detail")
    CommonResult<AutoTestReport> queryDetail(@QueryParam("id") Integer id);


    @POST
    @Path("/list")
    CommonResult<PageableModel<AutoTestReport>> queryReportByPage(PageQuery<AutoTestReport> autoTestReportPageQuery);

    @POST
    @Path("/update")
    CommonResult<Boolean> updateReport(AutoTestReport autoTestReport);


    @GET
    @Path("/download")
    @Produces({MediaType.APPLICATION_OCTET_STREAM})
    Response generateReportFile(@QueryParam("id") Integer id);
}
