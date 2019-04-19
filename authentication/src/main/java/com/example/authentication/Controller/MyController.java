package com.example.authentication.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lcc")
public class MyController {

    @RequestMapping("/test1")
    public String tets() {
        return "test1";
    }
}
