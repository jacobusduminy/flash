package com.flash.regapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@Profile("!test")
public class DatabaseConfig{
//
//    @Value("${spring.datasource.url}")
//    private String url;
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClassName;
//
//    @Bean
//    public DataSource dataSource() {
//        return DataSourceBuilder.create()
//                .url(url)
//                .username(username)
//                .password(password)
//                .driverClassName(driverClassName)
//                .build();
//    }
}
