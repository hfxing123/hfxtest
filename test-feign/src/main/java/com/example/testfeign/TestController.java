package com.example.testfeign;

import com.example.testfeign.client.HystrixClient;
import com.example.testfeign.client.TestClient;
import com.example.testfeign.client.TestHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestClient testClient;

    @Autowired
    private HystrixClient hystrixClient;

    @Autowired
    private TestHystrixClient testHystrixClient;

    @RequestMapping("/")
    public String home()
    {
        return "testFeign";
    }

    @RequestMapping("/getData")
    public String getData()
    {
        //没有回退的请求
        System.out.println("获取的数据为:"+testClient.getData1());
        //有回退的请求
        System.out.println("新获取到的数据为："+hystrixClient.iFailSometimes());
        //拥有原因能回退的请求
        return "能回退的函数返回======"+testHystrixClient.iFailSometimes();

    }

}
