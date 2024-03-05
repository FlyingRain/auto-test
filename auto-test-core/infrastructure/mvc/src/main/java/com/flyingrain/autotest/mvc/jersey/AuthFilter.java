package com.flyingrain.autotest.mvc.jersey;

import com.flyingrain.autotest.common.util.RunTimeContext;
import com.flyingrain.autotest.common.util.constant.AutoTestConstants;
import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.domain.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import java.io.IOException;

@PreMatching
public class AuthFilter implements ContainerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        // 在此处进行身份验证操作
        if (!isAuthenticated(containerRequestContext)) {
            containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }

    }

    private boolean isAuthenticated(ContainerRequestContext containerRequestContext) {
        String url = containerRequestContext.getUriInfo().toString();
        logger.info("url:[{}]", url);
        // 从请求头中获取认证信息，并进行认证操作
        String token = containerRequestContext.getHeaderString("token");
        ApplicationContext applicationContext = RunTimeContext.get(AutoTestConstants.CONTEXT);
        LoginService loginService = applicationContext.getBean("loginService", LoginService.class);
        User user = loginService.queryUserByToken(token);
        RunTimeContext.put(AutoTestConstants.USER, user);
        // ...
        return true; // 身份验证通过

    }
}
