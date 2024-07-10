package com.huazai.bayou.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Jackson
 */
@EnableDiscoveryClient
@SpringBootApplication
public class BayouMallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BayouMallGatewayApplication.class, args);
    }

}
