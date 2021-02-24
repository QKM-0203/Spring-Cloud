package cloudhystrix.cloudhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/*
可以注册到注册中心，也可以不用
 */
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard

public class CloudHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixApplication.class, args);
    }


}
