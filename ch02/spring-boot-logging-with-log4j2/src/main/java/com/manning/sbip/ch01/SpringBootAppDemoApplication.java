package com.manning.sbip.ch01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAppDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(
            SpringBootAppDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppDemoApplication.class, args);
        logger.info("CourseTrackerApplication started successfully with Log4j2 configuration");
    }

}
