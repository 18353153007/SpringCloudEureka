package client.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cloud")
public class MyController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    @ResponseBody
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }

    @RequestMapping("/user")
    public Object user(@RequestParam String name) {
        Map<String, String> map = new HashMap();
        map.put("name", name);
        map.put("maptest","**************");
        return map;
    }
}
