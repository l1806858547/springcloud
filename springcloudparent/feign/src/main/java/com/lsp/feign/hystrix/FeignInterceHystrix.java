package com.lsp.feign.hystrix;

import com.lsp.feign.feignInterface.FeignInterface;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class FeignInterceHystrix implements FeignInterface {

    @Override
    public String feignTest(String name) {
        System.out.println("我是熔断回掉："+name);
        return null;
    }

    @Override
    public Object feignPostTest(Map map) {
        return null;
    }
}
