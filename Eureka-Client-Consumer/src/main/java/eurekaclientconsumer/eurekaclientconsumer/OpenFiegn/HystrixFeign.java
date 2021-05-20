package eurekaclientconsumer.eurekaclientconsumer.OpenFiegn;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import eurekaclientconsumer.eurekaclientconsumer.OpenFiegn.Impl.HystrixFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "hystrix1",fallback = HystrixFeignImpl.class)
public interface HystrixFeign {

    @GetMapping("/hystrix1")
    //有问题
    @HystrixCommand(commandProperties = {
            //线程超时
            @HystrixProperty(
                    name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "3000"  //客户端只能等后面的服务3秒否则就调用fallbackMethod.hystrix可以在客户端用，也可以在服务端用，一般在客户端用
            )
    }
    )
    public int textHystrix();

}
