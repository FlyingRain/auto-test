package com.flyingrain.autotest.facade.intf.tools;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.model.AutoTestAES;
import com.flyingrain.autotest.facade.intf.model.AutoTestEncryptDecrypt;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/autotest/tool")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface EncryptDecryptFacade {

    @Path("/aes/decrypt")
    @POST
    CommonResult<String> decryptAES(AutoTestAES autoTestAES);


    @Path("/aes/encrypt")
    @POST
    CommonResult<String> encryptAES(AutoTestAES autoTestAES);


    @Path("/base64/encode")
    @POST
    CommonResult<String> base64Encode(AutoTestEncryptDecrypt autoTestEncryptDecrypt);

    @Path("/base64/decode")
    @POST
    CommonResult<String> base64Decode(AutoTestEncryptDecrypt autoTestEncryptDecrypt);


    @Path("/url/encode")
    @POST
    CommonResult<String> urlEncode(AutoTestEncryptDecrypt autoTestEncryptDecrypt);

    @Path("/url/decode")
    @POST
    CommonResult<String> urlDecode(AutoTestEncryptDecrypt autoTestEncryptDecrypt);

}
