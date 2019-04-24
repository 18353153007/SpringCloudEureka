package com.example.zipkin_client.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi",path = "/cloud")
public interface FeignClientOne {

    @RequestMapping("/hi")
    public String sayHi(@RequestParam(name = "name") String name);
}
