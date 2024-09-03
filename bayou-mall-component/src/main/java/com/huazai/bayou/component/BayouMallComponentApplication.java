package com.huazai.bayou.component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BayouMallComponentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BayouMallComponentApplication.class, args);
    }

}
