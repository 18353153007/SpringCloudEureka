package client.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cloud")
public class MyController {
    @Value("${server.port}")
    String port;

    private final static Logger logger = LoggerFactory.getLogger(MyController.class);
    @RequestMapping("/hi")
    @ResponseBody
    public String home(@RequestParam String name) {
//        try {
////            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        logger.info("hi two");
        return "hi " + name + ",i am from port:" + port;
    }

    @RequestMapping("/user")
    public Object user(@RequestParam String name) {
        Map<String, String> map = new HashMap();
        map.put("name", name);
        map.put("maptest","**************");
        return map;
    }
    @RequestMapping(value = "/user2", method = RequestMethod.POST)
    public void getUser(@RequestBody User user) {
        System.out.println(user.getId()+ " "+user.getName());
    }

    @RequestMapping("/la")
    @ResponseBody
    public String test1(@RequestParam String name) {
        System.out.println("***************************");
        return "lalala " + name + ",i am from port:" + port;
    }



//    @Value("${foo}")
//    String foo;
//    @RequestMapping(value = "/config")
//    @ResponseBody
//    public String hi(){
//        return foo;
//    }
}
