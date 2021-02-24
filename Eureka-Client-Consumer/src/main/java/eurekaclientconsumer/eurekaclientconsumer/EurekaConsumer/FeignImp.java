package eurekaclientconsumer.eurekaclientconsumer.EurekaConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignImp {
    private final Feign feign;

    @Autowired
    public FeignImp(@Qualifier("eurekaclientconsumer.eurekaclientconsumer.EurekaConsumer.Feign") Feign feign) {
        this.feign = feign;
    }
    @GetMapping("/out1")
    public String getPortFeign(){
       return feign.getPort()+""+9/0;
    }
}
