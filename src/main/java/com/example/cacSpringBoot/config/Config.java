package com.example.cacSpringBoot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Slf4j
//@Profile(value={"dev", "prod", "test"})
public class Config {

    @Bean
    @Profile("dev")
    public DataSource getDevDataSource(){
        final DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        System.out.println("Esta función devolvería las variables de config en dev");
        return dataSourceBuilder.build();
    }

    @Bean
    @Profile("prod")
    public DataSource getProdDataSource(){
        System.out.println("Esta función devolvería las variables de config en prod");
        return null;
    }
}
