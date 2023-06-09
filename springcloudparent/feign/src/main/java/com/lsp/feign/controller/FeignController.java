package com.lsp.feign.controller;

import com.lsp.feign.feignInterface.FeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FeignController {
    @Autowired
    private FeignInterface feignInterface;

    @RequestMapping("/feignTest")
    public Object feignTest(){
        System.out.println(123);
        feignInterface.feignTest("123");
        return null;
    }
    @RequestMapping("/feignPostTest")
    public Object feignPostTest(){
        Map map=new HashMap();
        map.put("name","avs");
        map.put("sex","男");
        feignInterface.feignPostTest(map);
        return null;
    }


    @RequestMapping("/feignPostTest")
    public Object feignPostTest(){
        System.out.println(456);
        Map map=new HashMap();
        map.put("name","avs");
        map.put("sex","男");
        feignInterface.feignPostTest(map);
        return null;
    }

}
