package eurekaclientconsumer.eurekaclientconsumer.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import eurekaclientconsumer.eurekaclientconsumer.OpenFiegn.Feign;
import eurekaclientconsumer.eurekaclientconsumer.OpenFiegn.HystrixFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class testOpenFeign {

   @Resource
   private Feign feign;
   @Resource
   private HystrixFeign hystrixFeign;

   @GetMapping("/testOpenFeign")
    public String getPort(){
      return feign.getPort();
    }


    @GetMapping("/testOpenFeignOutTime")
    public String getPort1(){
        return feign.getPort1();
    }






    //如果每个控制器都配fallbackMethod，会造成代码量大，而且耦合度太大,HystrixFeignImpl可以实现feign接口，然后实现类就是fallbackMethod,则就不用再控制器写fallbackMethod了
    @GetMapping("/hystrix1")
    public int textHystrix(){
       return hystrixFeign.textHystrix();
    }



    public String textHystrixHandler(){
       return "客户端不愿等了或者客户端异常";
    }


    @GetMapping("/testZipkin")
    public String zipkin(){
        return feign.zipkin();
    }

}
