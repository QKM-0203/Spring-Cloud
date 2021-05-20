package eurekaclientconsumer.eurekaclientconsumer.OpenFiegn.Impl;

import eurekaclientconsumer.eurekaclientconsumer.OpenFiegn.Feign;
import org.springframework.stereotype.Component;

@Component
public class FeignImpl implements Feign {
    @Override
    public String getPort() {
        return null;
    }

    @Override
    public String getPort1() {
        return null;
    }

    @Override
    public String zipkin() {
        return null;
    }
}
