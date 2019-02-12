package com.example.testnetflix;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestNetflixApplication {

    @Autowired
    private TestService testService;

    @RequestMapping("/")
    public String home() {

        System.out.println(testService.serviceUrl());

        return "Hello world";
    }



    public static void main(String[] args) {
        SpringApplication.run(TestNetflixApplication.class, args);
    }

}

