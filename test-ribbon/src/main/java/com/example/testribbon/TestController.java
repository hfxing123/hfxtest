package com.example.testribbon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${server.port}")
    private String tempPort;

    @RequestMapping("/")
    public String home()
    {
        return "testRibbon1";
    }

    @RequestMapping("/getData1")
    public  String getData1()
    {
        return "端口为"+tempPort+"的testRibbon1的data1";
    }

}
