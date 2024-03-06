package com.flyingrain.autotest;

import com.flyingrain.autotest.common.util.RunTimeContext;
import com.flyingrain.autotest.common.util.constant.AutoTestConstants;
import com.flyingrain.autotest.mvc.jersey.JerseyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class ApplicationStarter {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationStarter.class);

    public static void main(String[] args) {
        logger.info("start autotest application...");
        ApplicationContext context = SpringApplication.run(new Class[]{ApplicationStarter.class, JerseyConfig.class}, args);
        RunTimeContext.put(AutoTestConstants.CONTEXT, context);
        logger.info("application  start success!");
    }

}
