package gatewaydemo.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gate")
public class MyController {

    @RequestMapping("/test1")
    public String test1() {
        System.out.println("gateway Controller one");
        return "gateway Controller one";
    }

    @RequestMapping("/test2")
    public String test2() {
        return "gateway Controller fallback";
    }

}
