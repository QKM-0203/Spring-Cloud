package com.example.eurekaclientprovider8786;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientProvider8786Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientProvider8786Application.class, args);
    }

}
