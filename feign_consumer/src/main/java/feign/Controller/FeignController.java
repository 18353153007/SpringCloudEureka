package feign.Controller;

import feign.Serivce.FeignSayHiService;
import feign.Serivce.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Controller
@RequestMapping("/cloud")
public class FeignController {
    @Autowired
    FeignSayHiService feignSayHiService;
    @Autowired
    HystrixService hystrixService;
    @RequestMapping("hi")
    @ResponseBody
    public String sayHello(String name) {
        return feignSayHiService.sayHi(name);

    }

    @RequestMapping("user")
    @ResponseBody
    public void user() {
       User user = new User();
       user.setId(1);
       user.setName("abc");
       feignSayHiService.user(user);

    }

    @RequestMapping("/test4")
    @ResponseBody
    public String test(){
      return   hystrixService.test4();
    }
}
