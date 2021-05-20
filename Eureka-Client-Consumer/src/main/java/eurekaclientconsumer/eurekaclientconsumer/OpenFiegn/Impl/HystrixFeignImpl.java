package eurekaclientconsumer.eurekaclientconsumer.OpenFiegn.Impl;

import eurekaclientconsumer.eurekaclientconsumer.OpenFiegn.HystrixFeign;
import org.springframework.stereotype.Component;

@Component
public class HystrixFeignImpl implements HystrixFeign {
    @Override
    public int textHystrix() {
        return 0;
    }
}
