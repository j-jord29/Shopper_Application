package com.shopperapp.ShopperApp;

import com.shopperapp.ShopperApp.persistence.domain.Ingredients;
import com.shopperapp.ShopperApp.persistence.domain.Recipes;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

@EnableWebMvc
@SpringBootApplication
public class ShopperAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopperAppApplication.class,args);
	}
}
