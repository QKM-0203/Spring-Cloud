package com.round.cloudroundrobin.Controller;

import com.round.cloudroundrobin.LoadBalance.LoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 手写轮巡算法不用加到注册中心
 */
@RestController
public class Controller {

    private final String HOST_NAME = "provider-service";

    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalance loadBalance;


    @GetMapping("/testProvideByRound")
    public String testProvide(){

        List<ServiceInstance> instances = discoveryClient.getInstances(HOST_NAME);
        if(instances.size() == 0){
            return null;
        }
        ServiceInstance instance = loadBalance.instance(instances);
        return instance.getHost()+instance.getPort();
    }

}
