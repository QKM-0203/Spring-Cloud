package cloudhystrix.cloudhystrix.Hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHi {

      @Value("${server.port}")
        String port;

        @RequestMapping("/hi")
        @HystrixCommand(fallbackMethod = "hiError")
        public String sayHi(@RequestParam(value = "name") String name){
            return "Hi "+name+",i am from port: "+port;
        }

        public String hiError(String name){
            return "hi,"+name+",sorry,error!";
        }

}
