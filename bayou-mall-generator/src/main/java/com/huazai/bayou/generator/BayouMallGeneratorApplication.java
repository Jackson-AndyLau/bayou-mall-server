package com.huazai.bayou.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@MapperScan("com.huazai.bayou.generator.dao")
public class BayouMallGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BayouMallGeneratorApplication.class, args);
	}
}
