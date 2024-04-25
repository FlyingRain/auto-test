package com.flyingrain.autotest.facade.intf.mysql;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.model.AutoTestMysqlOpt;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/autotest/mysql")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface MysqlOptFacade {


    @Path("/execute")
    @POST
    CommonResult<Object> executeSql(AutoTestMysqlOpt autoTestMysqlOpt);



}
