package com.kwater.cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableScheduling
@SpringBootApplication
public class KwaterApplication {

    @GetMapping("/") // ResponseEntity<? extends BasicResponse> : BasicResponse를 상속한 ?(자식 클래스)를 위한 제네릭
    public String mainResponse(){
        return  "kwater server is running";
    }

    public static void main(String[] args) {
        SpringApplication.run(KwaterApplication.class, args);
    }
}
