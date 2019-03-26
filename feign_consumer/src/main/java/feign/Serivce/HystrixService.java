package feign.Serivce;


import feign.Controller.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hystrix",path = "/hy")
public interface HystrixService {
    @RequestMapping("/test4")
    public String test4();

}
