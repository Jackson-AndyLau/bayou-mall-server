package com.huazai.bayou.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

/**
 * @author Jackson
 */
@SpringBootApplication
public class BayouMallCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BayouMallCommonApplication.class, args);
	}

}
