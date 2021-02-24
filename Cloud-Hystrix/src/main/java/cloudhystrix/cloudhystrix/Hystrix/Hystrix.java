package cloudhystrix.cloudhystrix.Hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 断路器模式
 * 当方法有了断路器的注解，则该方法就可以启用该模式，一旦该方法出现异常或者别的限制，断路器就会打开，就是去调用备用方法，
 * 同时在某一段时间断路器会处于半开半闭的状态，还会尝试去调用开始调用失败的方法,如果超出限制，则会处于全开状态，不再调用
 * 原来失败的方法，但是当超过设置的时间后断路器就又会处于半开的状态，就会继续尝试调用失败的方法
 *
 *
 * 每当断路器保护的方法被调用的时候，他都会征集一些调用相关的数据，将其发布到一个HTTP流中，这些数据可以实时监控正在运行中的应用的健康状况
 * HTTP流包括如下状况
 * 方法被调用多少次
 * 调用成功多少次
 * 后备方法调用了多少次
 * 方法超时多少次
 *
 *
 */
@RestController
public class Hystrix {
    @HystrixCommand(fallbackMethod = "backHystrix",
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
    @GetMapping("/hystrix1")
    public int textHystrix(){
        int i = 9;
        //会去调用备用方法
        return 9/0;
    }


    public int backHystrix(){
        int i = 9;
        return 8;
    }


}
