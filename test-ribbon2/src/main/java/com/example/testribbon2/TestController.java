package com.example.testribbon2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private TestIntegration testIntegration;

    @RequestMapping("/")
    public String home()
    {
        return "testRibbon2";
    }

    @RequestMapping("/getData2")
    public  String getData1()
    {

        //可以传递对象过去

        return "testRibbon2的data2,获取到的数据为:   "+restTemplate.getForObject("http://test-ribbon/getData1",String.class);
    }

    @RequestMapping("/getData3")
    public String getData3()
    {

        ServiceInstance serviceInstance = this.loadBalancerClient.choose("test-ribbon");

        for(int i=0;i<10;i++)
        {
            ServiceInstance si = this.loadBalancerClient.choose("test-ribbon");

            System.out.println("第"+i+"次得到的是="+si.getUri()+","+si.getPort());
        }

        return "testRibbon2的data3,获得的数据为"+serviceInstance.getUri();
    }

    @RequestMapping("/getData4")
    public  String getData4()
    {

        Map<String,Object> temp=new HashMap<String,Object>();
        temp.put("temp",123456);

        System.out.println("返回的值为======="+testIntegration.getTest(temp));

        //可以传递对象过去
        return "调用了getData4";

    }

}
