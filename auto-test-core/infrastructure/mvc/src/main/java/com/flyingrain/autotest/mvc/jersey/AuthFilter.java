package com.flyingrain.autotest.mvc.jersey;

import com.flyingrain.autotest.common.util.RunTimeContext;
import com.flyingrain.autotest.common.util.constant.AutoTestConstants;
import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.domain.service.LoginService;
import com.flyingrain.autotest.domain.service.UserManager;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.server.ContainerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Provider
@AuthCheck
public class AuthFilter implements ContainerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    private UserManager userManager;

    @Autowired
    private LoginService loginService;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        // 在此处进行身份验证操作
        if (!isAuthenticated(containerRequestContext)) {
            containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }

    }

    private boolean isAuthenticated(ContainerRequestContext containerRequestContext) {
        String url = ((ContainerRequest) containerRequestContext).getRequestUri().toString();
        logger.info("url:[{}]", url);
        // 从请求头中获取认证信息，并进行认证操作
        if (url.contains("/login")) {
            logger.info("login request not check auth!");
            return true;
        }
        String token = containerRequestContext.getHeaderString("token");
        if (StringUtils.isEmpty(token)) {
            logger.warn("token is empty!");
            return false;
        }
        User user = loginService.queryUserByToken(token);
        if (user == null) {
            logger.error("expired token![{}]", token);
            return false;
        }
        RunTimeContext.put(AutoTestConstants.USER, user);
        return true; // 身份验证通过

    }
}
