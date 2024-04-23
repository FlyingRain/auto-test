package com.flyingrain.autotest.facade.intf.tools;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.model.AutoTestAES;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/autotest/aes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AESAlgorithmFacade {

    @Path("/decrypt")
    @POST
    CommonResult<String> decryptAES(AutoTestAES autoTestAES);


    @Path("/encrypt")
    @POST
    CommonResult<String> encryptAES(AutoTestAES autoTestAES);
}
