package com.example.testfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="test-ribbon")
public interface TestClient {

    @RequestMapping(method = RequestMethod.GET, value = "/getData1")
    String getData1();

}
