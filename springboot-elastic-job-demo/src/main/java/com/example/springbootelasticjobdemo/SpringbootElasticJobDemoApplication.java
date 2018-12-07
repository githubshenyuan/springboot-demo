package com.example.springbootelasticjobdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:JobConfig/applicationContent-*.xml"})
public class SpringbootElasticJobDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootElasticJobDemoApplication.class, args);
    }
}
