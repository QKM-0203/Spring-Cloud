package cloudhystrix.cloudhystrix.Hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * hystrix处理延迟和容错的开源库。
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
 * 服务降级  follback   异常，超时 ，
 * 服务熔断  break  类似于保险丝达到一定的电压，就会熔断防治造成不必要的影响，然后再降级（给一个友好的提示）
 * 服务限流 flowlimit  类似于秒杀，一下子太多流量，高并发情境下，一个微服务里面的服务会相互影响的，当高并发下，tomcat的线程数不够用时，就会影响所一个微服务的所有服务
 *
 */
@RestController
@DefaultProperties(defaultFallback = "global_method")
public class Hystrix {



    @SneakyThrows
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
                    //处于打开状态的路由器多长时间就会在处于半开状态,当进入半开状态后，断路器会尝试着放过一个请求，如果成功则关闭断路器，
                    // 否则全开断路器，之后在重复打开断路器之后的操作
                    name="circuitBreaker.sleepWindowInMilliseconds",
                    value = "60000"
            ),
            //服务熔断上面4个

            //线程超时
            @HystrixProperty(
                    name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "3000"
            )

    }
    )//备用方法
    @GetMapping("/hystrix1")
    public int textHystrix(){
        try {

            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 9;
        //会去调用备用方法
        return 1;
    }


    public int backHystrix(){
        int i = 9;
        return 8;
    }



    @HystrixCommand   //@DefaultProperties(defaultFallback = "global_method")当你的HystrixCommand没有配置fallbackMethod,就直接调用默认的方法了
    public void testHystrix(){
        int i = 9/0;
    }


    public String global_method(){
        return "异常或者超时";
    }





}
