package com.flyingrain.autotest.mvc.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
public class JerseyConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig resourceConfig = new ResourceConfig();
        Set<Class<?>> classes = loadResources();
        resourceConfig.registerClasses(classes);
        resourceConfig.register(AuthFilter.class);
        return resourceConfig;
    }

    private Set<Class<?>> loadResources() {
        Map<String, Resource> servers = applicationContext.getBeansOfType(Resource.class);
        Set<Class<?>> classes = new HashSet<>();
        if (!servers.isEmpty()) {
            servers.forEach((k, v) -> {
                classes.add(v.getClass());
            });
        }
        return classes;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
