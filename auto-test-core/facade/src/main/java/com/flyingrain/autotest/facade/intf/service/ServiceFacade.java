package com.flyingrain.autotest.facade.intf.service;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.model.AutoTestService;
import com.flyingrain.autotest.facade.intf.model.PageQuery;
import com.flyingrain.autotest.facade.intf.model.PageableModel;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/autotest/service")
@Produces(MediaType.APPLICATION_JSON)
public interface ServiceFacade {

    @GET
    @Path("/list")
    CommonResult<PageableModel<AutoTestService>> queryServicePageable(PageQuery<AutoTestService> pageQuery);


}
