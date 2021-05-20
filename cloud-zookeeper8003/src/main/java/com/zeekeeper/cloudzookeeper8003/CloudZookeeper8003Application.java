package com.zeekeeper.cloudzookeeper8003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudZookeeper8003Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudZookeeper8003Application.class, args);
    }

}
