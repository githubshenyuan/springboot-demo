package com.example.springbootoauth2demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class SpringbootOauth2DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootOauth2DemoApplication.class, args);
    }
}
