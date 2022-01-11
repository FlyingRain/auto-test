package com.flyingrain.autotest;

import com.flyingrain.autotest.mvc.jersey.JerseyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{ApplicationStarter.class, JerseyConfig.class}, args);
    }

}
