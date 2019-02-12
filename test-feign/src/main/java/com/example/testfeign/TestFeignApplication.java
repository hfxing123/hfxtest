package com.example.testfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@EnableCircuitBreaker
//@EnableTurbine
//@EnableHystrixDashboard
@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.testfeign.client" )
public class TestFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestFeignApplication.class, args);
    }

}

