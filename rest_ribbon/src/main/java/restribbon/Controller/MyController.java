package restribbon.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import restribbon.Service.HelloService;

@Controller
@RequestMapping("/cloud")
public class MyController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/hi")
    @ResponseBody
    public String hiService(String name) {
        return helloService.hiService(name);
    }

    @RequestMapping("/user")
    @ResponseBody
    public String getUser(String name) {
        return helloService.getUser(name);
    }
}
