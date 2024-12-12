package com.javaacademy.shop_chain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:application-seven.yaml", encoding = "UTF-8")
public class ShopChainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopChainApplication.class, args);
	}

}
