package com.provider8787.eurekacloudprovider8787;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

@SpringBootTest
class EurekaCloudProvider8787ApplicationTests {

    @Test
    void contextLoads() {
        //获取当前时区的时间
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }

}
