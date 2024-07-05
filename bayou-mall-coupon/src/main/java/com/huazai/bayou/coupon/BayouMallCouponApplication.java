package com.huazai.bayou.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Jackson
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BayouMallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(BayouMallCouponApplication.class, args);
    }

}
