package com.lsp.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/testRibbon" ,method = RequestMethod.GET)
    public Object testGetNameOfBlog(HttpServletRequest request){
        String url="http://service-client/test";
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<String, String>();
        paramMap.add("sex", "20180416");
        paramMap.add("age", "20180416");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(paramMap,headers);
        return restTemplate.postForObject(url,entity,String.class);
    }
}
