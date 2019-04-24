package com.example.zipkin_get.Controller;

import com.example.zipkin_get.Feign.ZipKinOneClient;
import com.example.zipkin_get.ZipkinGetApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("zkg")
public class MyController {
    @Autowired
    ZipKinOneClient zipKinOneClient;

    @RequestMapping("one")
    @ResponseBody
    public String testOne(){
        return zipKinOneClient.testOne();
    }

    @RequestMapping("two")
    @ResponseBody
    public String testTwo(){
        return zipKinOneClient.testTwo();
    }
}
