package Com.Controller;

import Com.Service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

@Controller
@RequestMapping("/hy")
public class MyController {
    @Autowired
    HystrixService hystrixService;


    @RequestMapping("/hi")
    @ResponseBody
    public String home() {

       return hystrixService.getLcc();

    }


    @RequestMapping("/test2")
    @ResponseBody
    public String test2() {

        return hystrixService.test2();

    }

    @RequestMapping("/test3")
    @ResponseBody
    public String test3() {

        return hystrixService.test3();

    }

    @RequestMapping("/test4")
    @ResponseBody
    public String test4() {

        System.out.println("mycontroller test4 threadName:"+Thread.currentThread().getName());
        return hystrixService.test4();

    }
    @RequestMapping("/test5")
    @ResponseBody
    public String test5() {

        System.out.println("mycontroller test4 threadName:"+Thread.currentThread().getName());
        return hystrixService.test5();

    }

    @RequestMapping("/test6")
    @ResponseBody
    public String test6() {

        System.out.println("mycontroller test4 threadName:"+Thread.currentThread().getName());
        return hystrixService.test6();

    }
}


