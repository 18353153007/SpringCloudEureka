package com.example.zipkin_client.Controller;


import brave.Span;
import brave.Tracer;
import com.example.zipkin_client.Feign.FeignClientOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/zk")
public class MyController {

    @Autowired
    FeignClientOne feignClientOne;
    @Autowired
    Tracer tracer;

    private final static Logger logger = LoggerFactory.getLogger(MyController.class);
    @RequestMapping("/one")
    @ResponseBody
    public String testone() {
        System.out.println("I am zipkin_client_one");
        return "I am zipkin_client_one";
    }

    @RequestMapping("/two")
    @ResponseBody
    public String testTwo() {

        return feignClientOne.sayHi("zipkinOne");
    }

    @RequestMapping("/three")
    @ResponseBody
    @NewSpan("mySpan")
    public String testThree() {
        logger.info("mySpan one");

        return feignClientOne.sayHi("zipkinOne");
    }

    @RequestMapping("/four")
    @ResponseBody
    @NewSpan("four")
    public String testFour(@SpanTag(key = "tagkey",value = "tagValue") String test) {

        return feignClientOne.sayHi("zipkinOne");
    }


}
