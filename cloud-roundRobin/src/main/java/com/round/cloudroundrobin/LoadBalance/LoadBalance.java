package com.round.cloudroundrobin.LoadBalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {
    ServiceInstance instance(List<ServiceInstance> serviceInstanceList);
}
