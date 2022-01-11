package com.flyingrain.autotest.facade.intf.ctrl;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.requests.RunRequest;
import com.flyingrain.autotest.facade.intf.results.RunResult;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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


