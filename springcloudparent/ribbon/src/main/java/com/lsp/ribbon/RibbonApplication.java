package com.lsp.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }
    /**
     * Spring提供的用于访问Rest服务的客户端
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        //连接不够用的等待时间，不宜过长，必须设置，比如连接不够用时，时间过长将是灾难性的
        httpRequestFactory.setConnectionRequestTimeout(3000);
        //设置连接超时时间
        httpRequestFactory.setConnectTimeout(3000);
        //设置读超时时间，即请求处理超时时间
        httpRequestFactory.setReadTimeout(3000);
         //缓冲请求数据，默认值是true。通过POST或者PUT大量发送数据时，建议将此属性更改为false，以免耗尽内存。
        httpRequestFactory.setBufferRequestBody(false);
        return new RestTemplate(httpRequestFactory);
    }
}
