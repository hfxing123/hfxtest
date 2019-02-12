package com.example.testfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//实际上是test-ribbon，只是不能相同的name
//@FeignClient(name = "test-ribbon",fallback = HystrixClient.HystrixClientFallback.class)
@FeignClient(name = "test-ribbon1",fallback = HystrixClient.HystrixClientFallback.class)
public interface HystrixClient {


    @RequestMapping(method = RequestMethod.GET, value = "/getData1")
    String iFailSometimes();

    @Component
    class HystrixClientFallback implements HystrixClient {
        @Override
        public String iFailSometimes() {

            System.out.println("进入了iFailSometimes");

            return "fallback";
        }
    }


}
