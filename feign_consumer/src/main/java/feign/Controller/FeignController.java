package feign.Controller;

import feign.Serivce.FeignSayHiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cloud")
public class FeignController {
    @Autowired
    FeignSayHiService feignSayHiService;
    @RequestMapping("hi")
    @ResponseBody
    public String sayHello(String name) {
        return feignSayHiService.sayHi(name);

    }
}
