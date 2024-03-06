package com.flyingrain.autotest.facade.intf;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/autotest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TestFacade {

    @GET
    @Path("/test")
    String test();
}
