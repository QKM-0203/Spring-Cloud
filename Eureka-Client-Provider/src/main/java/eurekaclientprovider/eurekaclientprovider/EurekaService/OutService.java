package eurekaclientprovider.eurekaclientprovider.EurekaService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OutService {
    @Value("${server.port}")
    String port;

    @GetMapping("/out")
    public String Test(){
        return "Port is"+port;
    }
}
