package eurekaclientconsumer.eurekaclientconsumer.OpenFiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

//openfeign用在消费者，进行负载均衡，根据你写的微服务名称，查找对应的微服务下的controller的路径,
// 在消费者的接口上加上FeignClient注解，name为你想要获取的微服务的名称
@FeignClient(name = "provider-service")
@Component
public interface Feign {

    @GetMapping("/testOpenFeign")
    String getPort();

    //openfiegn默认等待服务提供方时间1秒，如果服务提供方时间超过1秒就会报错，但是在yml文件里面可以设置openfeign的等待时间，
    @GetMapping("/testOpenFeignOutTime")
    String getPort1();

    @GetMapping("/testZipkin")
    String zipkin();
}
