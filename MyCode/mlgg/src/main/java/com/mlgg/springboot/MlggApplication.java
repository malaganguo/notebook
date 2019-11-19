package com.mlgg.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MlggApplication {
    /**
     *  logger
     */
    private static final Logger logger = LoggerFactory.getLogger(MlggApplication.class);

    public static void main(String[] args) {
        logger.debug("springBoot started" + System.getProperty("line.separator"));

        SpringApplication.run(MlggApplication.class, args);

    }

}
