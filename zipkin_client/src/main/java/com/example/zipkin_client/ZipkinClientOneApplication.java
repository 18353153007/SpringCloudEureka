package com.example.zipkin_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ZipkinClientOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinClientOneApplication.class, args);
    }

}
