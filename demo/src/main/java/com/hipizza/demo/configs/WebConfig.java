package com.hipizza.demo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://anton3496.c35.integrator.host")
                .allowedHeaders("*")
                .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS")
                .allowCredentials(true);
        ;

    }
}
