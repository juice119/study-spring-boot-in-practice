package com.manning.sbip.ch02.commnandline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1) // 컨포넌트 순서
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info("[Component] MyCommandLineRunner executed as a Spring Component");
    }
}
