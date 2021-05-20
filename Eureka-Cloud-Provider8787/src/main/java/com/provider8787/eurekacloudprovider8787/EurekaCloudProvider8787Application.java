package com.provider8787.eurekacloudprovider8787;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaCloudProvider8787Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCloudProvider8787Application.class, args);
    }

}
