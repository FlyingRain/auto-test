package com.flyingrain.autotest.facade.intf.ctrl;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.requests.RunRequest;
import com.flyingrain.autotest.facade.intf.results.RunResult;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


/**
 * control autotest(start/stop/load)
 */
@Path("/autotest/ctl")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AutoTestControl {


    /**
     * load module
     *
     * @param projectCode
     * @return
     */
    @POST
    @Path("/load/module")
    CommonResult<Boolean> loadProject(String projectCode);


    /**
     * run test case.
     * when moduleCode is null,will only run the case which id is caseId provided.
     *
     * @param moduleCode
     * @param caseId
     * @return
     */
    @POST
    @Path("/run")
    CommonResult<RunResult> run(RunRequest runRequest);

}


