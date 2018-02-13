package com.brianxia.brian.DoubanBook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

    @Override

    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**").allowedOrigins("http://47.94.129.154");
        registry.addMapping("/api/**").allowedOrigins("http://localhost:1024");
    }

}
