package com.example.zipkin_get.Feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "zipkinClientOne",path = "/zk")
public interface ZipKinOneClient {
    @RequestMapping("/one")
    public String testOne() ;

    @RequestMapping("/two")
    public String testTwo() ;
}
