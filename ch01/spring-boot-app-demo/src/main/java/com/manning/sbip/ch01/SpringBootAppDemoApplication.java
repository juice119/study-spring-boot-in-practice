package com.manning.sbip.ch01;

import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringBootAppDemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(
            SpringBootAppDemoApplication.class);
        springApplication.addListeners(new ApplicationStartingEventListener());
        springApplication.run(args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyEvent(ApplicationReadyEvent readyEvent) {
        System.out.println(
            "Application Ready Event generated at" + new Date(readyEvent.getTimestamp()));
    }

}
