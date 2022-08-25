package com.shopperapp.ShopperApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class ShopperAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopperAppApplication.class,args);
	}
}
