package com.flyingrain.autotest.facade.intf.user;

import com.flyingrain.autotest.facade.intf.model.AutoTestUser;
import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.requests.ModifyPassword;
import com.flyingrain.autotest.facade.intf.results.LoginResult;
import com.flyingrain.autotest.mvc.jersey.AuthCheck;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("/autotest/user")
@Produces(MediaType.APPLICATION_JSON)
public interface UserServices {


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    CommonResult<LoginResult> login( AutoTestUser autoTestUser);


    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    CommonResult<Boolean> register(@BeanParam AutoTestUser autoTestUser);


    @POST
    @AuthCheck
    @Path("/updatePassword")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    CommonResult<Boolean> modifyPassword(ModifyPassword modifyPassword);
}
