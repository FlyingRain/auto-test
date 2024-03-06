package com.flyingrain.autotest.mvc.jersey;

import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 统一异常处理
 */
@Provider
@Component
public class CommonExceptionHandler implements ExceptionMapper<Exception> {

    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @Context
    private HttpServletRequest request;

    @Context
    private ServletContext servletContext;

    @Override
    public Response toResponse(Exception e) {
        logger.info("app happen exception!", e);
        CommonResult commonResult = new CommonResult();
        commonResult.setSuccess(false);
        if (e instanceof AutoTestException) {
            AutoTestException bizException = (AutoTestException) e;
            commonResult.setCode(bizException.getCode());
            commonResult.setMessage(bizException.getMessage());
        } else {
            commonResult.setMessage(e.getMessage());
        }
        return Response.ok(JSONObject.toJSONString(commonResult), MediaType.APPLICATION_JSON).status(200).build();

    }
}
