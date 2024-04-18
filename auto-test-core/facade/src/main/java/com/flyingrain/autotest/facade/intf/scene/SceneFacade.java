package com.flyingrain.autotest.facade.intf.scene;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.facade.intf.model.AutoTestScene;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import com.flyingrain.autotest.mvc.jersey.AuthCheck;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/autotest/scene")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface SceneFacade {

    @Path("/list")
    @AuthCheck
    @POST
    CommonResult<PageableModel<AutoTestScene>> list(PageQuery<AutoTestScene> pageQuery);


    @Path("/add")
    @AuthCheck
    @POST
    CommonResult<Boolean> add(AutoTestScene autoTestScene);

    @Path("/update")
    @AuthCheck
    @POST
    CommonResult<Boolean> update(AutoTestScene autoTestScene);

    @Path("/detail")
    @AuthCheck
    @GET
    CommonResult<AutoTestScene> detail(@QueryParam("id") Integer id);


    @Path("/del")
    @AuthCheck
    @POST
    CommonResult<Boolean> delScene(@QueryParam("id") Integer sceneId);

    @Path("/run")
    @GET
    CommonResult<String> run(@QueryParam("sceneId") Integer sceneId);

}
