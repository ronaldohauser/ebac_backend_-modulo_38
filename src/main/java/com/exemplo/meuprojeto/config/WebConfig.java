package com.exemplo.meuprojeto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Configura o Spring MVC para servir recursos estáticos da pasta /static
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
