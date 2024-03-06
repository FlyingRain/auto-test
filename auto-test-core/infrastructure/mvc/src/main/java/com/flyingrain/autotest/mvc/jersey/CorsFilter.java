package com.flyingrain.autotest.mvc.jersey;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ContainerResponse;

import java.io.IOException;

/**
 * 解决跨域问题
 */
public class CorsFilter implements ContainerResponseFilter {


    public void filter(ContainerRequestContext request, ContainerResponseContext cres) throws IOException {
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {// 浏览器会先通过options请求来确认服务器是否可以正常访问，此时应放行
            cres.setStatus(HttpServletResponse.SC_OK);
        }
        cres.getHeaders().add("Access-Control-Allow-Origin", "*");

        cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization,token");
        cres.getHeaders().add("Access-Control-Allow-Credentials", "true");

        cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");

        //CORS策略的缓存时间
        cres.getHeaders().add("Access-Control-Max-Age", "1209600");

    }

}
