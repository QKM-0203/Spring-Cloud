package eurekaclientconsumer.eurekaclientconsumer.EurekaConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class OutService {
    public final RestTemplate restTemplate;

    @Autowired
    public OutService(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 消费provider-service的服务
     * @return
     */
    @GetMapping("/out")
    public String Test(){
        return restTemplate.getForObject("http://provider-service/out",String.class);
    }




}
