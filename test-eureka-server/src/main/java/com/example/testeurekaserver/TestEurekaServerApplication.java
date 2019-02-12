package com.example.testeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
@RestController
public class TestEurekaServerApplication {


    @RequestMapping("/")
    public String home()
    {
        return "hello world";
    }

    /* */
    public static void main(String[] args) {
        SpringApplication.run(TestEurekaServerApplication.class, args);
    }



}

