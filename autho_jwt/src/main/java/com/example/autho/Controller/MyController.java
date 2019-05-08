package com.example.autho.Controller;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/lcc")
public class MyController {

    @RequestMapping("/test1")
    public String tets() {
        return "test1";
    }

    @RequestMapping(value = "/user",produces = "application/json")
    public Map<String,Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user",user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities",AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        return userInfo;
    }

    @RequestMapping(value = "/user2",produces = "application/json")
    public OAuth2Authentication user2(OAuth2Authentication user) {
        return user;
    }

}
