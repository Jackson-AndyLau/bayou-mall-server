package com.huazai.bayou.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.huazai.bayou.product.dao")
@SpringBootApplication
public class BayouMallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(BayouMallProductApplication.class, args);
    }

}
