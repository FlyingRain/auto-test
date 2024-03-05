package com.flyingrain.autotest.facade.intf.user;

import com.flyingrain.autotest.facade.intf.model.AutoTestUser;
import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.requests.ModifyPassword;
import com.flyingrain.autotest.facade.intf.results.LoginResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/autotest/user")
@Produces(MediaType.APPLICATION_JSON)
public interface UserServices {


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    CommonResult<LoginResult> login(@FormParam("userName") String userName, @FormParam("password") String password);


    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    CommonResult<Boolean> register(@BeanParam AutoTestUser autoTestUser);


    @POST
    @Path("/updatePassword")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    CommonResult<Boolean> modifyPassword(ModifyPassword modifyPassword);
}
