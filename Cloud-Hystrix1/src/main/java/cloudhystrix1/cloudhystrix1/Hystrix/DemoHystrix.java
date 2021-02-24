package cloudhystrix1.cloudhystrix1.Hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoHystrix {
    @GetMapping("/demo")
    @HystrixCommand(fallbackMethod = "backDemo")
    public String demo(){
        return 8/0+"";
    }

    public String backDemo(){
        return "1";
    }
}
