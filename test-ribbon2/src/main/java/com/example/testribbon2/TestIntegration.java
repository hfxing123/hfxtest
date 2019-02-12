package com.example.testribbon2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class TestIntegration {

    @Autowired
    private RestTemplate restTemplate;

    //可以使用各种设置
    @HystrixCommand(fallbackMethod = "defaultTests"
            /*
            ,
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE") //传播安全上下文或使用Spring范围
            }
            */
    )
    public Object getTest(Map<String,Object> parameters)
    {
        //do stuff that might fail

        System.out.println("调用了getTest");

        System.out.println(parameters);

        System.out.println("在getTest里面使用,testRibbon2的data2,获取到的数据为:   "+restTemplate.getForObject("http://test-ribbon/getData1",String.class));

        System.out.println("调用了getTest后");

        return "1";
    }

    public Object defaultTests(Map<String, Object> parameters) {

        // /* something useful */

        System.out.println("调用了defaultTests");

        System.out.println(parameters);

        return "2";
    }

}
