package com.kwater.cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class KwaterApplication {
    public static void main(String[] args) {
        SpringApplication.run(KwaterApplication.class, args);
    }
}
