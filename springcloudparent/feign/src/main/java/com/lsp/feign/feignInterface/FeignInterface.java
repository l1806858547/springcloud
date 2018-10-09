package com.lsp.feign.feignInterface;

import com.lsp.feign.configuration.FeignConfiguration;
import com.lsp.feign.hystrix.FeignInterceHystrix;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component//注入spring
@FeignClient(name="service-client",configuration=FeignConfiguration.class,fallback =FeignInterceHystrix.class)//远程服务名  configuration配置自定义feign的设置  fallback设置回掉类
public interface FeignInterface {
    /**
     * 此类中的方法和远程服务中contoller中的方法名和参数需保持一致。
     * @param name
     * @return
     */
    @RequestLine("GET /feignTest")
    public String feignTest(@RequestParam(value="name") String name);

    @RequestLine("GET /feignPostTest")
    public Object feignPostTest(Map map);
}
