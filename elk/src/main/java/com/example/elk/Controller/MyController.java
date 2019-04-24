package com.example.elk.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/elk")
public class MyController {
    private final Logger logger = LoggerFactory.getLogger(MyController.class);
    @RequestMapping("/one")
    @ResponseBody
    public String test(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return "hello";
    }
    @RequestMapping("/springboot")
    public String Hello() {
        logger.debug("T念佛爱的解放军殴打司机开发ge");
        logger.info("This is 的解放军殴打司机开发 info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return "Hello SpringBoot!";
    }
}
