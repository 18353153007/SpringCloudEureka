package feign.Serivce;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi")
public interface FeignSayHiService {
    @RequestMapping("/cloud/hi")
    public String sayHi(@RequestParam(name = "name") String name);
}
