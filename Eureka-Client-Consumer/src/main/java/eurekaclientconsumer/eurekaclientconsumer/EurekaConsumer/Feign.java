package eurekaclientconsumer.eurekaclientconsumer.EurekaConsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "provider-service",fallback = BackFeign.class)
public interface Feign {
    @GetMapping("/out")
    String getPort();
}
