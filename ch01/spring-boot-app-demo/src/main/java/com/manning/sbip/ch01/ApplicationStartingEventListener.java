package com.manning.sbip.ch01;

import java.util.Date;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationStartingEventListener implements
    ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("Application Starting Event logged at" + new Date(event.getTimestamp()));
    }
}
