package com.flyingrain.autotest.facade.intf.scene;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.facade.intf.model.AutoTestScene;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/autotest/scene")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface SceneFacade {

    @Path("/list")
    @POST
    CommonResult<PageableModel<AutoTestScene>> list(PageQuery<AutoTestScene> pageQuery);


    @Path("/add")
    @POST
    CommonResult<Boolean> add(AutoTestScene autoTestScene);

    @Path("/update")
    @POST
    CommonResult<Boolean> update(AutoTestScene autoTestScene);

    @Path("/detail")
    @GET
    CommonResult<AutoTestScene> detail(@QueryParam("id") Integer id);


    @Path("/batchDel")
    @POST
    CommonResult<Boolean> delScene(@QueryParam("id")Integer sceneId);

}
