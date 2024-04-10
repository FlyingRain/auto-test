package com.flyingrain.autotest.facade.intf.source;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.model.AutoTestSourceConfig;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/autotest/sourceConfig")
@Produces(MediaType.APPLICATION_JSON)
public interface SourceConfigFacade {

    @Path("/all")
    @GET
    CommonResult<List<AutoTestSourceConfig>> allSource();
}
