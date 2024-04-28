package com.flyingrain.autotest.facade.intf.tools;

import com.flyingrain.autotest.common.util.CommonResult;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import java.io.InputStream;

@Path("/autotest/file")
public interface FileUploadFacade {

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    CommonResult<String> upload(@FormDataParam("file")InputStream fileInputStream, @FormDataParam("file")FormDataContentDisposition fileMetaData);
}
