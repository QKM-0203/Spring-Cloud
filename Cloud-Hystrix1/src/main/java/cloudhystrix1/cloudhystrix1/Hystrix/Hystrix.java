package cloudhystrix1.cloudhystrix1.Hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hystrix {
    @HystrixCommand(fallbackMethod = "backHystrix1",
    commandProperties = {
            @HystrixProperty(
                    //给定的时间内方法被调用的次数
                    name="circuitBreaker.requestVolumeThreshold",
                    value = "30"
            ),
            @HystrixProperty(
                    //在给定的时间内，方法调用失败产生的百分比
                    name="circuitBreaker.errorThresholdPercentage",
                    value = "25"
            ),
            @HystrixProperty(
                    //控制请求量和错误百分比的滚动时间
                    name="metrics.rollingStats.timeInMilliseconds",
                    value = "20000"
            ),
            @HystrixProperty(
                    //处于打开状态的路由器多长时间就会在处于半开状态
                    name="circuitBreaker.sleepWindowInMilliseconds",
                    value = "60000"
            ),

    }
    )//备用方法
    @GetMapping("/hystrix2")
    public int textHystrix1(){
        int i = 9;
        //会去调用备用方法
        return 9/0;
    }

    public int backHystrix1(){
        int i = 9;
        return 8;
    }
}