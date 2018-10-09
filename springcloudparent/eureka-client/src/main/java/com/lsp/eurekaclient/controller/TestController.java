package com.lsp.eurekaclient.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/test")
    public Object test(String name, @RequestBody Map map, HttpServletRequest request){
        System.out.println(map);
        return name;
    }
    @RequestMapping("/feignTest")
    public Object feignTest(String name){
        return name;
    }
    @RequestMapping("/feignPostTest")
    public Object feignPostTest(@RequestBody Map map){
        return map;
    }
}
