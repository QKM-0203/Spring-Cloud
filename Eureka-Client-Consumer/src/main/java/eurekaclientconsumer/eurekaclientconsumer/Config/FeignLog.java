package eurekaclientconsumer.eurekaclientconsumer.Config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 配置feign的log
 */
@Configuration
public class FeignLog {
        @Bean
        Logger.Level loggerLevel(){
            return Logger.Level.FULL;
        }

}
