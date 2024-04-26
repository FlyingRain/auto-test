package com.flyingrain.autotest.facade.intf.tools;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.model.AutoTestIn;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/autotest/tool")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface InputToOutPutFacade {

    @Path("/inToOut")
    @POST
    CommonResult<String>  inToOut(AutoTestIn autoTestIn);


}
