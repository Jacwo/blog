package com.yyl.blog;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
@RestController
@SpringBootApplication
@EnableScheduling
public class WebStart  {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(WebStart.class, args);
    }


}
