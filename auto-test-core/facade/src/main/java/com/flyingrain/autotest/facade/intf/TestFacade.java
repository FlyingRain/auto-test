package com.flyingrain.autotest.facade.intf;


import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.model.AutoTestIn;
import com.flyingrain.autotest.facade.intf.model.oder.ChannelCompare;
import com.flyingrain.autotest.facade.intf.model.oder.City;
import com.flyingrain.autotest.facade.intf.model.oder.SendOrder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/autotest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TestFacade {

    @GET
    @Path("/test")
    String test();

    @POST
    @Path("/receive")
    String receiveParam(AutoTestIn param);

    @POST
    @Path("/compare")
    ChannelCompare compare(SendOrder sendOrder);

    @GET
        @Path("/getRelativeCity")
    CommonResult<List<City>> getRelativeCities(@QueryParam("relativeId")Integer relativeId);

}
