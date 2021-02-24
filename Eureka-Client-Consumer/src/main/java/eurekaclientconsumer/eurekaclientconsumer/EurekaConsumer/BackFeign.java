package eurekaclientconsumer.eurekaclientconsumer.EurekaConsumer;

import org.springframework.stereotype.Component;

@Component
public class BackFeign  implements  Feign{

    public String getPort() {
        return "ok";
    }
}
