package com.shopperapp.ShopperApp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//@EnableJpaRepositories
public class AppConfig {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }




}
