package com.manning.sbip.ch02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class SpringBootAppDemoApplication implements CommandLineRunner {
public class SpringBootAppDemoApplication {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppDemoApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        // 스프링 부트 메일 클래스가 CommandLineRunner 인터페이스를 구현하여 애플리케이션 시작전 코드 수행
//        logger.info("CourseTrackerApplication CommandLineRunner has executed");
//    }
    
//    @Bean()
//    public CommandLineRunner commandLineRunner() {
//        return args -> {
//            logger.info("CommandLineRunner executed as a bean definition with " + args.length
//                + " arguments");
//            for (int i = 0; i < args.length; i++) {
//                logger.info("Argument: " + args[i]);
//            }
//        };
//    }
}
