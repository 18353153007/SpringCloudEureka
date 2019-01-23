package restribbon.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/cloud/hi?name="+name,String.class);
    }

    public String getUser(String name) {
        Object o = restTemplate.getForObject("http://SERVICE-HI/cloud/user?name="+name,Object.class);
        return "";
    }
}
