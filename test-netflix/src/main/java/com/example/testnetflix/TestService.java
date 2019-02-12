package com.example.testnetflix;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    //使用EurekaClient，不要在@PostConstruct或者@Scheduled方法中使用或者ApplicationContext可能尚未启动的任何地方，它在SmartLifecycle (with phase=0)中初始化，因此最早可以依赖它的是另一个SmartLifecycle距有更高阶级的可用
    /*
    @Autowired
    private EurekaClient discoveryClient;
    */

    @Autowired
    private DiscoveryClient discoveryClientBak;



    /*
    public String serviceUrlTemp() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("STORES", false);
        return instance.getHomePageUrl();
    }
    */

    //替代方案,为客户端提供简单的API（不特定于Netflix）
    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClientBak.getInstances("test-netflix1");
        if (list != null && list.size() > 0 ) {
            //return list.get(0).getUri();
            return list.get(0).getUri().toString();
        }
        return null;
    }

}
