package com.provider8787.eurekacloudprovider8787.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class testOpenFeign {

    @Value("${server.port}")
    private String port;

    @GetMapping("/testOpenFeign")
    public String getPort(){
      return  port;
    }


    @GetMapping("/testOpenFeignOutTime")
    public String getPort1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return  port;
    }

    @GetMapping("/testGateway/{id}")
    public String gateway(@PathVariable("id") int id){
        return "测试gateway"+id+" "+port;
    }

    @GetMapping("/testGateway/{id}/{id1}")
    public String gateway1(@PathVariable("id") int id,@PathVariable("id1")int id1){
        return "测试gateway"+id+" "+port+" "+id1;
    }

    @GetMapping("/testZipkin")
    public String zipkin(){
        return "测试Zipkin";
    }

}
